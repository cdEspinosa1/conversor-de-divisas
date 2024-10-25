package com.mycompany.main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorController {

    private final HttpClient client = HttpClient.newHttpClient();
    private HttpRequest request;
    private String direccionApi;

    public ConversorController() {
    }

    public String hacerConversion(String monedaBase, String monedaObjetivo, String cantidad) throws IOException, InterruptedException {

        direccionApi = String.format("https://v6.exchangerate-api.com/v6/e7f6e4d0207c97531fcb821a/pair/%s/%s/%s", monedaBase, monedaObjetivo, cantidad);

        request = HttpRequest.newBuilder().uri(URI.create(direccionApi)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
