package org.acme.infrastructure;

import org.mapstruct.Mapper;
import org.acme.domain.*;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    UserDto map(UserEntity entity);

    UserEntity map(UserDto dto);
    
}
