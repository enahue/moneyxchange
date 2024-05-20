package com.enahue.moneyxchange;

import java.util.Scanner;
import java.util.List;

import com.enahue.moneyxchange.service.Conversor;
import com.enahue.moneyxchange.service.ExchangeRateAPI;
import com.enahue.moneyxchange.model.Response;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();
        ExchangeRateAPI api = new ExchangeRateAPI();
        int option;
        do {
            System.out.println("""
                                        
                    Selecciona una opción:
                    1.- Ver divisas disponibles
                    2.- Convertir divisa
                    3.- salir""");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    List<String> currencies = api.getAvailableCurrencies();
                    System.out.println("Divisas disponibles:");
                    for (String currency : currencies) {
                        System.out.println(currency);
                    }

                    break;
                case 2:
                    System.out.println("Ingresa el código de la moneda desde la que quieres convertir (por ejemplo, USD):");
                    scanner.nextLine();
                    String fromCurrency = scanner.nextLine().toUpperCase();

                    System.out.println("Ingresa el código de la moneda a la que quieres convertir (por ejemplo, EUR):");
                    String toCurrency = scanner.nextLine().toUpperCase();

                    System.out.println("Ingresa el monto a convertir:");
                    double amount = scanner.nextDouble();

                    Response response = api.getLatestRates(fromCurrency);
                    double exchangeRate = response.getExchangeRate(toCurrency);

                    double convertedAmount = conversor.convert(amount, exchangeRate);

                    System.out.println("Monto convertido: " + convertedAmount);
                    break;
                case 3:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");

            }
        } while (option != 3);

    }
}