package org.acme.domain.exceptions;

public class ArticleAlreadyExistsException extends RuntimeException {


    public ArticleAlreadyExistsException(String slug) {
        super(slug);

    }

    
    
}
