package com.vibradiant.Basic.Mysql.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    private String entityName;
    private String fieldName;
    private String fieldValue;

    public EntityNotFoundException(String entityName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s : %s", entityName, fieldName, fieldValue));
        this.entityName = entityName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
