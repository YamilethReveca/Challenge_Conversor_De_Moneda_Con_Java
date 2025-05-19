import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        ServicioApi servicio = new ServicioApi();
        ApiResponse respuesta = servicio.obtenerDatos();

        if (respuesta != null && "success".equals(respuesta.getResult())) {

            Scanner scanner = new Scanner(System.in);
            Conversor tasas = respuesta.getConversion_rates();


            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");

            int opcion = 0;

            while (opcion != 7) {
                System.out.println("""
                         ***********************************
                         Opciones de Conversión
                                        1) Dólar a Euro
                                        2) Euro a Dólar
                                        3) Euro a Dólar Australiano
                                        4) Dólar Australiano a Euro
                                        5) Dólar a Libra esterlina
                                        6) Libra esterlina a Dólar
                                        7) Salir
                                        Elija una opción válida:
                                       ***********************************
                        
                        """);

                opcion = scanner.nextInt();

                if (opcion == 7) {
                    System.out.println("Finalizado conversor de Moneda. ¡Hasta luego!");
                    break;
                }


                double cantidad = scanner.nextDouble();
                double resultado = 0.0;

                switch (opcion) {
                    case 1:
                        ConversorMoneda.convertirMoneda(scanner, tasas.getEUR(), "Dólar", "Euro");
                        break;
                    case 2:
                        ConversorMoneda.convertirMoneda(scanner, 1 / tasas.getEUR(), "Euro", "Dólar");
                        break;
                    case 3:
                        ConversorMoneda.convertirMoneda(scanner, tasas.getAUD() / tasas.getEUR(), "Euro", "Dólar Australiano");
                        break;
                    case 4:
                        ConversorMoneda.convertirMoneda(scanner, tasas.getEUR() / tasas.getAUD(), "Dólar Australiano", "Euro");
                        break;
                    case 5:
                        ConversorMoneda.convertirMoneda(scanner, tasas.getGBP(), "Dólar", "Libra Esterlina");
                        break;
                    case 6:
                        ConversorMoneda.convertirMoneda(scanner, 1 / tasas.getGBP(), "Libra Esterlina", "Dólar");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                        break;
                }
            }

            scanner.close();

        } else {
            System.out.println("Error al obtener los datos de la API. No se puede continuar.");
        }
    }



}
