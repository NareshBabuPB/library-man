package com.naresh.library.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public String message;

    public EntityNotFoundException(String message) {
        this.message = message;
    }

}
