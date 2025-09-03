package com.example.desafio_itau.dto;


import java.util.DoubleSummaryStatistics;

public record StatisticsDto(long count, double sum, double min, double max, double average) {
    public static StatisticsDto from(DoubleSummaryStatistics stats) {
        if (stats.getCount() == 0) {
            return new StatisticsDto(0, 0, 0, 0, 0);
        }
        return new StatisticsDto(
                stats.getCount(),
                stats.getSum(),
                stats.getMin(),
                stats.getMax(),
                stats.getAverage()
        );
    }
}
