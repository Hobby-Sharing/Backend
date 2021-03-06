package com.hobby.sharing.global.error.exception;

import com.hobby.sharing.global.error.response.BasicErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static com.hobby.sharing.global.error.ErrorCode.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    private ResponseEntity<BasicErrorResponse> handleGlobalException(GlobalException e) {
        BasicErrorResponse response = new BasicErrorResponse(e.getErrorCode());
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<BasicErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        final BasicErrorResponse response = new BasicErrorResponse(INVALID_INPUT_VALUE);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    private ResponseEntity<?> handleBindException(BindException e) {
        Map<String, String> errorMap = new HashMap<>();

        for (FieldError error : e.getFieldErrors()) {
            errorMap.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    private ResponseEntity<BasicErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        final BasicErrorResponse response = new BasicErrorResponse(METHOD_NOT_ALLOWED);
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(AccessDeniedException.class)
    private ResponseEntity<BasicErrorResponse> handleAccessDeniedException(AccessDeniedException e) {
        final BasicErrorResponse response = new BasicErrorResponse(HANDLE_ACCESS_DENIED);
        return new ResponseEntity<>(response, HttpStatus.valueOf(HANDLE_ACCESS_DENIED.getStatus()));
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<BasicErrorResponse> handleException(Exception e) {
        final BasicErrorResponse response = new BasicErrorResponse(INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
