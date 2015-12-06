package com.jpmorgan.supersimplestocks.service;

import com.jpmorgan.supersimplestocks.domain.Stock;

import java.math.BigDecimal;

@FunctionalInterface
public interface DividendYieldCalculationStrategy<T extends Stock> {

    BigDecimal calculateDividendYield(T stock, BigDecimal marketPrice);
}
