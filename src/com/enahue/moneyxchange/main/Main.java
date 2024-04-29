package com.enahue.moneyxchange.main;

import com.enahue.moneyxchange.api.ExchangeRateAPI;
import com.enahue.moneyxchange.models.Response;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando la aplicación..");
        Scanner sc = new Scanner(System.in);

        while (true) {


            System.out.println("Ingrese el número de la película que desea buscar");


//            var movieNumber = Integer.valueOf(sc.nextLine());
                var currency = sc.nextLine();
                //sc.close();
                if (currency.equalsIgnoreCase("salir")) {
                    break;
                }
            try {
                ExchangeRateAPI query = new ExchangeRateAPI();
                Response response = query.getCurrencyAbbreviations(currency);

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
