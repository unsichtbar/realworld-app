package org.acme.application.user;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.domain.Actions;
import org.acme.domain.Jwt;
import org.acme.domain.User;

import io.quarkus.vertx.ConsumeEvent;
import io.smallrye.mutiny.Uni;

@ApplicationScoped
class GetCurrentUserHandler {

    @Inject
    private UserRepository userRepository;
    @Inject
    private JwtDecoder jwtDecoder;

    @ConsumeEvent(Actions.CURRENT_USER)
    Uni<Optional<User>> getUserFromToken(Jwt jwt) {
        String email = jwtDecoder.decodeEmail(jwt);
        return this.userRepository.findByEmail(email);
    }

}
