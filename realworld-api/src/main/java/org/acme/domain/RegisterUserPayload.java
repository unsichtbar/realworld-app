package org.acme.domain;

public record RegisterUserPayload(String username, String password, String email) {
    
}
