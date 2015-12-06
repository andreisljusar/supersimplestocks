package com.jpmorgan.supersimplestocks.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Trade {

    private LocalDateTime timestamp;
    private Integer sharesQuantity;
    private TradeIndicator tradeIndicator;
    private BigDecimal price;
    private Stock stock;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getSharesQuantity() {
        return sharesQuantity;
    }

    public void setSharesQuantity(Integer sharesQuantity) {
        this.sharesQuantity = sharesQuantity;
    }

    public TradeIndicator getTradeIndicator() {
        return tradeIndicator;
    }

    public void setTradeIndicator(TradeIndicator tradeIndicator) {
        this.tradeIndicator = tradeIndicator;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
