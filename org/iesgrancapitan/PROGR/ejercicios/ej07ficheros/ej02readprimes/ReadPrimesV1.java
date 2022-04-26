package org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej02readprimes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Lectura del fichero del ejercicio anterior.
 * 
 * Leeremos el fichero (que será un objeto File) línea a línea.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class ReadPrimesV1 {
  
  private static String FILE_NAME = "primos.txt";
  
  public static void main(String[] args) {
    
    try (var file = new BufferedReader(new FileReader(FILE_NAME))) {
      String line;
      while ((line=file.readLine()) != null) {
        System.out.println(line);
      }
      
    } catch (IOException e) {
      System.err.println("No se ha podido leer del fichero " + FILE_NAME);
      System.err.println("Error: " + e.getMessage());
    }
    
  }

}
