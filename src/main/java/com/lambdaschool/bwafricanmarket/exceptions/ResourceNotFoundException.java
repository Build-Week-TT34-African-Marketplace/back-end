package com.lambdaschool.bwafricanmarket.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super("Error from application" + message);
    }
}
