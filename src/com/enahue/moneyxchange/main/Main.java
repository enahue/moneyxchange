package com.enahue.moneyxchange.main;

import com.enahue.moneyxchange.api.ExchangeRateAPI;
import com.enahue.moneyxchange.models.Response;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando la aplicación..");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("*******************************************");
            System.out.println("    BIENVENIDO AL CONVERSOR DE MONEDAS  \n");
            String menu = """ 
                    Elija el tipo de moneda que desea convertir:
                                        
                    1) DÓLAR A PESO ARGENTINO
                    2) PESO ARGENTINO A DÓLAR
                    3) DÓLAR A REAL BRASILEÑO
                    4) REAL BRASILEÑO A DÓLAR
                    5) DÓLAR A PESO COLOMBIANO
                    6) PESO COLOMBIANO A DÓLAR
                    7) SOL PERUANO A DÓLAR
                    8) SALIR

                    ELIJA UNA OPCIÓN VÁLIDA
                    """;
            System.out.println(menu);
            var currencyCode = sc.nextLine();
            if (currencyCode.equalsIgnoreCase("7")) {
                break;
            }
            try {
                ExchangeRateAPI query = new ExchangeRateAPI();
                Response response = query.getCurrencyAbbreviations(currencyCode);


                System.out.println(response);

            } catch (NumberFormatException e) {
                System.out.println("Solo se aceptan numeros (" + e.getMessage() + ")");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Finalizando la aplicación..");
            }

        }
    }

}