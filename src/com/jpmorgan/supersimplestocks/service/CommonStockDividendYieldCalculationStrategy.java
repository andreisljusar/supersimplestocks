package com.jpmorgan.supersimplestocks.service;

import com.jpmorgan.supersimplestocks.domain.Stock;

import java.math.BigDecimal;

public class CommonStockDividendYieldCalculationStrategy implements DividendYieldCalculationStrategy {

    @Override
    public BigDecimal calculateDividendYield(Stock stock, BigDecimal marketPrice) {
        return stock.getLastDividend().divide(marketPrice, 5, BigDecimal.ROUND_HALF_UP);
    }
}
