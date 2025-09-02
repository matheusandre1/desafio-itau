package com.example.desafio_itau.repository;

import com.example.desafio_itau.domain.Transaction;
import org.springframework.stereotype.Repository;


import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Repository
public class TransationRepository {

    List<Transaction> transactions = new ArrayList<>();


    public void save(Transaction transaction) {
        transactions.add(transaction);
    }

    public void deleteAll() {
        transactions.clear();
    }

    public DoubleSummaryStatistics getStatistics(OffsetDateTime currentTime) {
        OffsetDateTime oneMinuteAgo = currentTime.minusMinutes(1);

        var statistics = transactions.stream()
                .filter(t -> t.getDataHour().isAfter(oneMinuteAgo) && t.getDataHour().isBefore(currentTime) || t.getDataHour().isEqual(currentTime))
                .mapToDouble(t -> t.getValue().doubleValue())
                .summaryStatistics();

        if (statistics.getCount() == 0) {
            return new DoubleSummaryStatistics(0, 0, 0, 0);
        }

        return statistics;
    }


}
