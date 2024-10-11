import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Generador {
    public void guardarJson(Divisas divisas) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter(divisas.base_code()+".json");
        escritura.write(gson.toJson(divisas));
        escritura.close();

    }
}
