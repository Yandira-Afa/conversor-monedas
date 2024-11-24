import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaDivisas {
       public TipoMoneda buscaMoneda(String monedaBase, String monedaDestino) {
           URI direccion = URI.create("https://v6.exchangerate-api.com/v6/7d7746791a8bf6e8a89593ea/pair/"+monedaBase+"/"+monedaDestino);

           HttpClient client = HttpClient.newHttpClient();
           HttpRequest request = HttpRequest.newBuilder()
                   .uri(direccion)
                   .build();

           try {
               HttpResponse<String> response = client
                       .send(request, HttpResponse.BodyHandlers.ofString());
               return new Gson().fromJson(response.body(), TipoMoneda.class);
           } catch (Exception e) {
               throw new RuntimeException("Moneda No Encontrada");
           }
       }
}
