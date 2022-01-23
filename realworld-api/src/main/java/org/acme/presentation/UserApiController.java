package org.acme.presentation;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.acme.domain.Actions;
import org.acme.domain.LoginUserPayload;
import org.acme.domain.RegisterUserPayload;
import org.acme.domain.User;
import org.acme.presentation.openapitools.api.UserApi;
import org.acme.presentation.openapitools.api.UsersApi;
import org.acme.presentation.openapitools.model.GenericErrorModelDto;
import org.acme.presentation.openapitools.model.GenericErrorModelErrorsDto;
import org.acme.presentation.openapitools.model.LoginUserRequestDto;
import org.acme.presentation.openapitools.model.NewUserRequestDto;
import org.acme.presentation.openapitools.model.UpdateUserRequestDto;
import org.acme.presentation.openapitools.model.UserResponseDto;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;
import org.jboss.resteasy.reactive.RestResponse.Status;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.EventBus;

@RequestScoped
class UserApiController implements UserApi, UsersApi {

    @Inject
    private EventBus bus;

    @Override
    public Uni<RestResponse<UserResponseDto>> createUser(@Valid @NotNull NewUserRequestDto body) {
        RegisterUserPayload payload = new RegisterUserPayload(body.getUser().getUsername(),
                body.getUser().getPassword(), body.getUser().getEmail());

        return this.bus.<User>request(Actions.REGISTER_USER, payload).map(item -> {
            UserResponseDto response = new UserResponseDto();
            response.setUser(item.body());
            return ResponseBuilder.accepted(response).build();
        }).onFailure()
                .recoverWithItem((throwable) -> ResponseBuilder.accepted((UserResponseDto) new UserResponseDto()
                        .errors(new GenericErrorModelErrorsDto()
                                .body(List.of("Something went wrong"))))
                                .status(422)
                        .build());
    }

    @Override
    public Uni<RestResponse<UserResponseDto>> login(@Valid @NotNull LoginUserRequestDto body) {
        LoginUserPayload command = new LoginUserPayload(body.getUser().getEmail(), body.getUser().getPassword());
        return this.bus.<User>request(Actions.LOGIN_USER, command).map(item -> {
            UserResponseDto res = new UserResponseDto();
            res.setUser(item.body());
            return ResponseBuilder.ok(res).build();
        });
    }

    @Override
    public Uni<UserResponseDto> getCurrentUser() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Uni<UserResponseDto> updateCurrentUser(@Valid @NotNull UpdateUserRequestDto body) {
        // TODO Auto-generated method stub
        return null;
    }

}
