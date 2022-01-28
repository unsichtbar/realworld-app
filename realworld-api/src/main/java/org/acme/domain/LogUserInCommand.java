package org.acme.domain;

import org.acme.domain.annotations.CommandFor;
import org.acme.domain.models.User;

@CommandFor(Actions.LOGIN_USER)
public record LogUserInCommand(String email, String password) implements Message<User> {
    
}
