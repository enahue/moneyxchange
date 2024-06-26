package com.enahue.moneyxchange;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import com.enahue.moneyxchange.currency.Conversor;
import com.enahue.moneyxchange.currency.ExchangeRateAPI;
import com.enahue.moneyxchange.currency.Response;

import static com.enahue.moneyxchange.ReadJson.readJsonFile;

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
                    Map<String, String> currentsList = null;
                    try {
                        currentsList = readJsonFile("currents.json");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (currentsList != null) {
                        for (Map.Entry<String, String> entry : currentsList.entrySet()) {
                            System.out.println(entry.getKey() + ": " + entry.getValue());
                        }
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