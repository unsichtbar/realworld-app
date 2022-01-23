package org.acme.infrastructure.jwt;

import javax.enterprise.context.ApplicationScoped;

import org.acme.application.user.JwtGenerator;
import org.acme.domain.User;

import net.bytebuddy.utility.RandomString;

@ApplicationScoped class JwtGeneratorMockImpl implements JwtGenerator {

    @Override
    public String generate(User user) {
        // TODO Auto-generated method stub
        return RandomString.make(10);
    }

}

