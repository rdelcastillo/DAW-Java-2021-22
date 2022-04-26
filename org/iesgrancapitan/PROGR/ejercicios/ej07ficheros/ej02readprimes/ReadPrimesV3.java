package org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej02readprimes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Lectura del fichero del ejercicio anterior.
 * 
 * Leeremos el fichero y lo guardaremos en una cadena.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class ReadPrimesV3 {
  
  private static String FILE_NAME = "primos.txt";
  
  public static void main(String[] args) {
    
    try {
      System.out.println(Files.readString(Paths.get(FILE_NAME)));
      
    } catch (IOException e) {
      System.err.println("No se ha podido leer del fichero " + FILE_NAME);
      System.err.println("Error: " + e.getMessage());
    }
    
  }

}
