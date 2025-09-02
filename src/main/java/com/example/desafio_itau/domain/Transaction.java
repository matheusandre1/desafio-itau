package com.example.desafio_itau.domain;

import com.example.desafio_itau.dto.TransactionDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private BigDecimal value;
    private OffsetDateTime dataHour;

    public Transaction(TransactionDto transactionDto) {
        this.value = transactionDto.value();
        this.dataHour = transactionDto.dataHour();
    }
}
