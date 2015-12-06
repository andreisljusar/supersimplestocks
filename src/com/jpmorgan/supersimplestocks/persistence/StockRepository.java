package com.jpmorgan.supersimplestocks.persistence;

import com.jpmorgan.supersimplestocks.domain.Stock;

public interface StockRepository {

    Stock findBySymbol(String symbol);
}
