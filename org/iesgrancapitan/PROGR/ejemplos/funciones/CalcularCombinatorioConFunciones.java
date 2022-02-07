package org.iesgrancapitan.PROGR.ejemplos.funciones;

import java.util.Scanner;

/**
 * Este programa pide dos números (n y m) y calcula su combinatorio si n>m.
 * Si las condiciones no se cumplen terminamos con el programa.
 * 
 * @author rafa
 *
 */

public class CalcularCombinatorioConFunciones {

  public static void main(String[] args) {    
    Scanner s = new Scanner(System.in);
    
    // Presentación
    System.out.println("Cálculo del combinatorio de dos números");
    System.out.println("---------------------------------------");
    
    // Pedimos datos
    System.out.print("Dame el valor de n: ");
    int n = s.nextInt();
    System.out.print("Dame el valor de m: ");
    int m = s.nextInt();
    if (m >= n || n < 1 || m < 1) {   // datos erróneos
      System.err.println("Datos de entrada erróneos.");
      System.exit(1);
    }

    // Resultado
    long combinatorial = factorial(n) / (factorial(m) * factorial(n-m));
    System.out.printf("El número combinatorio de %d sobre %d es %d\n", n, m, combinatorial);
  }

  /**
   * Calcula y devuelve el factorial de un número.
   * 
   * @param num número a calcular.
   * @return factorial
   */
  static public long factorial(int num) {
    long f = 1;
    for (int i = num; i > 1; i--) {   
      f *= i;
    }
    return f;
  }
}
