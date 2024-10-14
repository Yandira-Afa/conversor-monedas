import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        BuscaDivisas consulta = new BuscaDivisas();
        int opcion=0;
        while (opcion!=7) {
            System.out.println("****************************************\n"+
                    "Bienvenidos al Conversor de Divisas\n"+
                    "****************************************\n\n"+
                    "1) Dolar (USD)          ==> Peso Chileno (CLP):\n"+
                    "2) Peso Chileno (CLP)   ==> Dolar (USD):\n"+
                    "3) Dolar (USD)          ==> Peso Agentino (ARS):\n"+
                    "4) Peso Argentino (ARS) ==> Dolar (USD) :\n"+
                    "5) Dolar (USD)          ==> Peso Colombianoo (COP):\n"+
                    "6) Peso Colombiano (COP)==> Dolar (USD) :\n"+
                    "7) Dolar (USD)          ==> Real Brasilero (BRL):\n"+
                    "8) Real Brasilero (BRL) ==> Dolar (USD) :\n"+
                    "9) Salirr ==> :\n");
            opcion = lectura.nextInt();
            lectura.nextLine();

            switch (opcion) {
                case 1:
                    ConversionMoneda.conversor("USD", "CLP", consulta, lectura);
                    break;
                case 2:
                    ConversionMoneda.conversor("CLP", "USD", consulta, lectura);
                    break;
                case 3:
                    ConversionMoneda.conversor("USD", "ARS", consulta, lectura);
                    break;
                case 4:
                    ConversionMoneda.conversor("ARS", "USD", consulta, lectura);
                    break;
                case 5:
                    ConversionMoneda.conversor("USD", "COP", consulta, lectura);
                    break;
                case 6:
                    ConversionMoneda.conversor("COP", "USD", consulta, lectura);
                    break;
                case 7:
                    ConversionMoneda.conversor("USD", "BRL", consulta, lectura);
                    break;
                case 8:
                    ConversionMoneda.conversor("BRL", "USD", consulta, lectura);
                    break;
                case 9:
                    System.out.println("Abandonando La Conversion de Divisas");
                    break;

                default:
                    System.out.println("Opcion Invalida");
                    break;

            }




        }
    }
}
