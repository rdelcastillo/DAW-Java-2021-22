package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej09.mobile.v2;

/**
 * Ejemplo de como podríamos controlar las tarifas de un objeto Mobile
 * con un Map quitando la responsabilidad a la clase Mobile.
 * 
 * Para usar esta clase hay que borrar el fichero Rates.java y refactorizar
 * este para que la clase se llame Rates.
 * 
 * @author Rafael del Castillo.
 */

import java.util.Map;

public class RatesWithMap {
  
  private static Map<String,Double> rates = Map.of("rata",0.06, "mono",0.12, "bisonte",0.30);

  public static boolean exists(String rateName) {
    return rates.containsKey(rateName);
  }

  public static double price(String rateName) {
    return rates.get(rateName);
  }

}
