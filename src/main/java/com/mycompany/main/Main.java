package com.mycompany.main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        String menu = """
                **************************************************************
                
                Sea bienvenido(a) al Conversor de Moneda =]
                
                Por favor seleccione una de las siguientes opciones de conversion:
                
                1) Dolar =>> Peso Argentino.
                2) Peso argentino =>> Dolar.
                3) Dolar =>> Real brasileno.
                4) Real brasileno => Dolar.
                5) Dolar =>> Peso colombiano.
                6) Peso colombiano =>> Dolar.
                7) Salir.
                """;

        ConversorController controller = new ConversorController();

        System.out.println(controller.response.body());

    }
}
