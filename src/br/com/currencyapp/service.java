package br.com.currencyapp;

import com.google.gson.Gson;
import java.util.Map;

public class service {

    private final infrastructure api = new infrastructure();
    private final Gson gson = new Gson();

    public double convert(double amount, domain currency) {

        String json = api.getRates();
        dto response = gson.fromJson(json, dto.class);

        Map<String, Double> rates = response.getConversionRates();

        double brlRate = rates.get("BRL");
        double targetRate = rates.get(currency.code());

        double valueInUsd = amount / brlRate;

        return valueInUsd * targetRate;
    }
}
