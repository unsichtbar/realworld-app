package org.acme.application.user;

import org.acme.domain.models.Jwt;

public interface JwtDecoder {

    String decodeEmail(Jwt jwt);
    
}
