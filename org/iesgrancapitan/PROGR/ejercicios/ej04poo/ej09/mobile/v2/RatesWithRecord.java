package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej09.mobile.v2;

/**
 * Ejemplo de como podríamos controlar las tarifas de un objeto Mobile
 * con un Record quitando la responsabilidad a la clase Mobile.
 * 
 * Para usar esta clase hay que borrar el fichero Rates.java y refactorizar
 * este para que la clase se llame Rates.
 * 
 * @author Rafael del Castillo.
 */


public class RatesWithRecord {
  
  private record Rate(String name, double price) {};
  
  private static Rate[] rates = {new Rate("rata",0.06), new Rate("mono",0.12), new Rate("bisonte",0.30)};

  public static boolean exists(String rateName) {
    for (Rate r: rates) {
      if (r.name().equals(rateName)) {
        return true;
      }
    }
    return false;
  }

  public static double price(String rateName) {
    for (Rate r: rates) {
      if (r.name().equals(rateName)) {
        return r.price();
      }
    }
    throw new IllegalArgumentException("La tarifa " + rateName + " no existe");
  }

}
