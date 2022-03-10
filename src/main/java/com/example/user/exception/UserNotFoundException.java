package com.example.user.exception;

public class UserNotFoundException extends RuntimeException {
    private String message;

    public UserNotFoundException(String str) {
        this.message = str;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
