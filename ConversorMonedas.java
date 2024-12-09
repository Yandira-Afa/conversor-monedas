import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConversorMonedas {
    private ApiDivisas apiDivisas;
    private List<JsonObject> conversiones;

    public ConversorMonedas() {
        this.apiDivisas = new ApiDivisas();
        this.conversiones = new ArrayList<>();
    }

    //CONVERTIR Y GUARDAR LA CONVERSION

    public double conversoMonedas(String monedaBase, String monedaDestino, double cantidad) {
        try {
            double tasa = apiDivisas.tasaDeCambio(monedaBase, monedaDestino);
            double divisaConvertida = cantidad * tasa;

            //Objeto que guarda las conversiones

            JsonObject conversion = new JsonObject();
            conversion.addProperty("moneda_Base", monedaBase);
            conversion.addProperty("moneda_Destino", monedaDestino);
            conversion.addProperty("cantidad", cantidad);
            conversion.addProperty("divisaConvertida", divisaConvertida);
            conversion.addProperty("tasa", tasa);
            conversiones.add(conversion);

            return divisaConvertida;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return 0;
        }

    }
    //GUARDAR LAS CONVERSIONES EN ARCHIVO JSON

    public void grabaConversionesJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonArray jsonArray = new JsonArray();
        for (JsonObject conversion : conversiones) {
            jsonArray.add(conversion);
        }
        try (FileWriter fileWriter = new FileWriter("conversiones.json")) {
            fileWriter.write(gson.toJson(jsonArray));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    //RESUMEN DE LAS CONVERSIONES

    public void resumenConversiones() {
        try {
            String contenido = new String(Files.readAllBytes(Paths.get("conversiones.json")));
            System.out.println("Reseumen de Conversiones Realizadas");
            System.out.println(contenido);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }
    }
    }

