package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej08menulocaldate;

import java.util.Scanner;

/**
 * Métodos de propósito general.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Util {
  
  private static Scanner in = new Scanner(System.in);
  
  public static String readStr(String prompt) {
    System.out.print(prompt + ": ");
    String str = in.nextLine();
    System.out.println();
    return str;
  }
  
  public static int readInt(String prompt) {
    System.out.print(prompt + ": ");
    int n = in.nextInt();
    in.nextLine();  // sacamos \n del buffer de teclado
    System.out.println();
    return n;
  }

}
