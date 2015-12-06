package com.jpmorgan.supersimplestocks.persistence;

import com.jpmorgan.supersimplestocks.domain.Trade;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryTradeRepository implements TradeRepository {

    private List<Trade> trades = new LinkedList<>();

    @Override
    public Trade insert(Trade trade) {
        trades.add(trade);
        return trade;
    }

    @Override
    public void deleteAll() {
        trades.clear();
    }

    @Override
    public List<Trade> findAll() {
        return trades;
    }

    @Override
    public List<Trade> findTradesInPastMinutes(String stockSymbol, LocalDateTime dateTime, long pastMinutes) {
        LocalDateTime findAfterDateTime = dateTime.minusMinutes(pastMinutes);
        return trades.stream().filter(trade -> (trade.getStock().getSymbol().equals(stockSymbol) && (trade.getTimestamp().isAfter(findAfterDateTime) || trade.getTimestamp().isEqual(findAfterDateTime)))).collect(Collectors.toList());
    }

}
