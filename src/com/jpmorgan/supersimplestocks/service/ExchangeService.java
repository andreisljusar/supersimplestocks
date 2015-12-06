package com.jpmorgan.supersimplestocks.service;

import com.jpmorgan.supersimplestocks.domain.Stock;
import com.jpmorgan.supersimplestocks.domain.Trade;
import com.jpmorgan.supersimplestocks.domain.TradeIndicator;
import com.jpmorgan.supersimplestocks.persistence.InMemoryStockRepository;
import com.jpmorgan.supersimplestocks.persistence.InMemoryTradeRepository;
import com.jpmorgan.supersimplestocks.persistence.StockRepository;
import com.jpmorgan.supersimplestocks.persistence.TradeRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.jpmorgan.supersimplestocks.domain.TradeBuilder.aTrade;
import static com.jpmorgan.supersimplestocks.service.DividendYieldCalculationStrategyFactory.createDividendYieldCalculationStrategy;

public class ExchangeService {

    private StockRepository stockRepository = new InMemoryStockRepository();
    private TradeRepository tradeRepository = new InMemoryTradeRepository();

    private StockCalculationService stockCalculationService = new StockCalculationService();
    private CalculationService calculationService = new CalculationService();

    public BigDecimal calculateDividendYield(String stockSymbol, BigDecimal marketPrice) {
        Stock stock = stockRepository.findBySymbol(stockSymbol);
        DividendYieldCalculationStrategy dividendYieldCalculationStrategy = createDividendYieldCalculationStrategy(stock);
        return dividendYieldCalculationStrategy.calculateDividendYield(stock, marketPrice);
    }

    public BigDecimal calculatePriceEarningsRatio(String stockSymbol, BigDecimal marketPrice) {
        Stock stock = stockRepository.findBySymbol(stockSymbol);
        return stockCalculationService.calculatePriceEarningsRatio(stock, marketPrice);
    }

    public Trade recordATrade(String stockSymbol, LocalDateTime timestamp, Integer sharesQuantity, TradeIndicator tradeIndicator, BigDecimal tradePrice) {
        Stock stock = stockRepository.findBySymbol(stockSymbol);
        Trade trade = aTrade().setStock(stock).setTimestamp(timestamp).setSharesQuantity(sharesQuantity).setTradeIndicator(tradeIndicator).setPrice(tradePrice).build();
        return tradeRepository.insert(trade);
    }

    /**
     * Calculate Volume Weighted Stock Price based on trades in past 15 minutes.
     *
     * @param stockSymbol stock symbol e.g: TEA, POP, ALE, etc.
     * @return Volume Weighted Stock Price
     */
    public BigDecimal calculateVolumeWeightedStockPrice(String stockSymbol) {
        List<Trade> trades = tradeRepository.findTradesInPastMinutes(stockSymbol, LocalDateTime.now(), 15);
        return calculationService.calculateVolumeWeightedStockPrice(trades);
    }


    /**
     * Calculate the GBCE All Share Index using the geometric mean of prices for all stocks.
     *
     * @return GBCE All Share Index
     */
    public BigDecimal calculateShareIndex() {
        List<Trade> allTrades = tradeRepository.findAll();
        Map<String, List<Trade>> stockSymbolTradesMap = createStockSymbolTradesMap(allTrades);
        List<BigDecimal> prices = stockSymbolTradesMap.values().stream().map(stockTrades -> calculationService.calculateVolumeWeightedStockPrice(stockTrades)).collect(Collectors.toList());
        return calculationService.getGeometricMean(prices);
    }

    private Map<String, List<Trade>> createStockSymbolTradesMap(List<Trade> allTrades) {

        Map<String, List<Trade>> stockSymbolTradesMap = new HashMap<>();

        for (Trade trade : allTrades) {
            String stockSymbol = trade.getStock().getSymbol();
            List<Trade> stockTrades = stockSymbolTradesMap.get(stockSymbol);

            if (stockTrades == null) {
                stockTrades = new ArrayList<>();
                stockSymbolTradesMap.put(stockSymbol, stockTrades);
            }
            stockTrades.add(trade);
        }

        return stockSymbolTradesMap;
    }

    public void setTradeRepository(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }
}
