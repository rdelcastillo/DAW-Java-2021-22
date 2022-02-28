package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej09.mobile;

import java.util.Map;

public class Rates {
  
  private static Map<String,Integer> rates = Map.of("rata",6,"mono",12,"bisonte",30);

  public static boolean exists(String rate) {
    return rates.containsKey(rate);
  }

  public static double price(String rate) {
    return rates.get(rate);
  }

}
