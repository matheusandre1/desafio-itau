package com.example.desafio_itau.config.exception.handleError;

import com.example.desafio_itau.config.exception.DomainException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class HandleErrors {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity handleError422()
    {
        return ResponseEntity.unprocessableEntity().build();
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    public ResponseEntity handleError400()
    {
        return ResponseEntity.badRequest().build();
    }

    private record DataValidationErrors(String field, String message)
    {
        public DataValidationErrors(FieldError fieldError)
        {
            this(fieldError.getField(),fieldError.getDefaultMessage());
        }
    }
}
