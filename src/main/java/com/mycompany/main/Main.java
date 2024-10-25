package com.mycompany.main;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //region Menu
        String menu = """
                **************************************************************
                
                Sea bienvenido(a) al Conversor de Moneda =]
                
                Por favor seleccione una de las siguientes opciones:
                
                1) Dolar =>> Peso Argentino.
                2) Peso argentino =>> Dolar.
                3) Dolar =>> Real brasileno.
                4) Real brasileno => Dolar.
                5) Dolar =>> Peso colombiano.
                6) Peso colombiano =>> Dolar.
                7) Salir.
                
                ****************************************************************
                """;
        //endregion

        Scanner teclado = new Scanner(System.in);
        String seleccion = "";
        String respuesta = "";
        String cantidadAConvertir = "";
        Conversion conversion = null;
        final ConversorController conversor = new ConversorController();
        final ConversorService service = new ConversorService();

        while (!seleccion.equals("7")){

            System.out.print(menu);
            seleccion = teclado.nextLine();

            if ("[123456]".matches(seleccion) ){
                cantidadAConvertir = service.obtenerCantidad();
            }

            switch (seleccion){
                case "1":
                    respuesta = conversor.hacerConversion("USD", "ARS", cantidadAConvertir);
                    conversion = service.serializarRespuesta(respuesta);
                    break;
                case  "2":
                    respuesta = conversor.hacerConversion("ARS", "USD", cantidadAConvertir);
                    conversion = service.serializarRespuesta(respuesta);
                    break;
                case "3":
                    respuesta = conversor.hacerConversion("USD", "BRL", cantidadAConvertir);
                    conversion = service.serializarRespuesta(respuesta);
                    break;
                case "4":
                    respuesta = conversor.hacerConversion("BRL", "USD", cantidadAConvertir);
                    conversion = service.serializarRespuesta(respuesta);
                    break;
                case "5":
                    respuesta = conversor.hacerConversion("USD", "COP", cantidadAConvertir);
                    conversion = service.serializarRespuesta(respuesta);
                    break;
                case "6":
                    respuesta = conversor.hacerConversion("COP", "USD", cantidadAConvertir);
                    conversion = service.serializarRespuesta(respuesta);
                    break;
                case "7":
                    System.out.println("Gracias por usar nuestros servicios. Vuelva Pronto.");
                    break;
                default:
                    System.out.println("Seleccion no valida, intente de nuevo por favor.");
            }

            assert conversion != null;
            service.mostrarResultado(conversion.base_code(), conversion.target_code(),
                    cantidadAConvertir, conversion.conversion_result(), );

            System.out.println(respuesta);
        }
    }
}
