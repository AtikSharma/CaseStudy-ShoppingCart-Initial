package com.apigateway.exception;

public class ServiceUnavailableException extends RuntimeException{
    public ServiceUnavailableException(String msg)
    {
        super(msg);
    }
}
