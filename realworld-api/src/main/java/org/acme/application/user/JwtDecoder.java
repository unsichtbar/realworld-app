package org.acme.application.user;

import org.acme.domain.Jwt;

public interface JwtDecoder {

    String decodeEmail(Jwt jwt);
    
}
