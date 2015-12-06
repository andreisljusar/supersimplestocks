package com.jpmorgan.supersimplestocks.service;

import com.jpmorgan.supersimplestocks.domain.Trade;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

public class CalculationService {

    public BigDecimal calculateVolumeWeightedStockPrice(List<Trade> trades) {

        if (trades == null || trades.isEmpty()) {
            throw new IllegalArgumentException("There should be at least one trade");
        }

        Integer quantitySum = 0;
        BigDecimal priceQuantitySum = BigDecimal.ZERO;

        for (Trade trade : trades) {
            priceQuantitySum = priceQuantitySum.add(trade.getPrice().multiply(new BigDecimal(trade.getSharesQuantity())));
            quantitySum = quantitySum + trade.getSharesQuantity();
        }

        return priceQuantitySum.divide(new BigDecimal(quantitySum), 5, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getGeometricMean(Collection<BigDecimal> values) {

        if (values == null || values.isEmpty()) {
            throw new IllegalArgumentException("Values should have at least one value");
        }

        double valuesProduct = 1.0;

        for (BigDecimal value : values) {
            valuesProduct = valuesProduct * value.doubleValue();
        }

        double geometricMean = Math.pow(valuesProduct, 1.0 / values.size());
        return BigDecimal.valueOf(geometricMean);
    }


}
