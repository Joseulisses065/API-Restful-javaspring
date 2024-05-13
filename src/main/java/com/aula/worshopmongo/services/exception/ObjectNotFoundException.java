package com.aula.worshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String e) {
        super(e);
    }
}
