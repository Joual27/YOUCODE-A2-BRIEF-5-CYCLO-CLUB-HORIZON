package org.youcode.cch.utils;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorMessage {
    private int statusCode;
    private String message;
    private Map<String, String> validationErrors;


    public ErrorMessage(int statusCode,String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
    public ErrorMessage(int statusCode,String message, Map<String, String> validationErrors) {
            this.statusCode = statusCode;
            this.message = message;
            this.validationErrors = validationErrors;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Map<String , String> getValidationErrors(){
        return validationErrors;
    }

}
