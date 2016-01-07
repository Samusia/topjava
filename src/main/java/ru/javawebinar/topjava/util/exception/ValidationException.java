package ru.javawebinar.topjava.util.exception;

import org.springframework.validation.BindingResult;

/**
 * Created by Samusia
 * on 07.01.2016.
 */
public class ValidationException extends RuntimeException {

    public ValidationException(BindingResult result) {
        super(getDescription(result));
    }

    private static String getDescription(BindingResult result) {
        StringBuilder sb = new StringBuilder();
        result.getFieldErrors().forEach(fe -> sb.append(fe.getField()).append(" ").append(fe.getDefaultMessage()).append("<br>"));
        return sb.toString();
    }
}
