package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej06brisca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej03Deck.Card;

/**
 * Programa que genere una secuencia de 5 cartas de la baraja española y suma los puntos según 
 * el juego de la brisca. El valor de las cartas se debe guardar en una estructura HashMap que
 * debe contener parejas (figura, valor), por ejemplo (“caballo”, 3). 
 * 
 * La secuencia de cartas debe ser una estructura de la clase ArrayList que contiene objetos de 
 * la clase Carta. 
 * 
 * El valor de las cartas es el siguiente: 
 * as → 11, tres → 10, sota → 2, caballo → 3, rey → 4; el resto de cartas no vale nada.
 * 
 * Ejercicio del libro "Aprende Java con Ejercicios", edición 2019.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Brisca {
  
  private static final int NUM_CARDS = 5;
  private static Map<Integer, Integer> points = new HashMap<>(Map.of(1,11, 3,10, 10,2, 11,3, 12,4));
  
  public static void main(String[] args) {
    List<Card> cards = new ArrayList<>();
    
    // generamos las cartas
    while (cards.size() < NUM_CARDS) {
      Card c = new Card();
      if (!cards.contains(c)) {
        cards.add(c);
      }
    }
    
    // mostramos cartas y puntuación
    System.out.println("Cartas generadas para la brisca");
    System.out.println("-------------------------------");
    int p = 0;
    for (Card c: cards) {
      System.out.println(c);
      if (points.containsKey(c.getNumber())) {
        p += points.get(c.getNumber());
      }
    }
    System.out.println("\nPuntuación: " + p);
  }

}
