package com.jpmorgan.supersimplestocks;

import com.jpmorgan.supersimplestocks.domain.CommonStock;
import com.jpmorgan.supersimplestocks.domain.PreferredStock;
import com.jpmorgan.supersimplestocks.service.CommonStockDividendYieldCalculationStrategy;
import com.jpmorgan.supersimplestocks.service.DividendYieldCalculationStrategy;
import com.jpmorgan.supersimplestocks.service.PreferredStockYieldCalculationStrategy;
import org.junit.Test;

import java.math.BigDecimal;

import static com.jpmorgan.supersimplestocks.domain.CommonStockBuilder.aCommonStock;
import static org.junit.Assert.assertEquals;

//TODO: 05-Dec-15 Andrei Sljusar: AbstractDividendYieldCalculationStrategyTest
public class DividendYieldCalculationStrategyTest {

    @Test
    public void calculateDividendYieldCommonStock() {

        DividendYieldCalculationStrategy strategy = new CommonStockDividendYieldCalculationStrategy();
        CommonStock stock = aCommonStock().setSymbol("ALE").setLastDividend(new BigDecimal("23")).build();

        BigDecimal dividendYield = strategy.calculateDividendYield(stock, new BigDecimal("5.2"));

        assertEquals(new BigDecimal("4.42308"), dividendYield);
    }

    @Test
    public void calculateDividendYieldPreferredStock() {

        DividendYieldCalculationStrategy strategy = new PreferredStockYieldCalculationStrategy();

        //TODO: 05-Dec-15 Andrei Sljusar: builder
        PreferredStock stock = new PreferredStock();
        stock.setSymbol("GIN");
        stock.setFixedDividend(new BigDecimal("2"));
        stock.setParValue(new BigDecimal("100"));

        BigDecimal dividendYield = strategy.calculateDividendYield(stock, new BigDecimal("5.2"));

        assertEquals(new BigDecimal("38.46154"), dividendYield);
    }

}