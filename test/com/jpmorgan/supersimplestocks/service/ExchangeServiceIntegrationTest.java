package com.jpmorgan.supersimplestocks.service;

import com.jpmorgan.supersimplestocks.domain.Trade;
import com.jpmorgan.supersimplestocks.persistence.InMemoryTradeRepository;
import com.jpmorgan.supersimplestocks.persistence.TradeRepository;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static com.jpmorgan.supersimplestocks.domain.TradeIndicator.BUY;
import static java.time.Month.DECEMBER;
import static org.junit.Assert.assertEquals;

public class ExchangeServiceIntegrationTest {

    private TradeRepository tradeRepository = new InMemoryTradeRepository();

    private ExchangeService exchangeService = new ExchangeService();

    @Before
    public void before() {
        exchangeService.setTradeRepository(tradeRepository);
    }

    @Test
    public void calculateDividendYield() throws Exception {

        BigDecimal actual = exchangeService.calculateDividendYield("POP", new BigDecimal("5"));

        assertEquals(new BigDecimal("1.60000"), actual);

    }

    @Test
    public void calculatePriceEarningsRatio() throws Exception {

        BigDecimal actual = exchangeService.calculatePriceEarningsRatio("ALE", new BigDecimal("1.2345"));

        assertEquals(new BigDecimal("0.05367"), actual);

    }

    @Test
    public void recordATrade() {

        exchangeService.recordATrade("GIN", LocalDateTime.of(2015, DECEMBER, 6, 14, 0, 0), 15, BUY, new BigDecimal("15.5"));

        List<Trade> actualTrades = tradeRepository.findAll();
        assertEquals(1, actualTrades.size());

        assertEquals("GIN", actualTrades.get(0).getStock().getSymbol());

        assertEquals(LocalDateTime.of(2015, DECEMBER, 6, 14, 0, 0), actualTrades.get(0).getTimestamp());
        assertEquals(Integer.valueOf(15), actualTrades.get(0).getSharesQuantity());
        assertEquals(BUY, actualTrades.get(0).getTradeIndicator());
        assertEquals(new BigDecimal("15.5"), actualTrades.get(0).getPrice());
    }

    @Test
    public void calculateVolumeWeightedStockPrice() {

        LocalDateTime now = LocalDateTime.now();

        exchangeService.recordATrade("GIN", now, 2, BUY, new BigDecimal("1"));
        exchangeService.recordATrade("GIN", now, 4, BUY, new BigDecimal("2"));
        exchangeService.recordATrade("GIN", now, 6, BUY, new BigDecimal("3"));
        exchangeService.recordATrade("GIN", now, 8, BUY, new BigDecimal("4"));
        exchangeService.recordATrade("GIN", now, 10, BUY, new BigDecimal("5"));

        exchangeService.recordATrade("JOE", LocalDateTime.of(2015, DECEMBER, 6, 14, 0, 0), 10, BUY, new BigDecimal("5"));

        BigDecimal actual = exchangeService.calculateVolumeWeightedStockPrice("GIN");

        assertEquals(new BigDecimal("3.66667"), actual);
    }


    @Test
    public void calculateShareIndex() {

        LocalDateTime now = LocalDateTime.now();

        exchangeService.recordATrade("TEA", now, 2, BUY, new BigDecimal("1"));
        exchangeService.recordATrade("POP", now, 4, BUY, new BigDecimal("2"));
        exchangeService.recordATrade("ALE", now, 6, BUY, new BigDecimal("3"));
        exchangeService.recordATrade("GIN", now, 8, BUY, new BigDecimal("4"));
        exchangeService.recordATrade("JOE", now, 10, BUY, new BigDecimal("5"));

        BigDecimal actual = exchangeService.calculateShareIndex();

        assertEquals(new BigDecimal("2.605171084697352"), actual);

    }

}