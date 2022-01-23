package org.acme.application;

import javax.enterprise.context.ApplicationScoped;

import org.acme.domain.User;

import io.quarkus.runtime.util.StringUtil;
import net.bytebuddy.utility.RandomString;

public interface JwtGenerator {

    String generate(User user);


    @ApplicationScoped class JwtGeneratorMockImpl implements JwtGenerator {

        @Override
        public String generate(User user) {
            // TODO Auto-generated method stub
            return RandomString.make(10);
        }

    }

}
