package org.iesgrancapitan.PROGR.ejercicios.ej04poo;

/**
 * Simula el comportamiento de un dado. Por defecto el dado tendrá 6 caras. 
 * 
 * Tendremos tres constructores:
 * 
 * - Uno al que no se le pasa nada e inicializa el dado al azar.
 * - Otro al que sólo se le pasa que número tiene el dado en la cara superior.
 * - Otro con el número del dado en la cara superior y el número de caras del dado. 
 * 
 * Implementaremos los getters, el método roll() que tirará el dado al azar y el toString(). 
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Dice {
  
  private static final int MIN_SIDES = 2;
  private static final int DEFAULT_SIDES = 6;
  
  private int sides = DEFAULT_SIDES;
  private int value;
  
  public Dice() {
    roll();
  }

  public Dice(int value) {
    setValue(value);
  }


  public Dice(int value, int sides) {
    setSides(sides);
    setValue(value);
  }

  private void setSides(int sides) {
    if (sides < MIN_SIDES) {
      throw new IllegalArgumentException(sides + " es erróneo. El número mínimo de caras es: " + MIN_SIDES);
    }
    this.sides = sides;
  }

  private void setValue(int value) {
    if (value < 1 || value > sides) {
      throw new IllegalArgumentException(value + " es erróneo. Solo hay " + sides + " caras.");
    }
    this.value = value;
  }
  
  public void roll() {
    value = 1 + (int) (Math.random() * sides); 
  }

  public int getSides() {
    return sides;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "[sides=" + sides + ", value=" + value + "]";
  }
}
