package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej09.vehiculo;

public class Vehicle {
  
  private static int totalVehicles = 0;
  private static int totalKilometers = 0;
  
  private int kilometers;
  
  public Vehicle() {
    kilometers = 0;
    totalVehicles++;
  }
  
  public void travel(int kilometers) {
    if (kilometers < 0) {
      throw new IllegalArgumentException("Los kilómetros a recorrer no pueden ser negativos.");
    }
    this.kilometers += kilometers;
    totalKilometers += kilometers;
  }

  public static int getTotalVehicles() {
    return totalVehicles;
  }

  public static int getTotalKilometers() {
    return totalKilometers;
  }

  public int getKilometers() {
    return kilometers;
  }

  @Override
  public String toString() {
    return "Vehicle [kilometers=" + kilometers + "]";
  }

}
