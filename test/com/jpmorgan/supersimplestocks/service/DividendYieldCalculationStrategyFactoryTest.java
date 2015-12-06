package com.jpmorgan.supersimplestocks.service;

import org.junit.Test;

import static com.jpmorgan.supersimplestocks.domain.CommonStockBuilder.aCommonStock;
import static com.jpmorgan.supersimplestocks.domain.PreferredStockBuilder.aPreferredStock;
import static com.jpmorgan.supersimplestocks.service.DividendYieldCalculationStrategyFactory.createDividendYieldCalculationStrategy;
import static org.junit.Assert.assertTrue;

public class DividendYieldCalculationStrategyFactoryTest {

    @Test
    public void createCommonStockDividendYieldCalculationStrategy() {

        DividendYieldCalculationStrategy actualDividendYieldCalculationStrategy = createDividendYieldCalculationStrategy(aCommonStock().build());

        assertTrue(actualDividendYieldCalculationStrategy instanceof CommonStockDividendYieldCalculationStrategy);
    }

    @Test
    public void createPreferredStockDividendYieldCalculationStrategy() {

        DividendYieldCalculationStrategy actualDividendYieldCalculationStrategy = createDividendYieldCalculationStrategy(aPreferredStock().build());

        assertTrue(actualDividendYieldCalculationStrategy instanceof PreferredStockYieldCalculationStrategy);
    }
}