package org.acme.domain;

import org.acme.domain.annotations.CommandFor;

@CommandFor(Actions.LOGIN_USER)
public record LogUserInCommand(String email, String password) {
    
}
