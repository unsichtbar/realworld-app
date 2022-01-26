package org.acme.infrastructure;

import org.acme.domain.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
interface UserMapper {

    User map(UserEntity entity);

    UserEntity map(User dto);

    
}
