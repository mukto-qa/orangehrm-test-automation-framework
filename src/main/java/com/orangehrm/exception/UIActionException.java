package com.orangehrm.exception;

public class UIActionException extends RuntimeException {
    public UIActionException(String message, Throwable cause) {
        super(message,  cause);
    }
}
