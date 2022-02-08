package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej01dice;

/**
 * Simula el comportamiento de un dado. El dado tendrá 6 caras. 
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Dice {
  
  private static final int NUMBER_SIDES = 6;
  
  private int value;
  
  public Dice() {
    roll();
  }

  public void roll() {
    value = 1 + (int) (Math.random() * NUMBER_SIDES); 
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "Dice [value=" + value + "]";
  }

}
