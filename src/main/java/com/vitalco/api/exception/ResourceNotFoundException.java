package com.vitalco.api.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName, Object resourceId) {
        super(resourceName + " with id " + resourceId + " not found");
    }
}
