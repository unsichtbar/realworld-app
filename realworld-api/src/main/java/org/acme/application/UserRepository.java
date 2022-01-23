package org.acme.application;

import java.util.Optional;

import org.acme.domain.User;

import io.smallrye.mutiny.Uni;

public interface UserRepository {

    Uni<User> save(User user);

    Uni<Optional<User>> findByEmail(String email);
    
}
