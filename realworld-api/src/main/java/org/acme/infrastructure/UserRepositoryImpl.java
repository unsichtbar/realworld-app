package org.acme.infrastructure;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.acme.application.user.UserRepository;
import org.acme.domain.models.User;

import io.smallrye.mutiny.Uni;

@ApplicationScoped class UserRepositoryImpl implements UserRepository {


    @Inject UserMapper userMapper;
    @Override
    public Uni<User> save(User userDto) {
        
        UserEntity entity = userMapper.map(userDto);
        return entity.persistAndFlush().map(item -> {
            if(item == null) throw new RuntimeException("Unable to save the user.");
            return userMapper.map(entity);
        });
    }
    @Override
    public Uni<Optional<User>> findByEmail(String email) {
        return UserEntity.findByEmail(email).map(item -> {
            return item.map(userMapper::map);
        });

    }
    
}
