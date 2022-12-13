package com.ogunladetaiye.automaticirrigationsystem.exception;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConstraintViolation {
    private String fieldName;
    private String message;
    private String rejectedValue;
}
