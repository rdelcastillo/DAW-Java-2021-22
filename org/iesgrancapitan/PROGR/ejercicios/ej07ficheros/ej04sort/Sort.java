package org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej04sort;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

/**
 * Programa que ordena alfabéticamente las palabras del fichero que se pasa como argumento.
 * El nombre del fichero resultado debe ser el mismo que el original añadiendo la coletilla sort.
 * Suponemos que cada palabra ocupa una línea.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Sort {

  public static void main(String[] args) {
    exitIfErrorArgs(args);
    
    try {
      String fileNameToSort = args[0];
      List<String> lines = Files.readAllLines(Paths.get(fileNameToSort));
      Collections.sort(lines);
      writeFileSorted(fileNameToSort, lines);
      
    } catch (IOException e) {
      System.err.println("Ha habido problemas de E/S");
      e.printStackTrace();
    }

  }

  private static void writeFileSorted(String fileNameToSort, List<String> lines)
      throws IOException {
    String fileNameSorted = fileNameSorted(fileNameToSort);
    BufferedWriter file = Files.newBufferedWriter(Paths.get(fileNameSorted), Charset.defaultCharset(), 
        StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    for (String l: lines) {
      file.write(l);
      file.newLine();
    }
    file.close();
    System.out.println("Se ha creado el fichero " + fileNameSorted);
  }

  private static String fileNameSorted(String fileNameToSort) {
    int indexOfPoint = fileNameToSort.lastIndexOf(".");
    if (indexOfPoint == -1) {
      return fileNameToSort + "_sort";
    }
    return fileNameToSort.substring(0, indexOfPoint) + "_sort" + fileNameToSort.substring(indexOfPoint);
  }

  private static void exitIfErrorArgs(String[] args) {
    if (args.length != 1) {
      System.err.println("Error al llamar al programa.");
      System.err.println("Formato: java Sort <nombre de fichero>");
      System.exit(1);
    }
  }

}
