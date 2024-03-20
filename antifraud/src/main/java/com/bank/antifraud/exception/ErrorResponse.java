package com.bank.antifraud.exception;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ErrorResponse extends RuntimeException {
    private List<String> errors;

    public ErrorResponse(List<String> errors) {
        this.errors = errors;
    }
}
