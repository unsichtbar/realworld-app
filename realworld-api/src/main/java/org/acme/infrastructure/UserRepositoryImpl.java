package org.acme.infrastructure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.application.UserRepository;
import org.acme.domain.UserDto;

import io.smallrye.mutiny.Uni;

@ApplicationScoped class UserRepositoryImpl implements UserRepository{


    @Inject UserMapper userMapper;
    @Override
    public Uni<UserDto> save(UserDto userDto) {
        
        UserEntity entity = userMapper.map(userDto);
      
        return entity.persist().map(item -> {
            
            UserDto dto = userMapper.map(entity);
            return dto;
        });
    }
    
}
