package com.genesys.challenge.exception;

public class SensorApiException extends RuntimeException{
    public SensorApiException(String message){
        super(message);
    }
    public SensorApiException(String message, Throwable cause){
        super(message, cause);
    }
    
}
