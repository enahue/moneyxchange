package com.enahue.moneyxchange.service;

import com.enahue.moneyxchange.model.Response; // Add this import
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
public class ExchangeRateAPI {
    private static final String API_KEY = "9b7dcef9058c31be20dbcaf4";

    public Response getLatestRates(String currency) {
        URI apiUri = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + currency);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(apiUri).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Response.class);
        } catch (Exception e) {
            throw new RuntimeException("Error while calling API", e);
        }
    }

    public List<String> getAvailableCurrencies() {
        URI apiUri = URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + "/codes");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(apiUri).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), new TypeToken<List<String>>() {
            }.getType());
        } catch (Exception e) {
            throw new RuntimeException("Error while calling API", e);
        }
    }


}