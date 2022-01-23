package org.acme.infrastructure;

import org.mapstruct.Mapper;

import io.smallrye.mutiny.Uni;

import java.util.Optional;

import org.acme.domain.*;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    User map(UserEntity entity);

    UserEntity map(User dto);

    
}
