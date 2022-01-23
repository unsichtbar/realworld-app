package org.acme.application.user;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.domain.Actions;
import org.acme.domain.Jwt;
import org.acme.domain.LoginUserPayload;
import org.acme.domain.RegisterUserPayload;
import org.acme.domain.User;
import org.acme.domain.UserLoginException;
import org.acme.domain.UserRegistrationException;
import org.springframework.util.StringUtils;

import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Uni;

public class UserRegistrationHandler {

    @Inject
    private JwtGenerator jwtGenerator;
    @Inject
    private UserRepository userRepository;

    @ConsumeEvent(Actions.REGISTER_USER)
    Uni<User> createUser(RegisterUserPayload createUserPayload) throws InterruptedException {

        preconditions(createUserPayload);
        return userRepository.findByEmail(createUserPayload.email())
                .flatMap((found) -> {
                    if (found.isPresent()) {
                        throw new UserRegistrationException();
                    }
                    User user = new User();
                    user.email(createUserPayload.email());
                    user.username(createUserPayload.username());
                    user.password(createUserPayload.password());
                    return this.userRepository.save(user).map(item -> {

                        item.token(jwtGenerator.generate(item));
                        return item;
                    });
                });

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
