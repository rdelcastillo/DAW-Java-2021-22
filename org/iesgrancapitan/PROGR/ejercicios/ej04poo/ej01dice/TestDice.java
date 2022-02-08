package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej01dice;

/**
 * Prueba de la clase Dice.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class TestDice {

  private static final int ROLLS = 5;

  public static void main(String[] args) {
    Dice dice = new Dice();
    
    for (int i = 1; i <= ROLLS; i++) {
      dice.roll();
      System.out.println("Tirada " + i + ": " + dice);
    }
  }

}
