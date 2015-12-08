package com.jpmorgan.supersimplestocks.domain;

import java.math.BigDecimal;

public class PreferredStockBuilder<B extends PreferredStockBuilder<B>> extends StockBuilder<PreferredStock, B> {

    public static PreferredStockBuilder<?> aPreferredStock() {
        return new PreferredStockBuilder();
    }

    @Override
    protected PreferredStock createObject() {
        return new PreferredStock();
    }

    public B setFixedDividend(BigDecimal fixedDividend) {
        ((PreferredStock) object).setFixedDividend(fixedDividend);
        return (B) this;
    }

    public B setFixedDividend(int fixedDividend) {
        return setFixedDividend(BigDecimal.valueOf(fixedDividend));
    }
}
