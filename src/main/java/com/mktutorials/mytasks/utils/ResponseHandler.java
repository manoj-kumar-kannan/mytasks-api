package com.mktutorials.mytasks.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> Builder(String message, Object response, HttpStatus httpStatus) {
        Map<String, Object> result = new HashMap<>();
        result.put("message", message);
        result.put("httpStatus", httpStatus.value());
        result.put("timestamp", new Date());
        result.put("data", response);
        return new ResponseEntity<>(result, httpStatus);
    }
}
