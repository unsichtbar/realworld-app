package org.acme.application;

import javax.enterprise.context.ApplicationScoped;

import org.acme.domain.Jwt;

@ApplicationScoped class JwtDecoder {

    String decodeEmail(Jwt jwt) {
        return "stub";
    }
    
}
