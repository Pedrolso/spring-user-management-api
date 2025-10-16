package com.exercise.spring001.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice//Cuida globalmente de todas os erros que acontecerem nos meus controllers.
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFound.class)//Quando uma exceção do tipo UserException acontecer, execute o metodo abaixo
    public ResponseEntity<ErrorResponse> userNotFOund(UserNotFound ex) {
        ErrorResponse error = new ErrorResponse(
                "User Not found. ----GLOBAL",
                ex.getMessage(),
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(UserConflictException.class)
    public ResponseEntity<ErrorResponse> userConflict(UserConflictException ex) {
        ErrorResponse error = new ErrorResponse(
                "Email already exists. ----GLOBAL",
                ex.getMessage(),
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value()
        );

        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorResponse> genericError(UserException ex) {
        ErrorResponse error = new ErrorResponse(
                "Internal Server Error. ----GLOBAL",
                ex.getMessage(),
                LocalDateTime.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

}
