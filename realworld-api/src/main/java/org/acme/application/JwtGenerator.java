package org.acme.application;

import javax.enterprise.context.ApplicationScoped;

import org.acme.domain.UserDto;

public interface JwtGenerator {

    String generate(UserDto user);


    @ApplicationScoped class JwtGeneratorMockImpl implements JwtGenerator {

        @Override
        public String generate(UserDto user) {
            // TODO Auto-generated method stub
            return "abc.123.abc";
        }

    }

}
