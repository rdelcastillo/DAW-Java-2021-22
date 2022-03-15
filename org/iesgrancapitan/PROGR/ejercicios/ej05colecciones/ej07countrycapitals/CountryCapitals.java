package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej07countrycapitals;

import java.util.HashMap;
import java.util.Map;
import org.iesgrancapitan.PROGR.ejercicios.util.Util;

/**
 * Programa que dice la capital de un país en caso de conocer la respuesta y que, además, es capaz
 * de aprender nuevas capitales. En principio, el programa solo conoce las capitales de España, 
 * Portugal y Francia. Estos datos estarán almacenados en un diccionario. 
 * 
 * Los datos sobre capitales que vaya aprendiendo el programa se deben almacenar en el mismo diccionario. 
 * El usuario sale del programa escribiendo la palabra “salir”.
 * 
 * Ejercicio del libro "Aprende Java con Ejercicios", edición 2019.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class CountryCapitals {

  public static void main(String[] args) {
    Map<String,String> countryCapitals = new HashMap<>(Map.of("ESPAÑA","Madrid", 
        "PORTUGAL","Lisboa", "FRANCIA","París"));
    
    for (;;) {
      String country = Util.readStr("Escribe el nombre de un país y te diré su capital");
      if (country.toUpperCase().equals("SALIR")) {
        break;
      }
      String capital = countryCapitals.get(country.toUpperCase());
      if (capital != null) {
        System.out.println("La capital de " + country + " es " + capital + "\n");
      } else {
        capital = Util.readStr("No conozco la respuesta ¿cuál es la capital de " + country + "?");
        countryCapitals.put(country.toUpperCase(), capital);
        System.out.println("Gracias por enseñarme nuevas capitales :)\n");
      }
    }

    System.out.println("\n¡Adiós! ;)");
  }

}
