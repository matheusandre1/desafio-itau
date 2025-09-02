package com.example.desafio_itau.controller;

import com.example.desafio_itau.config.exception.ErrorResponse;
import com.example.desafio_itau.dto.TransactionDto;
import com.example.desafio_itau.service.TransationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransationService transationService;
    public TransactionController (TransationService transationService){
        this.transationService = transationService;
    }


    @PostMapping
    public ResponseEntity<TransactionDto> realizedTransaction(@RequestBody TransactionDto transactionDto)
    {
        var transation = transationService.realizedTransaction(transactionDto);

        return ResponseEntity.created(null).body(transactionDto);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll()
    {
        transationService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
