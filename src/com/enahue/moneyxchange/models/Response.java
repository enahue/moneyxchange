package com.enahue.moneyxchange.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public record Response(Map<String, Double> conversion_rates) {
    public List<String> getCurrencyAbbreviations() {
        List<String> abbreviations = new ArrayList<>(conversion_rates.keySet());
        return abbreviations;
    }
}
