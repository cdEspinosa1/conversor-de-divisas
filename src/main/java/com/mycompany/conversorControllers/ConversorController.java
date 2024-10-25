package com.mycompany.conversorControllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorController {

    private final HttpClient client = HttpClient.newHttpClient();

    public ConversorController() {
    }

    public String hacerConversion(String monedaBase, String monedaObjetivo, Double cantidad) throws IOException, InterruptedException {

        String direccionApi = String.format("https://v6.exchangerate-api.com/v6/e7f6e4d0207c97531fcb821a/pair/%s/%s/%s", monedaBase, monedaObjetivo, cantidad);

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccionApi)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
