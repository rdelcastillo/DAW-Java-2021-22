package org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej01writeprimes;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Programa que guarda en un fichero con nombre primos.txt los números primos que hay entre 1 y 500.
 * 
 * Usaremos la clase PrintWriter que sobreescribirá lo que hubiese en el archivo. Si queremos conservar
 * lo que había y añadir, tendremos que crear el objeto PrintWriter de la siguiente forma:
 * 
 * file = new PrintWriter(new FileWriter(FILE_NAME, true))
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class WritePrimesWithPrintWriter {
  
  private static int TOTAL_PRIMES = 500;
  private static String FILE_NAME = "primos.txt";

  public static void main(String[] args) {
    
    try (var file = new PrintWriter(FILE_NAME)) {
      for (int n = 1; n <= TOTAL_PRIMES; n++) {
        if (isPrime(n)) {
          file.println(n);
        }
      }
      System.out.println("Escritura realizada en " + FILE_NAME);
      
    } catch (FileNotFoundException e) {
      System.err.println("No se ha podido escribir en el fichero " + FILE_NAME);
      System.err.println("Mensaje del error: " + e.getMessage());
    }

  }

  private static boolean isPrime(int n) {
    // casos triviales: 2 (primo), par y < 1 (no es primo)
    if (n == 2) {
      return true;
    }
    if (n%2 == 0 || n < 2) {
      return false;
    }
    // resto de casos
    for (int i = 3; i <= Math.sqrt(n); i += 2) {
      if (n%i == 0) {
        return false;
      }
    }
    return true;
  }

}
