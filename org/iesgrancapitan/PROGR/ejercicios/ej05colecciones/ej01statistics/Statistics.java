package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej01statistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Programa que introduce valores aleatorios (entre 0 y 100) en un ArrayList y calcula la suma,
 * la media, el máximo y el mínimo de esos números. El tamaño de la lista también será aleatorio
 * y podrá oscilar entre 10 y 20 elementos ambos inclusive.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Statistics {
  
  private static final int MIN_VALUE = 0;
  private static final int MAX_VALUE = 100;
  
  private static final int MIN_SIZE = 10;
  private static final int MAX_SIZE = 20;
  
  private static List<Integer> numbers = new ArrayList<>();

  public static void main(String[] args) {
    
    // Generamos valores aleatorios y los metemos en el ArrayList
    int totalValues = randomInt(MIN_SIZE, MAX_SIZE);
    for (int i = 0; i < totalValues; i++) {
      numbers.add(randomInt(MIN_VALUE, MAX_VALUE));
    }
    
    // Calculamos suma y media de esos valores
    int sum = 0;
    for (int n: numbers) {
      sum += n;
    }
    double mean = (double) sum / numbers.size();
    
    // Calculamos mínimo y máximo
    int min = Collections.min(numbers);
    int max = Collections.max(numbers);
    
    // Resultados
    System.out.println("Números generados: " + numbers);
    System.out.println("Suma:   " + sum);
    System.out.println("Media:  " + mean);
    System.out.println("Mínimo: " + min);
    System.out.println("Máximo: " + max);
    
  }

  private static int randomInt(int min, int max) {
    return min + (int) (Math.random() * (max-min+1));
  }

}
