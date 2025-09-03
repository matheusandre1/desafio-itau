package com.example.desafio_itau.service;

import com.example.desafio_itau.config.exception.DomainException;
import com.example.desafio_itau.domain.Transaction;
import com.example.desafio_itau.dto.TransactionDto;
import com.example.desafio_itau.repository.TransationRepository;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

@Service
public class TransationService {

    private final TransationRepository transationRepository;
    public TransationService(TransationRepository transationRepository){
        this.transationRepository = transationRepository;
    }


    public Transaction realizedTransaction(TransactionDto transactionDto) {

        if (transactionDto.value().doubleValue() <= 0) {
            throw new DomainException("Valor não pode ser menor que zero");
        }
        Transaction transaction = new Transaction(transactionDto);
        transationRepository.save(transaction);
        return transaction;
    }

    public void deleteAll() {
        transationRepository.deleteAll();
    }

    public DoubleSummaryStatistics getStatistics(OffsetDateTime minutes60Ago) {
        return transationRepository.getStatistics(minutes60Ago);
    }
}
