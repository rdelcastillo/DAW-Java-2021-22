package org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej05mixfiles;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Programa que guarda en un fichero el contenido de otros dos ficheros, de tal forma que en el
 * fichero resultante aparezcan las líneas de los primeros dos ficheros mezcladas, es decir, la
 * primera línea será del primer fichero, la segunda será del segundo fichero, la tercera será 
 * la siguiente del primer fichero, y así sucesivamente.
 * 
 * Los nombres de los dos ficheros origen y el nombre del fichero destino se deben pasar como 
 * argumentos en la línea de comandos.
 * 
 * Hay que tener en cuenta que los ficheros de donde se van cogiendo las líneas pueden tener tamaños
 * diferentes.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class MixFiles {

  public static void main(String[] args) {
    
    // ¿Número de argumentos correcto?
    if (args.length != 3) {
      System.err.println("Número de argumentos erróneo.");
      System.exit(1);
    }

    try {
      // Leemos ficheros origen y abrimos destino
      List<String> linesFile1 = Files.readAllLines(Paths.get(args[0]));
      List<String> linesFile2 = Files.readAllLines(Paths.get(args[1]));
      PrintWriter mixedFile = new PrintWriter(args[2]);
      
      // Mezclamos las líneas de ambos ficheros hasta que acabemos de leer el que menos tiene
      int numLinesSmallestFile = Math.min(linesFile1.size(), linesFile2.size());
      for (int i = 0; i < numLinesSmallestFile; i++) {
        mixedFile.println(linesFile1.get(i));
        mixedFile.println(linesFile2.get(i));
      }
      
      // Añadimos las líneas del fichero con más líneas
      List<String> linesLargestFile = (linesFile1.size() < linesFile2.size()) 
          ? linesFile2 : linesFile1;
      for (int i = numLinesSmallestFile; i < linesLargestFile.size(); i++) {
        mixedFile.println(linesLargestFile.get(i));
      }
      
      mixedFile.close();
      System.out.println("Proceso concluido.");

    } catch (IOException e) {
      System.err.println("Error de lectura/escritura: " + e.getMessage());
      e.printStackTrace();
    }

  }

}
