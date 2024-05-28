package com.enahue.moneyxchange.currency;

import java.util.Map;

public class Response {
    private Map<String, Double> conversion_rates;

    public double getExchangeRate(String currencyCode) {
        return conversion_rates.getOrDefault(currencyCode, 0.0);
    }
}