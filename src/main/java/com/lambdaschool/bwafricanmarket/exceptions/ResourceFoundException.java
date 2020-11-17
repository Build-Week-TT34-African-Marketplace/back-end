package com.lambdaschool.bwafricanmarket.exceptions;

public class ResourceFoundException extends RuntimeException{
    public ResourceFoundException(String message){
        super("Error from application" + message);
    }
}
