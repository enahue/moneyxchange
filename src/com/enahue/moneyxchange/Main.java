package com.enahue.moneyxchange;

import java.util.Scanner;
import com.enahue.moneyxchange.service.Conversor;
import com.enahue.moneyxchange.service.ExchangeRateAPI;
import com.enahue.moneyxchange.model.Response;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();
        ExchangeRateAPI api = new ExchangeRateAPI();

        System.out.println("Enter the currency code you want to convert from (e.g., USD):");
        String fromCurrency = scanner.nextLine();

        System.out.println("Enter the currency code you want to convert to (e.g., EUR):");
        String toCurrency = scanner.nextLine();

        System.out.println("Ingresa el monto a convertir:");
        double amount = scanner.nextDouble();

        Response response = api.getLatestRates(fromCurrency);
        double exchangeRate = response.getExchangeRate(toCurrency);

        double convertedAmount = conversor.convert(amount, exchangeRate);

        System.out.println("Monto convertido: " + convertedAmount);
    }
}