package com.takeandgo.takeandgo.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {EntityException.class})
    protected ResponseEntity<Object> entityException(final RuntimeException runtimeException, final WebRequest webRequest){
        final String bodyOfResponse = runtimeException.getMessage();
        return handleExceptionInternal(runtimeException, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, webRequest);
    }
//    @ExceptionHandler(value = {EntityAlreadyExists.class})
//    protected ResponseEntity<Object> entityAlreadyExists(final RuntimeException runtimeException, final WebRequest webRequest){
//        final String bodyOfResponse = runtimeException.getMessage();
//        return handleExceptionInternal(runtimeException, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
//    }
//    @ExceptionHandler(value = {IncorrectInput.class})
//    protected ResponseEntity<Object> incorrectInput(final RuntimeException runtimeException, final WebRequest webRequest){
//        final String bodyOfResponse = runtimeException.getMessage();
//        return handleExceptionInternal(runtimeException, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
//    }
}

