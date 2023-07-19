package com.genesys.challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class SensorExceptionHandler {
    @ExceptionHandler(value={SensorApiException.class})
    public ResponseEntity<Object> handleSensorException(SensorApiException sensorApiException){
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        SensorException sensorException = new SensorException(sensorApiException.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(sensorException, badRequest);
    }
    
}
