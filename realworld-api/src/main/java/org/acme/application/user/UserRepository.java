package org.acme.application.user;

import java.util.Optional;

import org.acme.domain.models.User;

import io.smallrye.mutiny.Uni;

public interface UserRepository {

    Uni<User> save(User user);

    Uni<Optional<User>> findByEmail(String email);

}
