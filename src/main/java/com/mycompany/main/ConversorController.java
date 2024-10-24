package com.mycompany.main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorController {

    public ConversorController() throws IOException, InterruptedException {
    }

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://v6.exchangerate-api.com/v6/e7f6e4d0207c97531fcb821a/latest/USD"))
            .build();

     HttpResponse<String> response = client.
             send(request, HttpResponse.BodyHandlers.ofString());
}
