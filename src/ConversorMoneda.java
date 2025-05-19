import java.util.Scanner;

public class ConversorMoneda {

    public static void convertirMoneda(Scanner scanner, double tasa, String de, String a) {
        System.out.print("Ingrese la cantidad que desea convertir de " + de + " a " + a + ": ");
        double cantidad = scanner.nextDouble();
        double resultado = cantidad * tasa;
        System.out.printf("=> %.2f %s equivale a %.2f %s\n", cantidad, de, resultado, a);
    }


}


