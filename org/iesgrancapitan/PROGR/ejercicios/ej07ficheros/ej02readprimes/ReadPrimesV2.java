package org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej02readprimes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Lectura del fichero del ejercicio anterior.
 * 
 * Leeremos el fichero y lo guardaremos en un ArrayList.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class ReadPrimesV2 {
  
  private static String FILE_NAME = "primos.txt";
  
  public static void main(String[] args) {
    
    try {
      List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));
      for (String l: lines) {
        System.out.println(l);
      }
      
    } catch (IOException e) {
      System.err.println("No se ha podido leer del fichero " + FILE_NAME);
      System.err.println("Error: " + e.getMessage());
    }
    
  }

}
