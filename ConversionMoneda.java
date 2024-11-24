import java.util.Scanner;

public class ConversionMoneda {

  public static void conversor(String monedaBase, String monedaDestino, BuscaDivisas consulta, Scanner lectura) {
      double cantidad;
      double divisaConvertida;
      TipoMoneda moneda = consulta.buscaMoneda(monedaBase, monedaDestino);
      System.out.println("La Tasa de cambio es ==>"+monedaBase+ " = " +monedaDestino);
  }

}
