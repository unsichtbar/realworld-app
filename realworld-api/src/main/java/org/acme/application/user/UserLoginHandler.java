package org.acme.application.user;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.domain.LogUserInCommand;
import org.acme.domain.exceptions.UserLoginException;
import org.acme.domain.models.User;

import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Uni;
import org.acme.domain.Actions;

@ApplicationScoped
class UserLoginHandler {

    @Inject
    UserRepository userRepository;
    @Inject
    JwtGenerator jwtGenerator;

    @ConsumeEvent(Actions.LOGIN_USER)
    Uni<User> loginUser(LogUserInCommand loginPayload) {

        return userRepository.findByEmail(loginPayload.email())
                .map(found -> {
                    if (found.isEmpty()) {
                        throw new UserLoginException();
                    }
                    User existing = found.get();
                    if (!passwordMatches(existing.getPassword(), loginPayload.password())) {
                        throw new UserLoginException();
                    }
                    existing.token(jwtGenerator.generate(existing));
                    return existing;
                });
    }

    private boolean passwordMatches(String savePassword, String givenPassword) {

        return savePassword.equals(hash(givenPassword));
    }

    private String hash(String password) {
        return password;
    }

}
