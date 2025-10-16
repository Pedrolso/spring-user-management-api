package com.exercise.spring001.exception;

public class UserNotFound extends RuntimeException {
    public UserNotFound(String message) {

        super(message);
    }
}
