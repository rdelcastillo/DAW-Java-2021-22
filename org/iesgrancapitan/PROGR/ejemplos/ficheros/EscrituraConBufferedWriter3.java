package org.iesgrancapitan.PROGR.ejemplos.ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Ejemplo escritura en un fichero usando objetos Path en vez de File.
 * 
 * Sobreescribe el fichero existente, si no existe lo crea.
 * 
 * Probad a quitar el tercer parámetro del constructor.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class EscrituraConBufferedWriter3 {

  public static void main(String[] args) {

    // si no se indica nada las opciones de apertura son WRITE, CREATE y TRUNCATE_EXISTING
    try (var file = Files.newBufferedWriter(Paths.get("numeros.txt"))) {
      for (int i = 1; i <= 10; i++) {
        file.write("NewBW. Línea nº " + i);
        file.newLine();
      }
      System.out.println("Escritura realizada.");

    } catch (IOException e) {
      System.out.println("No se ha podido escribir en el fichero.");
    }

  }

}
