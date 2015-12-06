package com.jpmorgan.supersimplestocks.persistence;

import com.jpmorgan.supersimplestocks.domain.Stock;

import java.util.HashMap;
import java.util.Map;

import static com.jpmorgan.supersimplestocks.domain.CommonStockBuilder.aCommonStock;
import static com.jpmorgan.supersimplestocks.domain.PreferredStockBuilder.aPreferredStock;

public class InMemoryStockRepository implements StockRepository {

    private Map<String, Stock> stocks = new HashMap<>();

    public InMemoryStockRepository() {
        stocks.put("TEA", aCommonStock().setSymbol("TEA").setLastDividend(0).setParValue(100).build());
        stocks.put("POP", aCommonStock().setSymbol("POP").setLastDividend(8).setParValue(100).build());
        stocks.put("ALE", aCommonStock().setSymbol("ALE").setLastDividend(23).setParValue(60).build());
        stocks.put("GIN", aPreferredStock().setSymbol("GIN").setLastDividend(8).setFixedDividend(2).setParValue(100).build());
        stocks.put("JOE", aCommonStock().setSymbol("JOE").setLastDividend(13).setParValue(250).build());

    }

    @Override
    public Stock findBySymbol(String symbol) {
        return stocks.get(symbol);
    }
}
