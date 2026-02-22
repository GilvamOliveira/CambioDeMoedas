package br.com.currencyapp;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class infrastructure {

    private static final String URL =
            "https://v6.exchangerate-api.com/v6/9b6a89d447f779aea8244267/latest/USD";

    private final HttpClient client = HttpClient.newHttpClient();

    public String getRates() {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .GET()
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao acessar API.");
        }
    }
}