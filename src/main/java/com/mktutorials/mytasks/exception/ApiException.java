package com.mktutorials.mytasks.exception;

import com.mktutorials.mytasks.constant.AppConstant;
import com.mktutorials.mytasks.utils.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ApiException extends RuntimeException {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(RuntimeException exception) {
        return ResponseHandler.Builder(
                AppConstant.ERROR_RESPONSE_MESSAGE, exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseHandler.Builder(AppConstant.ERROR_RESPONSE_MESSAGE, errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<?> handleFallbackException(Exception ex) {
        return ResponseHandler.Builder(
                AppConstant.ERROR_RESPONSE_MESSAGE, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
