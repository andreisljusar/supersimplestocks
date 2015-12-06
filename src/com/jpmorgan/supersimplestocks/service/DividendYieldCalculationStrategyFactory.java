package com.jpmorgan.supersimplestocks.service;

import com.jpmorgan.supersimplestocks.domain.CommonStock;
import com.jpmorgan.supersimplestocks.domain.PreferredStock;
import com.jpmorgan.supersimplestocks.domain.Stock;

public class DividendYieldCalculationStrategyFactory {

    public static DividendYieldCalculationStrategy createDividendYieldCalculationStrategy(Stock stock) {

        if (stock instanceof CommonStock) {
            return new CommonStockDividendYieldCalculationStrategy();
        } else if (stock instanceof PreferredStock) {
            return new PreferredStockYieldCalculationStrategy();
        } else {
            throw new IllegalArgumentException("Stock of unknown type: " + stock.getClass());
        }

    }
}
