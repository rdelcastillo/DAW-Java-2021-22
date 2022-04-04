package org.iesgrancapitan.PROGR.ejemplos.ficheros;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Ejemplo escritura en un fichero usando objetos Path en vez de File.
 * 
 * Añade al fichero existente, si no existe lo crea.
 * 
 * Probad a quitar el segundo parámetro del constructor.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class EscrituraConBufferedWriter2 {

  public static void main(String[] args) {
    
    try (var file = Files.newBufferedWriter(Paths.get("numeros.txt"), 
            Charset.defaultCharset(), StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
      
      for (int i = 1; i <= 10; i++) {
        file.write("BW2. Línea nº " + i);
        file.newLine();
      }
      System.out.println("Escritura realizada.");

    } catch (IOException e) {
      System.err.println("No se ha podido escribir en el fichero: " + e.getMessage());
      e.printStackTrace();
    }


  }

}
