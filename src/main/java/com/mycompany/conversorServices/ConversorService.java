package com.mycompany.conversorServices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.conversorModels.Conversion;

import java.util.Scanner;

public class ConversorService {

    private final Scanner scanner = new Scanner(System.in);

    public ConversorService() {
    }

    public Conversion serializarRespuesta(String json ){

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();

        Gson gson = gsonBuilder.create();

        return gson.fromJson(json, Conversion.class);
    }

    public Double obtenerCantidad (){

        System.out.print("\nIngresa la contidad a convertir: ");

        return scanner.nextDouble();
    }

    public void mostrarResultado(Double tipoDeCambio, String fecha, String codigoBase, String codigoObjetivo,
                                 Double cantidadBase, Double cantidadObjetivo){

        String resultado = String.format("""
                
                **************************************************
                
                El tipo de cambio es $%,.4f a dia de hoy %s
                
                $%,.2f %s equivalen a $%,.4f %s
                
                ***************************************************""",
                tipoDeCambio, fecha, cantidadBase, codigoBase, cantidadObjetivo, codigoObjetivo);

        System.out.println(resultado);
    }
}
