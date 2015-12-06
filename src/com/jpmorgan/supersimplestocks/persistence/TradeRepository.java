package com.jpmorgan.supersimplestocks.persistence;

import com.jpmorgan.supersimplestocks.domain.Trade;

import java.time.LocalDateTime;
import java.util.List;

public interface TradeRepository {

    Trade insert(Trade trade);

    void deleteAll();

    List<Trade> findAll();

    List<Trade> findTradesInPastMinutes(String stockSymbol, LocalDateTime dateTime, long pastMinutes);
}
