package org.acme.application.user;

import org.acme.domain.User;

public interface JwtGenerator {

    String generate(User user);

}
