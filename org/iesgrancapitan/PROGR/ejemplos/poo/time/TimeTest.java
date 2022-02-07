package org.iesgrancapitan.PROGR.ejemplos.poo.time;

import java.util.Scanner;

public class TimeTest {
  
  private static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    Time time = new Time();
    System.out.println("Hemos creado un objeto Time() vacío: " + time);
    
    System.out.println("Ahora vamos a crearlo desde su constructor con parámetros.");
    time = readTime();
    System.out.println("Objeto creado: " + time);
    
    System.out.print("Añade segundos (+ ó -): ");
    
    System.out.print("Añade minutos (+ ó -): ");
    
    System.out.print("Añade horas (+ ó -): ");
  
  }

  private static Time readTime() {
    System.out.println("Introduce un valor horario:");
    System.out.print("Horas: ");
    int hours = in.nextInt();
    System.out.print("Minutos: ");
    int minutes = in.nextInt();
    System.out.print("Segundos: ");
    int seconds = in.nextInt();
    return new Time(hours, minutes, seconds);
  }

}
