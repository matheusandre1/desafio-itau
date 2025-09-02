package com.example.desafio_itau.config.exception;

import java.time.OffsetDateTime;

public record ErrorResponse(int value, String error, String message, String path, OffsetDateTime timestamp) {
}
