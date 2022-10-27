package com.bits.m2.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class RapidGlobalWebExceptionHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(value = { RapidGenericException.class })
    protected ResponseEntity<Object> handleRapidGenericException(RuntimeException cxyException, WebRequest request) {
        logger.error("Rapid generic exception thrown - > " + cxyException.getMessage(), cxyException);
        return new ResponseEntity<>(cxyException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handleGenericException(RuntimeException cxyException, WebRequest request) {
        logger.error("Rapid generic exception thrown - > " + cxyException.getMessage(), cxyException);
        return new ResponseEntity<>(cxyException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
