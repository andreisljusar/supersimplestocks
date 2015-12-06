package com.jpmorgan.supersimplestocks.domain;

import java.math.BigDecimal;

public class PreferredStockBuilder<B extends PreferredStockBuilder<B>> extends StockBuilder<B> {

    public static PreferredStockBuilder<?> aPreferredStock() {
        return new PreferredStockBuilder();
    }

    @Override
    public PreferredStock build() {
        return (PreferredStock) super.build();
    }

    @Override
    protected Stock createObject() {
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
