package org.acme.presentation;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.acme.domain.Actions;
import org.acme.domain.LogUserInCommand;
import org.acme.domain.RegisterUserCommand;
import org.acme.domain.models.Jwt;
import org.acme.domain.models.User;
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
        RegisterUserCommand payload = new RegisterUserCommand(body.getUser().getUsername(),
                body.getUser().getPassword(), body.getUser().getEmail());

        return this.bus.<User>request(Actions.REGISTER_USER, payload).map(item -> {
            UserResponseDto response = new UserResponseDto();
            response.setUser(item.body());
            return ResponseBuilder.accepted(response).build();
        })
                .onFailure()
                .recoverWithItem((throwable) -> makeError("Something went wrong."));
    }

    @Override
    public Uni<RestResponse<UserResponseDto>> login(@Valid @NotNull LoginUserRequestDto body) {
        LogUserInCommand command = new LogUserInCommand(body.getUser().getEmail(), body.getUser().getPassword());
        return this.bus.<User>request(Actions.LOGIN_USER, command).map(item -> {
            UserResponseDto res = new UserResponseDto();
            res.setUser(item.body());
            return ResponseBuilder.ok(res).build();
        })
                .onFailure()
                .recoverWithItem((throwable) -> makeError("Something went wrong."));
    }

    private RestResponse<UserResponseDto> makeError(String message) {
        return ResponseBuilder.accepted(makeErrorBody(message)).status(422).build();
    }

    private UserResponseDto makeErrorBody(String error) {
        return (UserResponseDto) new UserResponseDto()
                .errors(new GenericErrorModelErrorsDto()
                        .body(List.of(error)));
    }

    @Override
    public Uni<UserResponseDto> updateCurrentUser(@Valid @NotNull UpdateUserRequestDto body) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Uni<RestResponse<UserResponseDto>> getCurrentUser(String token) {
        Jwt jwt = new Jwt(token);
        return this.bus.<Optional<User>>request(Actions.CURRENT_USER, jwt).map((user) -> {

            if (user.body().isEmpty()) {

                return ResponseBuilder.create(Status.UNAUTHORIZED, (UserResponseDto) null).build();
            }
            return ResponseBuilder.ok(new UserResponseDto().user(user.body().get())).build();
        });
    }

}
