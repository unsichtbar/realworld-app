package org.acme.application;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.domain.Actions;
import org.acme.domain.LoginUserPayload;
import org.acme.domain.RegisterUserPayload;
import org.acme.domain.User;
import org.acme.domain.UserLoginException;
import org.acme.domain.UserRegistrationException;
import org.springframework.util.StringUtils;

import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
public class UserService {

    @Inject private JwtGenerator jwtGenerator;
    @Inject private UserRepository userRepository;


    @ConsumeEvent(Actions.LOGIN_USER)
    Uni<User> loginUser(LoginUserPayload loginPayload) {
        
        return userRepository.findByEmail(loginPayload.email())
        .map(found -> {
            if(found.isEmpty()) {
                throw new UserLoginException();
            }
            User existing = found.get();
            if(!passwordMatches(existing.getPassword(), loginPayload.password())) {
                throw new UserLoginException();
            }
            existing.token(jwtGenerator.generate(existing));
            return existing;
        });
    }

    private boolean passwordMatches(String savePassword, String givenPassword) {

        return savePassword.equals(hash(givenPassword));
    }

    @ConsumeEvent(Actions.REGISTER_USER)
    Uni<User> createUser(RegisterUserPayload createUserPayload) throws InterruptedException {

        preconditions(createUserPayload);
        return userRepository.findByEmail(createUserPayload.email())
        .flatMap((found) -> {
            if(found.isPresent()) {
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
