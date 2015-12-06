package com.jpmorgan.supersimplestocks.service;

import com.jpmorgan.supersimplestocks.domain.CommonStockBuilder;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class StockCalculationServiceTest {

    private StockCalculationService stockCalculationService = new StockCalculationService();

    @Test
    public void calculatePriceEarningsRatio() {

        BigDecimal actual = stockCalculationService.calculatePriceEarningsRatio(CommonStockBuilder.aCommonStock().setLastDividend(5).build(), new BigDecimal("5.5"));

        assertEquals(new BigDecimal("1.10000"), actual);
    }
}