package com.example.desafio_itau.controller;

import com.example.desafio_itau.service.TransationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final TransationService statisticsController;

    public StatisticsController(TransationService statisticsController) {
        this.statisticsController = statisticsController;
    }


    @GetMapping
    public Object getStatistics(OffsetDateTime OffsetDateTime)
    {
        return statisticsController.getStatistics(OffsetDateTime);
    }

}
