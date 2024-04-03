package com.links.Personal.Links.exception;

import org.hibernate.id.CompositeNestedGeneratedValueGenerator;

public class GlobalException extends RuntimeException {

    public GlobalException() {
        super("Invalid Data");
    }

    public GlobalException(String msg) {
        super(msg);
    }

}
