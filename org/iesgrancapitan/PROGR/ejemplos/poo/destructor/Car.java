package org.iesgrancapitan.PROGR.ejemplos.poo.destructor;

/**
 * Clase para ilustrar el concepto de destructor en Java.
 * 
 * Más información: https://www.javatpoint.com/java-destructor
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Car {
  
  private static int totalCars = 0;
  
  private String mat;
  private String model;
  
  public Car(String mat, String model) {
    this.mat = mat;
    this.model = model;
    totalCars++;
  }

  public static int getTotalCars() {
    return totalCars;
  }

  public String getMat() {
    return mat;
  }

  public String getModel() {
    return model;
  }
  
  @Override
  public String toString() {
    return "Car [mat=" + mat + ", model=" + model + "]";
  }

  protected void finalize() {
    System.out.println("El recolector de basura elimina " + this);
    totalCars--;
  }

}
