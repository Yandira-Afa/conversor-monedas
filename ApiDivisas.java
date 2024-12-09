import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiDivisas {
    private static String API_KEY = "7d7746791a8bf6e8a89593ea";
    private static String BASE_URL = "https://v6.exchangerate-api.com/v6";
    private String monedaBase;
    private String monedaDestino;

    //OBTENIENDO LA TASA DE CAMBIO

    public double tasaDeCambio (String monedaBase, String monedaDestino) throws IOException, InterruptedException {
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        HttpClient client = HttpClient.newHttpClient();

        String url = BASE_URL + API_KEY + "/latest/" + monedaBase;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String jsonResponse = response.body();

        //Respuesta Json usando Gson

        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        return jsonObject.getAsJsonObject("conversion_rates").get(monedaDestino).getAsDouble();


    }

    public void grabaConversionesJson() {

    }

    public void resumenConversiones() {

    }

    public double converorMonedas(String monedaBasa, String monedaDestino, double cantidad) {
        return cantidad;

    }
}