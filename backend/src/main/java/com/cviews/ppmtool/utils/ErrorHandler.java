package com.cviews.ppmtool.utils;

import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorHandler {
    private ErrorHandler() {
        // private
    }

    public static Map<String, String> resultErrors(List<FieldError> fieldErrors) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : fieldErrors) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return errors;
    }
}
