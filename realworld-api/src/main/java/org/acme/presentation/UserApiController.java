package org.acme.presentation;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.acme.domain.Actions;
import org.acme.domain.RegisterUserPayload;
import org.acme.domain.UserDto;
import org.acme.presentation.openapitools.api.UserApi;
import org.acme.presentation.openapitools.api.UsersApi;
import org.acme.presentation.openapitools.model.LoginUserRequestDto;
import org.acme.presentation.openapitools.model.NewUserRequestDto;
import org.acme.presentation.openapitools.model.UpdateUserRequestDto;
import org.acme.presentation.openapitools.model.UserResponseDto;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.EventBus;

@RequestScoped
class UserApiController implements UserApi, UsersApi {

    @Inject
    private EventBus bus;

    @Override
    public Uni<UserResponseDto> createUser(@Valid @NotNull NewUserRequestDto body) {
        RegisterUserPayload payload = new RegisterUserPayload(body.getUser().getUsername(),
                body.getUser().getPassword(), body.getUser().getEmail());
        
        return this.bus.<UserDto>request(Actions.REGISTER_USER, payload).map(item -> {
            UserResponseDto response = new UserResponseDto();
            response.setUser(item.body());
            return response;
        });
    }

    @Override
    public Uni<UserResponseDto> login(@Valid @NotNull LoginUserRequestDto body) {
        // TODO Auto-generated method stub
        return null;
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
