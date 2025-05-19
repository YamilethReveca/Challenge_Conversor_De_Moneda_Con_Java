
import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ServicioApi {

    public ApiResponse obtenerDatos() {
        String url_str = "https://v6.exchangerate-api.com/v6/57244b5054ff63bd205e201c/latest/USD";

        try {
            URL url = new URL(url_str);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            InputStreamReader reader = new InputStreamReader((InputStream) request.getContent());

            Gson gson = new Gson();
            ApiResponse response = gson.fromJson(reader, ApiResponse.class);
            return response;

        } catch (Exception e) {
            System.out.println("Error al conectar con la API: " + e.getMessage());
            return null;
        }
    }
}