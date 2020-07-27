package com.ct.apac.patientmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "BadRequest")
public class InvalidCriteriaException extends RuntimeException {

    private String fieldName;

    private String messageKey;

    public InvalidCriteriaException(String fieldName, String messageKey) {
        this.fieldName = fieldName;
        this.messageKey = messageKey;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessageKey() {
        return messageKey;
    }
}
