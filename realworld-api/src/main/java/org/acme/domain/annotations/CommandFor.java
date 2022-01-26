package org.acme.domain.annotations;

public @interface CommandFor {

    String value() default "";
    
}
