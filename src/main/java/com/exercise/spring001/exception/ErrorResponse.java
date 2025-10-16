package com.exercise.spring001.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor

public class ErrorResponse {

    private String error;
    private String message;
    private LocalDateTime timestamp;
    private int status;

    /*
    Um extra para detalhar mais o erro. Tem que add no GlobalExceptionHandler tbm.

    private String path;
    private String errorCode;
    */
}
