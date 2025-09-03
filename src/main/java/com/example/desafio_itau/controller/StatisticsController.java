package com.example.desafio_itau.controller;

import com.example.desafio_itau.dto.StatisticsDto;
import com.example.desafio_itau.service.TransationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final TransationService statisticsController;

    public StatisticsController(TransationService statisticsController) {
        this.statisticsController = statisticsController;
    }


    @GetMapping
    @Operation(summary = "Busca as estatísticas das transações dos últimos 60 segundos")
    public StatisticsDto getStatistics()
    {
        OffsetDateTime minutes60Ago = OffsetDateTime.now().minusSeconds(60);
        DoubleSummaryStatistics stats = statisticsController.getStatistics(minutes60Ago);
        return StatisticsDto.from(stats);
    }

}
