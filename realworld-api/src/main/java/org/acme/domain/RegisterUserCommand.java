package org.acme.domain;

import org.acme.domain.annotations.CommandFor;
import org.acme.domain.models.User;


@CommandFor(Actions.REGISTER_USER)
public record RegisterUserCommand(String username, String password, String email) implements Message<User> {


}
