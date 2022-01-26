package org.acme.domain;

import org.acme.domain.annotations.CommandFor;

@CommandFor(Actions.REGISTER_USER)
public record RegisterUserCommand(String username, String password, String email) {


}
