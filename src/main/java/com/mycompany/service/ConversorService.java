package com.mycompany.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mycompany.model.Conversion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConversorService {

    private final Scanner scanner = new Scanner(System.in);
    private final List<Conversion> historial = new ArrayList<>();

    public ConversorService() {
    }

    public Conversion deserializarRespuesta(String json ){

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

    public void agregarAHistorial(Conversion conversion){
        historial.add(conversion);
    }

    public void mostrarHistorial(){

        String historialTemplate = "";

        for (Conversion conversion : historial) {

            historialTemplate = String.format(
                    """
                     -------------------------------------------------------------
                     %s Tipo de cambio: $%,.4f, Conversion: $%,.2f %s => $%,.4f %s
                     -------------------------------------------------------------
                     """,
                    conversion.fecha(),
                    conversion.conversion_rate(),
                    conversion.cantidadBase(),
                    conversion.base_code(),
                    conversion.conversion_result(),
                    conversion.target_code());

            System.out.println(historialTemplate);
        }
    }
}
