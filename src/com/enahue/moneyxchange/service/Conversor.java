package com.enahue.moneyxchange.service;

public class Conversor {


    public double convert(double amount, double exchangeRate) {
        return amount * exchangeRate;
    }
}
