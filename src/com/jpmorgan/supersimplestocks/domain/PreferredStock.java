package com.jpmorgan.supersimplestocks.domain;

import java.math.BigDecimal;

public class PreferredStock extends Stock {

    /**
     * percentage (%)
     */
    private BigDecimal fixedDividend;

    public BigDecimal getFixedDividend() {
        return fixedDividend;
    }

    public void setFixedDividend(BigDecimal fixedDividend) {
        this.fixedDividend = fixedDividend;
    }
}
