package com.genesys.challenge.exception;

import org.springframework.http.HttpStatus;

public class SensorException {
    private String message;
    private HttpStatus httpStatus;
    public SensorException(String message, HttpStatus httpStatus){
        this.message = message;

        this.httpStatus = httpStatus;
    }

public String getMessage(){
    return message;
}


public HttpStatus getHttpStatus(){
    return httpStatus;
}

}
