package org.iesgrancapitan.PROGR.ejemplos.ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

/**
 * Ejemplo de creación de un fichero JSON de artículos.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class EscrituraJSON {

  public static void main(String[] args) {
    List<Article> articles = new ArrayList<>();

    // Artículos de muestra
    for (int i = 1; i <= 10; i++) {
      articles.add(new Article(i, "Artículo " + i,           // código y descripción
          Math.random() * 100,          // precio aleatorio
          (int) (Math.random() * 11))); // unidades aleatorias
    }

    try {
      // Paso ArrayList a JSONnew Gson()
      String json = new Gson().toJson(articles);

      // Guardo JSON en un archivo
      BufferedWriter file = new BufferedWriter(new FileWriter("almacen.json"));
      file.write(json);
      file.close();
      
      System.out.println("Creado almacen.json");

    } catch (IOException e) {
      System.err.println("Error al crear JSON: " + e.getMessage());
      e.printStackTrace();
    }
  }

}
