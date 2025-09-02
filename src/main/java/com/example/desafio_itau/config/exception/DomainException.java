package com.example.desafio_itau.config.exception;

public class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
