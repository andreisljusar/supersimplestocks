package com.jpmorgan.supersimplestocks.domain;

import java.math.BigDecimal;

public abstract class StockBuilder<B extends StockBuilder> extends Builder<Stock> {

    @SuppressWarnings("unchecked")
    public B setSymbol(String symbol) {
        object.setSymbol(symbol);
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B setLastDividend(BigDecimal lastDividend) {
        object.setLastDividend(lastDividend);
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B setParValue(BigDecimal parValue) {
        object.setParValue(parValue);
        return (B) this;
    }

    public B setParValue(int parValue) {
        return setParValue(BigDecimal.valueOf(parValue));
    }

    public B setLastDividend(int lastDividend) {
        return setLastDividend(BigDecimal.valueOf(lastDividend));
    }
}
