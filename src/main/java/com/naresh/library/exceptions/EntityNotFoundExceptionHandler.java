package com.naresh.library.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.AbstractMap;

@ControllerAdvice
@Component
public class EntityNotFoundExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(com.naresh.library.exceptions.EntityNotFoundExceptionHandler.class);

    /**
     * Exception handler for EntityNotFound exceptions.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<AbstractMap.SimpleEntry<String, String>> handle(EntityNotFoundException exception) {
        LOG.error("Exception: Unable to process this request. ", exception);
        AbstractMap.SimpleEntry<String, String> response =
                new AbstractMap.SimpleEntry<>("message", exception.message);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
