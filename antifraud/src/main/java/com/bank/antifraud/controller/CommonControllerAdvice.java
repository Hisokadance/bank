package com.bank.antifraud.controller;

import com.bank.antifraud.exception.CommonError;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class CommonControllerAdvice {
    @ApiResponse(responseCode = "404", description = "Обьект не найден")
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<CommonError> handleEntityNotFoundException(NoSuchElementException ex) {
        return ResponseEntity.status(NOT_FOUND).body(makeError("Объект не найден: " + ex.getMessage()));
    }

    @ApiResponse(responseCode = "500", description = "Проблема на стороне сервера")
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleOtherExceptions(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ой-ой, что-то пошло не так: " + ex.getMessage());
    }

    public CommonError makeError(String error) {
        return new CommonError()
                .setError(error);
    }
}
