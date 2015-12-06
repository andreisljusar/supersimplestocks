package com.jpmorgan.supersimplestocks.domain;

public class CommonStockBuilder<B extends CommonStockBuilder<B>> extends StockBuilder<B> {

    public static CommonStockBuilder<?> aCommonStock() {
        return new CommonStockBuilder();
    }

    @Override
    protected Stock createObject() {
        return new CommonStock();
    }

    @Override
    public CommonStock build() {
        return (CommonStock) super.build();
    }
}
