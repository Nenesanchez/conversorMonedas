
import com.google.gson.Gson;


import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaDivisas {
    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("***********************************");
        System.out.println("Bienvenido al conversor de monedas");
        System.out.println("1. PARA DÓLAR INGRESAR 'USD'");
        System.out.println("2. PARA EURO INGRESAR 'EUR'");
        System.out.println("3. PARA LIBRA ESTERLINA INGRESAR 'GBP'");
        System.out.println("4. PARA PESO ARGENTINO INGRESAR 'ARS'");
        System.out.println("4. PARA PESO CHILENO INGRESAR 'CLP'");
        System.out.println("***********************************");

        Scanner lectura = new Scanner(System.in);

        System.out.println("Ingresa tu tipo de moneda Local:");
        var busqueda1 = lectura.nextLine();
        System.out.println("Ingresa el tipo de moneda a la cuál quieres convertir:");
        var busqueda2 = lectura.nextLine();
        System.out.println("Ingrese la cantidad a convertir:");
        var busqueda3 = lectura.nextLine();
        String direccion = "https://v6.exchangerate-api.com/v6/2030af44d4ad12dd92f88368/pair/"+busqueda1+"/"+busqueda2+"/"+busqueda3;

        try{

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new Gson();
            Divisas divisas = gson.fromJson(json, Divisas.class);
            System.out.println( "Tus $" +busqueda3+ " "+busqueda1+" corresponden a $" +divisas.conversion_result()+" " +busqueda2);

            FileWriter escritura = new FileWriter("conversor.txt");
            escritura.write(divisas.toString());
            escritura.close();

            Valores valores = new Valores(divisas);
            System.out.println(valores);

        } catch (Exception e) {
            System.out.println("Finalizo la ejecucion del programa!");
        }
    }
}
