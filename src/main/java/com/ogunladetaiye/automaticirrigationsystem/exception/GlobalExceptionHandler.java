package com.ogunladetaiye.automaticirrigationsystem.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice("com.ogunladetaiye.automaticirrigationsystem")
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleIllegalArgumentException(
            IllegalArgumentException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        List<ConstraintViolation> errors = exception.getFieldErrors()
                .stream()
                .map(violation -> ConstraintViolation.builder()
                        .message(violation.getDefaultMessage())
                        .fieldName(violation.getField())
                        .rejectedValue(Objects.isNull(violation.getRejectedValue()) ?
                                "null" :
                                violation.getRejectedValue().toString())
                        .build())
                .collect(Collectors.toList());
        return ErrorResponse.builder()
                .message("Validation failed with errors!")
                .errors(errors)
                .build();
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ErrorResponse handleAllExceptions(Exception exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(PlotOfLandNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorResponse handlePlotOfLandNotFoundException(Exception exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .build();
    }
}