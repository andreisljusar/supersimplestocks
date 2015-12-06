package com.jpmorgan.supersimplestocks.persistence;

import com.jpmorgan.supersimplestocks.domain.CommonStock;
import com.jpmorgan.supersimplestocks.domain.Stock;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class InMemoryStockRepositoryTest {

    private StockRepository stockRepository = new InMemoryStockRepository();

    @Test
    public void findBySymbol() {

        Stock actual = stockRepository.findBySymbol("TEA");

        assertTrue(actual instanceof CommonStock);

    }

    @Test
    public void findBySymbolNotFound() {

        Stock actual = stockRepository.findBySymbol("CCC");

        assertNull(actual);

    }

}