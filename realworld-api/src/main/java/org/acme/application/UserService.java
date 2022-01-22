package org.acme.application;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.domain.Actions;
import org.acme.domain.RegisterUserPayload;
import org.acme.domain.UserDto;
import org.acme.domain.UserRegistrationException;
import org.springframework.util.StringUtils;

import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class UserService {

    @Inject private JwtGenerator jwtGenerator;
    @Inject private UserRepository userRepository;

    @ConsumeEvent(Actions.REGISTER_USER)
    Uni<UserDto> createUser(RegisterUserPayload createUserPayload) throws InterruptedException {

        preconditions(createUserPayload);
        UserDto user = new UserDto();
        user.email(createUserPayload.email());
        user.username(createUserPayload.username());
        user.password(createUserPayload.password());
        return this.userRepository.save(user).map(item -> {

            item.token(jwtGenerator.generate(item));
            return item;
        });

    }

    String hash(String password) {
        return password;
    }

    void preconditions(RegisterUserPayload payload) {
        if (StringUtils.isEmpty(payload.password())) {
            throw new UserRegistrationException();
        }
        if (StringUtils.isEmpty(payload.username())) {
            throw new UserRegistrationException();
        }

    }

}
