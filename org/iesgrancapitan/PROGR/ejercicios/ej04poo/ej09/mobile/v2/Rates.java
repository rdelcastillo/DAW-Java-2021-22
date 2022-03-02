package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej09.mobile.v2;

public class Rates {
  
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
