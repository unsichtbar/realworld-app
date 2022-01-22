package org.acme.application;

import org.acme.domain.UserDto;

import io.smallrye.mutiny.Uni;

public interface UserRepository {

    Uni<UserDto> save(UserDto user);
    
}
