package com.jpmorgan.supersimplestocks.domain;

public class CommonStockBuilder<B extends CommonStockBuilder<B>> extends StockBuilder<CommonStock, B> {

    public static CommonStockBuilder<?> aCommonStock() {
        return new CommonStockBuilder();
    }

    @Override
    protected CommonStock createObject() {
        return new CommonStock();
    }
}
