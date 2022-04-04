package org.iesgrancapitan.PROGR.ejercicios.ej06excepciones.ej01maxvalue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Programa que pida 6 números por teclado y nos dice cuál es el máximo. 
 * 
 * Si el usuario introduce un dato erróneo (algo que no sea un número entero) el programa debe indicarlo
 * y debe pedir de nuevo el número.
 * 
 * Ejercicio del libro "Aprende Java con Ejercicios", edición 2019.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class MaxValue {

  private static int TOTAL_NUMBERS = 6;
  private static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    for (int i = 0; i < TOTAL_NUMBERS; i++) {
      numbers.add(readNumber());
    }
    System.out.println("El máximo es " + Collections.max(numbers));
  }

  private static int readNumber() {
    int n = 0;    
    boolean isOk = false;    
    do {
      try {
        System.out.print("Introduce un número entero: ");
        n = in.nextInt();
        isOk = true;       
      } catch (Exception e) {
        System.err.println("Debe introducir un número entero!!!");
        in.nextLine();
      }
    } while (!isOk);   
    return n;
  }

}
