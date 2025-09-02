package com.example.desafio_itau.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransactionDto(@NotNull BigDecimal value, @NotNull @Future OffsetDateTime dataHour) {
}
