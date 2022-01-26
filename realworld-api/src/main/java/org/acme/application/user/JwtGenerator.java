package org.acme.application.user;

import org.acme.domain.models.User;

public interface JwtGenerator {

    String generate(User user);

}
