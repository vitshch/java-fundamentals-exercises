package com.bobocode.pattern.adapter;

import java.math.BigDecimal;

public class AdapterDemo {

    public static void main(String[] args) {
        StockService stockService = new StockService(new StockDataAdapterImpl());
        System.out.println(stockService.calculatePrice("TESLA"));
    }

    static class StockService {

        private final StockDataAdapter stockDataAdapter;

        public StockService(StockDataAdapter stockDataAdapter) {
            this.stockDataAdapter = stockDataAdapter;
        }

        public BigDecimal calculatePrice(String code) {
            BigDecimal price = stockDataAdapter.getPrice(code);
            return price;
        }
    }

    interface StockDataAdapter {
        BigDecimal getPrice(String code);
    }

    static class StockDataAdapterImpl implements StockDataAdapter {

        private YahooStockDataProvider yahooStockDataProvider;
        private XtbStockDataProvider xtbStockDataProvider;

        public StockDataAdapterImpl() {
            this.yahooStockDataProvider = new YahooStockDataProvider();
            this.xtbStockDataProvider = new XtbStockDataProvider();
        }

        @Override
        public BigDecimal getPrice(String code) {
//        Old interface:
//        return yahooStockDataProvider.getPrice(code);

//        New interface
            int intCode = xtbStockDataProvider.getIntCode(code);
            double price = xtbStockDataProvider.getPrice(intCode);
            return BigDecimal.valueOf(price);
        }
    }

    static class XtbStockDataProvider {
        double getPrice(Integer code) {
            return 10.0;
        }

        public int getIntCode(String code) {
            return 123;
        }
    }

    static class YahooStockDataProvider {
        public BigDecimal getPrice(String code) {
            return BigDecimal.valueOf(10);
        }
    }
}
