package org.iesgrancapitan.PROGR.ejercicios.util;

import java.util.Scanner;

/**
 * Conjunto de funciones genéricas que me serán de utilidad para simplificar procesos.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Util {
  
  private static Scanner in = new Scanner(System.in);

  public static String readStr(String prompt) {
    System.out.print(prompt + ": ");
    return in.nextLine();
  }
  
  public static String readStr(String prompt, String end) {
    String str = readStr(prompt);
    System.out.print(end);
    return str;
  }

  public static int readInt(String prompt) {
    System.out.print(prompt + ": ");
    int n = in.nextInt();
    in.nextLine();  // sacamos \n del buffer de teclado
    return n;
  }
  
  public static int readInt(String prompt, String end) {
    int n = readInt(prompt);
    System.out.print(end);
    return n;
  }
  
  public static double readDouble(String prompt) {
    System.out.print(prompt + ": ");
    double n = in.nextDouble();
    in.nextLine();  // sacamos \n del buffer de teclado
    return n;
  }
  
  public static double readDouble(String prompt, String end) {
    double n = readDouble(prompt);
    System.out.print(end);
    return n;
  }
  
  public static boolean confirm(String prompt) {
    String resp;
    for (;;) {
      resp = Util.readStr(prompt).toUpperCase();
      if (resp.equals("S") || resp.equals("N")) {
        break;
      }
      System.out.println("Respuesta incorrecta, pulse S o N y después Intro");
    }
    return resp.equals("S");
  }
  
  public static boolean confirm() {
    return confirm("¿Está seguro/a? (S/N)");
  }

  public static int randomInt(int min, int max) {
    return min + (int) (Math.random() * (max-min+1));
  }
}
