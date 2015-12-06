package com.jpmorgan.supersimplestocks.persistence;

import com.jpmorgan.supersimplestocks.domain.CommonStock;
import com.jpmorgan.supersimplestocks.domain.CommonStockBuilder;
import com.jpmorgan.supersimplestocks.domain.Trade;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static com.jpmorgan.supersimplestocks.domain.TradeBuilder.aTrade;
import static java.time.Month.DECEMBER;
import static org.junit.Assert.assertEquals;

public class InMemoryTradeRepositoryTest {

    private TradeRepository tradeRepository = new InMemoryTradeRepository();

    @Before
    public void before() {
        tradeRepository.deleteAll();
    }

    @Test
    public void record() throws Exception {

        Trade trade = aTrade().build();

        tradeRepository.insert(trade);

        //TODO: 05-Dec-15 Andrei Sljusar: hamcrest
        assertEquals(1, tradeRepository.findAll().size());
    }

    @Test
    public void findTradesInPastMinutes() {

        CommonStock stock = CommonStockBuilder.aCommonStock().setSymbol("TEA").build();

        tradeRepository.insert(aTrade().setStock(stock).setTimestamp(LocalDateTime.of(2015, DECEMBER, 5, 11, 59)).build());
        tradeRepository.insert(aTrade().setStock(stock).setTimestamp(LocalDateTime.of(2015, DECEMBER, 5, 12, 0)).build());
        tradeRepository.insert(aTrade().setStock(stock).setTimestamp(LocalDateTime.of(2015, DECEMBER, 5, 12, 1)).build());

        List<Trade> trades = tradeRepository.findTradesInPastMinutes("TEA", LocalDateTime.of(2015, DECEMBER, 5, 12, 15), 15);

        assertEquals(2, trades.size());
    }

}