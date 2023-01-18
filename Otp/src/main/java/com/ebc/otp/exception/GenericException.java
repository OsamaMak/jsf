package com.ebc.otp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception returned when any exception happened
 */
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error while generating otp")
public class GenericException extends RuntimeException {

    /**
     *
     */
    public GenericException(Exception ex){
        super();
    }
     public GenericException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    private static final long serialVersionUID = -5999242826577715295L;

    public GenericException(final String message) {
        super(message);
    }

}
