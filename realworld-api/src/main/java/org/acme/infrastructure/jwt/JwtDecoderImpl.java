package org.acme.infrastructure.jwt;

import javax.enterprise.context.ApplicationScoped;

import org.acme.application.user.JwtDecoder;
import org.acme.domain.Jwt;

@ApplicationScoped class JwtDecoderImpl implements JwtDecoder{

    @Override
    public String decodeEmail(Jwt jwt) {
        // TODO Auto-generated method stub
        return "stub";
    }
    
}
