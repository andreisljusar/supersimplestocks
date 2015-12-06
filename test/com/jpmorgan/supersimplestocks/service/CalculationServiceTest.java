package com.jpmorgan.supersimplestocks.service;

import com.jpmorgan.supersimplestocks.domain.Trade;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.jpmorgan.supersimplestocks.domain.TradeBuilder.aTrade;
import static org.junit.Assert.assertEquals;

public class CalculationServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private CalculationService calculationService = new CalculationService();

    @Test
    public void calculateVolumeWeightedStockPrice() throws Exception {

        List<Trade> trades = Arrays.asList(
                aTrade().setPrice(new BigDecimal("5")).setSharesQuantity(2).build(),
                aTrade().setPrice(new BigDecimal("4")).setSharesQuantity(3).build(),
                aTrade().setPrice(new BigDecimal("7")).setSharesQuantity(2).build());

        BigDecimal actualPrice = calculationService.calculateVolumeWeightedStockPrice(trades);

        assertEquals(new BigDecimal("5.14286"), actualPrice);
    }

    @Test
    public void getGeometricMean() {

        BigDecimal actual = calculationService.getGeometricMean(Arrays.asList(new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3")));

        assertEquals(new BigDecimal("1.8171205928321397"), actual);
    }


    @Test
    public void getGeometricMeanWithoutValues() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Values should have at least one value");

        calculationService.getGeometricMean(null);
    }

}