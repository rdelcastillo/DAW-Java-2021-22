package org.iesgrancapitan.PROGR.ejemplos.poo.destructor;

/**
 * Test de la clase que ilustra el concepto de destructor en Java.
 *
 * @author Rafael del Castillo
 */

import java.util.Scanner;

public class TestCar {
  
  private static int numCars = 0;
  private static Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    makeCars(5, "Clio");
    pause();
    makeCars(5, "Honda");
    pause();
    makeCars(5, "BMW");
    in.close();
  }

  private static void makeCars(int n, String model) {
    for (int i = 0; i < n; i++) {
      Car car = new Car(String.format("%04d", ++numCars), model);
      System.out.println("Creado coche " + car + ". Total " + Car.getTotalCars()); 
    }
  }

  private static void pause() {
    System.out.println("Pulsa Intro para continuar...");
    in.nextLine();
    System.gc();    // llamada explícita al recolector de basura de Java
  }
}
