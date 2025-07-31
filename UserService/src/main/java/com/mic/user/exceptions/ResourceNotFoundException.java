package com.mic.user.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        super("message.resource.not.found");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
    
}
