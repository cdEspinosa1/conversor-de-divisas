package com.mycompany.main;

import com.mycompany.conversorControllers.ConversorController;
import com.mycompany.conversorModels.Conversion;
import com.mycompany.conversorServices.ConversorService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //region Menu
        String menu = """
                **************************************************************
               \s
                Sea bienvenido(a) al Conversor de Divisas =]
               \s
                1) Dolar =>> Peso Argentino.
                2) Peso argentino =>> Dolar.
                3) Dolar =>> Real brasileno.
                4) Real brasileno => Dolar.
                5) Dolar =>> Peso colombiano.
                6) Peso colombiano =>> Dolar.
                7) Salir.
               \s
                ***************************************************************
                Seleccione una opcion para continuar:\s""";
        //endregion

        Scanner teclado = new Scanner(System.in);
        String seleccion = "";
        String respuesta;
        Double cantidadAConvertir = 0.0;
        Conversion conversion = null;
        final ConversorController conversor = new ConversorController();
        final ConversorService service = new ConversorService();

        while (!seleccion.equals("7")){

            System.out.print(menu);
            seleccion = teclado.nextLine();

            if (seleccion.matches("[123456]") ){
                cantidadAConvertir = service.obtenerCantidad();
            }

            switch (seleccion)
        {
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
                    System.out.println("\nGracias por usar nuestros servicios. Vuelva Pronto.");
                    break;
                default:
                    System.out.println("\nSeleccion no valida, intente de nuevo por favor.");
                    System.out.println("Presiona enter para continuar...");
                    teclado.nextLine();
            }

            if (conversion != null && !seleccion.equals("7")) {
                service.mostrarResultado(conversion.conversion_rate(),
                        conversion.time_last_update_utc(),
                        conversion.base_code(),
                        conversion.target_code(),
                        cantidadAConvertir,
                        conversion.conversion_result());
                System.out.println("Presiona enter para continuar...");
                teclado.nextLine();
            }
        }
    }
}
