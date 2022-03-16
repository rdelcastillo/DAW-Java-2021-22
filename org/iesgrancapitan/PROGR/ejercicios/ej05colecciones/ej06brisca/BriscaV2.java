package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej06brisca;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
 * En esta versión usaremos un mapa inmutable en vez de un HashMap, las claves se almacenarán como
 * String y guardaremos la puntuación de todas las cartas. También usaremos un conjunto para guardar
 * las cartas en vez de una lista.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class BriscaV2 {

  private static final int NUM_CARDS = 5;
  private static Map<String, Integer> points = Map.of("as",11, "dos",0, "tres",10, 
      "cuatro",0, "cinco",0, "seis",0, "siete",0, "sota",2, "caballo",3, "rey",4);

  public static void main(String[] args) {
    Set<Card> cards = new HashSet<>();

    // generamos las cartas
    while (cards.size() < NUM_CARDS) {
      cards.add(new Card());
    }

    // mostramos cartas y puntuación
    System.out.println("Cartas generadas para la brisca");
    System.out.println("-------------------------------");
    int p = 0;
    for (Card c: cards) {
      System.out.println(c);
      p += points.get(c.numberToStr());
    }
    System.out.println("\nPuntuación: " + p);
  }

}
