package com.jpmorgan.supersimplestocks.service;

import com.jpmorgan.supersimplestocks.domain.Stock;

import java.math.BigDecimal;

public class StockCalculationService {

    public BigDecimal calculatePriceEarningsRatio(Stock stock, BigDecimal marketPrice) {
        return marketPrice.divide(stock.getLastDividend(), 5, BigDecimal.ROUND_HALF_UP);
    }

}
