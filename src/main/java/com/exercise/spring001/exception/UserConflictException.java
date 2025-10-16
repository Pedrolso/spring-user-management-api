package com.exercise.spring001.exception;

public class UserConflictException extends RuntimeException {
    public UserConflictException(String message) {

        super(message);
    }
}
