package com.links.Personal.Links.exception;

import com.links.Personal.Links.entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // TODO Exception Handler
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> getGlocalException(GlobalException globalException) {
        return new ResponseEntity<>(new ErrorResponse(400, globalException.getMessage()),
                HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> getException(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse(400, ex.getMessage()),
                HttpStatus.BAD_REQUEST);
    }

}
