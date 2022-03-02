package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej09.mobile.v3;

public class Rate {
  
  String name;
  double minuteFee;
  
  public static Rate of(String rateName) {
    Rate rate = null;
    switch (rateName) {
      case "rata" -> rate = new Rate(rateName, 0.06);
      case "mono" -> rate = new Rate(rateName, 0.12);
      case "bisonte" -> rate = new Rate(rateName, 0.30);
      default -> new IllegalArgumentException("La tarifa indicada es errónea");
    }
    return rate;
  }
  
  private Rate(String name, double minuteFee) {
    this.name = name;
    this.minuteFee = minuteFee;
  }

  public double price(int seconds) {
    return seconds * minuteFee / 60;
  }

}
