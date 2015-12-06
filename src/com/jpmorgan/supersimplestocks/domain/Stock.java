package com.jpmorgan.supersimplestocks.domain;

import java.math.BigDecimal;

//TODO: 06-Dec-15 Andrei Sljusar: hashCode and equals?
public abstract class Stock {

    //TODO: 05-Dec-15 Andrei Sljusar: in pennies
    protected BigDecimal lastDividend;
    //TODO: 05-Dec-15 Andrei Sljusar: in pennies
    protected BigDecimal parValue;
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getParValue() {
        return parValue;
    }

    public void setParValue(BigDecimal parValue) {
        this.parValue = parValue;
    }

    public BigDecimal getLastDividend() {
        return lastDividend;
    }

    public void setLastDividend(BigDecimal lastDividend) {
        this.lastDividend = lastDividend;
    }
}
