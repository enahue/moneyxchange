package com.enahue.moneyxchange.service;

import com.enahue.moneyxchange.model.Response;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateAPI {
    public Response getCurrencyAbbreviations(String currency) {

        String apiKey = "9b7dcef9058c31be20dbcaf4";

        URI apiUri = URI.create("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + currency);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(apiUri)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Response.class);
        } catch (Exception e) {

            throw new RuntimeException("Error while calling API", e);

        }

    }
}
