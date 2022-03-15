package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej01statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.iesgrancapitan.PROGR.ejercicios.util.Util;

/**
 * Programa que introduce valores aleatorios (entre 0 y 100) en un ArrayList y calcula la suma,
 * la media, el máximo y el mínimo de esos números. El tamaño de la lista también será aleatorio
 * y podrá oscilar entre 10 y 20 elementos ambos inclusive.
 * 
 * Ejercicio del libro "Aprende Java con Ejercicios", edición 2019.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Statistics {
  
  private static final int MIN_VALUE = 0;
  private static final int MAX_VALUE = 100;
  
  private static final int MIN_SIZE = 10;
  private static final int MAX_SIZE = 20;

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    
    // Generamos valores aleatorios y los metemos en el ArrayList
    int totalValues = Util.randomInt(MIN_SIZE, MAX_SIZE);
    for (int i = 0; i < totalValues; i++) {
      numbers.add(Util.randomInt(MIN_VALUE, MAX_VALUE));
    }
    
    // Calculamos suma y media de esos valores
    int sum = 0;
    for (int n: numbers) {
      sum += n;
    }
    double mean = (double) sum / numbers.size();
    
    // Resultados
    System.out.println("Números generados: " + numbers);
    System.out.println("Suma:   " + sum);
    System.out.println("Media:  " + mean);
    System.out.println("Mínimo: " + Collections.min(numbers));
    System.out.println("Máximo: " + Collections.max(numbers));
  }

}
