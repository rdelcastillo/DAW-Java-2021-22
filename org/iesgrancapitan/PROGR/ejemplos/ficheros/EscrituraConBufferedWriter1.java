package org.iesgrancapitan.PROGR.ejemplos.ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ejemplo escritura en un fichero.
 * 
 * Probad a quitar el segundo parámetro del constructor.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class EscrituraConBufferedWriter1 {

  public static void main(String[] args) {

    try (var file = new BufferedWriter(new FileWriter("numeros.txt", true))) {
      for (int i = 1; i <= 10; i++) {
        file.write("BW. Línea nº " + i);
        file.newLine();
      }
      System.out.println("Escritura realizada.");

    } catch (IOException e) {
      System.err.println("No se ha podido escribir en el fichero: " + e.getMessage());
    }

  }

}
