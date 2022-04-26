package org.iesgrancapitan.PROGR.ejemplos.ficheros;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Ejemplo de lectura de un fichero JSON de artículos.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class LecturaJSON {

  public static void main(String[] args) {    
    try {
      // Extraigo JSON del archivo 
      String json = Files.readString(Paths.get("almacen.json"));

      // Convierto JSON en un ArrayList
      Gson gson = new Gson();
      Type ArticlesListType = new TypeToken<ArrayList<Article>>(){}.getType(); // ver documentación
      List<Article> articles = gson.fromJson(json, ArticlesListType);
      System.out.println(articles);


    } catch (IOException e) {
      System.err.println("Error de lectura: " + e.getMessage());
      e.printStackTrace();
    }
  }
}