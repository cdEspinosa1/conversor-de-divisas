package com.mycompany.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Scanner;

public class ConversorService {

    private Scanner scanner = new Scanner(System.in);
    private String cantidadAConvertir = "";

    public ConversorService() {
    }

    public Conversion serializarRespuesta(String json ){

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();

        Gson gson = gsonBuilder.create();
        Conversion conversion = gson.fromJson(json, Conversion.class);

        return conversion;
    }

    public String obtenerCantidad (){

        System.out.println("Ingresa la contidad a convertir:");
        cantidadAConvertir = scanner.nextLine();

        return cantidadAConvertir;
    }

    public void mostrarResultado(String codigoBase, String codigoObjetivo,
                                 String cantidadBase, String cantidadObjetivo){

        String resultado = String.format("""
                **************************************************
                El tipo de cambio %s
                
                $%s %s equivalen a $%s %s
                
                ***************************************************
                """, cantidadBase, codigoBase, cantidadObjetivo, codigoObjetivo);

        System.out.println(resultado);
    }
}
