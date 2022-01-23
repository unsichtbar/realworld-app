package org.acme.infrastructure;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

import io.smallrye.mutiny.Uni;

@Entity
@Table(name = "realworld_users",uniqueConstraints=
@UniqueConstraint(columnNames={"username"}))

public class UserEntity extends PanacheEntity {

    @Column(name = "username")
    
    private String username;
    private String password;
    private String email;
    


    public String getPassword() {
        return password;
    }




    public void setPassword(String password) {
        this.password = password;
    }




    public String getEmail() {
        return email;
    }




    public void setEmail(String email) {
        this.email = email;
    }




    public String getUsername() {
        return username;
    }




    public void setUsername(String username) {
        this.username = username;
    }




    public static Uni<UserEntity> findByUsername(String username) {
        return find("username", username).firstResult();
    }

    public static Uni<Optional<UserEntity>> findByEmail(String email) {
        
        return find("email", email).firstResult().map(item -> {
            UserEntity entity = (UserEntity) item;

            return Optional.ofNullable(entity);
        });
        
    }
    
}
