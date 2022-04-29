package org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej06wordcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Programa que nos dice cuántas ocurrencias de una palabra hay en un fichero. Tanto el nombre
 * del fichero como la palabra se deben pasar como argumentos en la línea de comandos.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class WordCounter {

  public static void main(String[] args) {
    if (args.length != 2) {
      System.err.println("Número de argumentos erróneo.");
      System.exit(1);
    }

    String fileName = args[0];
    String word = args[1];

    try {
      String fileStr = Files.readString(Paths.get(fileName));
      int wordCounter = 0;
      
      int wordIndex = fileStr.indexOf(word);
      while (wordIndex != -1) {
        wordCounter++;
        wordIndex = fileStr.indexOf(word, wordIndex+1);
      }
      
      System.out.println("Se han encontrado " + wordCounter + " ocurrencias de " + word);
    } 
    catch (IOException e) {
      System.err.println("No se puede abrir el fichero " + fileName);
    }
  }

}
