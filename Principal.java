import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiDivisas buscaDivisas = new ApiDivisas();
        ConversorMonedas conversorMonedas = new ConversorMonedas();

        while (true) {
            System.out.println("****************************************\n" +
                    "Bienvenidos al Conversor de Divisas\n" +
                    "****************************************\n\n" +
                    "1.- Acceso a la Operacion de Conversion :\n " +
                    "2.- Salirr ==> :\n");
            int opcion = scanner.nextInt();
            if (opcion == 1) {
                System.out.println("Monedas Disponibles para Conversion: ");
                System.out.println("USD ==> Dolar ");
                System.out.println("CLP ==> Peso Chileno ");
                System.out.println("ARS ==> Peso Argentino");
                System.out.println("COP ==> Peso Colombiano");
                System.out.println("BRL ==> Real Brasilero ");

                System.out.println("Ingrese opcion MONEDA BASE:");
                String monedaBasa = scanner.next().toUpperCase();

                System.out.println("Ingrese opcion MONEDA DESTINO:");
                String monedaDestino = scanner.next().toUpperCase();

                System.out.println("Ingrese El Monto a Convertir:");
                double cantidad = scanner.nextDouble();


                double divisaConvertida = buscaDivisas.converorMonedas(monedaBasa, monedaDestino, cantidad);
                System.out.println("El Monto total es:  \n" + divisaConvertida" - "+ monedaDestino);


            } else if (opcion == 2) {
                buscaDivisas.grabaConversionesJson();
                buscaDivisas.resumenConversiones();
                break;
            } else {
                System.out.println("Opcion Invalida");
                break;
            }
        }
        scanner.close();


    }
}
