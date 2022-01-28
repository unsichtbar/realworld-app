package org.acme.application.user;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.acme.application.Handler;
import org.acme.domain.Actions;
import org.acme.domain.RegisterUserCommand;
import org.acme.domain.exceptions.UserRegistrationException;
import org.acme.domain.models.User;
import org.springframework.util.StringUtils;

import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Uni;

@ApplicationScoped class UserRegistrationHandler implements Handler<User, RegisterUserCommand> {

    @Inject
    private JwtGenerator jwtGenerator;
    @Inject
    private UserRepository userRepository;

    @ConsumeEvent(Actions.REGISTER_USER)
    @Transactional
    public Uni<User> handle(RegisterUserCommand createUserPayload) {

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

    void preconditions(RegisterUserCommand payload) {
        if (StringUtils.isEmpty(payload.password())) {
            throw new UserRegistrationException();
        }
        if (StringUtils.isEmpty(payload.username())) {
            throw new UserRegistrationException();
        }

    }

}
