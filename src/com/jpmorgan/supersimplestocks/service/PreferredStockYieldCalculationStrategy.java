package com.jpmorgan.supersimplestocks.service;

import com.jpmorgan.supersimplestocks.domain.PreferredStock;

import java.math.BigDecimal;

public class PreferredStockYieldCalculationStrategy implements DividendYieldCalculationStrategy<PreferredStock> {

    @Override
    public BigDecimal calculateDividendYield(PreferredStock stock, BigDecimal marketPrice) {
        return stock.getFixedDividend().multiply(stock.getParValue()).divide(marketPrice, 5, BigDecimal.ROUND_HALF_UP);
    }

}
