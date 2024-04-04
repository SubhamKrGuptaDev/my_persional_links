package com.links.Personal.Links.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {

    public static <T> ResponseEntity<T> successResponse200(T result) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(result);
    }

    public static <T> ResponseEntity<T> successResponse201(T result) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(result);
    }

}
