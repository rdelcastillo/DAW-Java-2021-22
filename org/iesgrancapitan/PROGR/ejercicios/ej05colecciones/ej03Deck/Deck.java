package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej03Deck;

/**
 * Programa que escoge al azar 10 cartas de la baraja española sin repetir ninguna.
 * 
 * @author Rafael del Castillo.
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

  private static final int SIZE_DECK = 10;

  public static void main(String[] args) {
    List<Card> deck = new ArrayList<>();
    
    do {
      Card card = new Card();
      if (!deck.contains(card)) {
        deck.add(card);
      }
    } while (deck.size() < SIZE_DECK);
    
    Collections.sort(deck);
    System.out.println("Cartas escogidas: " + deck);
  }

}
