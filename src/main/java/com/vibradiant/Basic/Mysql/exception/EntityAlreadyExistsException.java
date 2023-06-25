package com.vibradiant.Basic.Mysql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class EntityAlreadyExistsException extends RuntimeException {
    private String message;

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
