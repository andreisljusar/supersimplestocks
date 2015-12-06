package com.jpmorgan.supersimplestocks.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TradeBuilder extends Builder<Trade> {

    public static TradeBuilder aTrade() {
        return new TradeBuilder();
    }

    @Override
    protected Trade createObject() {
        return new Trade();
    }

    public TradeBuilder setTimestamp(LocalDateTime timestamp) {
        object.setTimestamp(timestamp);
        return this;
    }

    public TradeBuilder setSharesQuantity(Integer sharesQuantity) {
        object.setSharesQuantity(sharesQuantity);
        return this;
    }

    public TradeBuilder setTradeIndicator(TradeIndicator tradeIndicator) {
        object.setTradeIndicator(tradeIndicator);
        return this;
    }

    public TradeBuilder setPrice(BigDecimal price) {
        object.setPrice(price);
        return this;
    }

    public TradeBuilder setStock(Stock stock) {
        object.setStock(stock);
        return this;
    }

}
