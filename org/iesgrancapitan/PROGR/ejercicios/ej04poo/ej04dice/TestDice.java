package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej04dice;

/**
 * Prueba de la clase Dice con un vector de 4 dados que se lanzan 
 * una serie de veces.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class TestDice {

  private static final int ROLLS = 5;

  public static void main(String[] args) {
    Dice[] dices = new Dice[4];
    
    dices[0] = new Dice(); 
    dices[1] = new Dice(2);
    dices[2] = new Dice(5, 10);
    dices[3] = new Dice();
    
    System.out.println("Valores iniciales de nuestros dados:");
    for (int i = 0; i < dices.length; i++) {
      System.out.println("Dado " + (i+1) + ": " + dices[i]);
    }
    
    for (int i = 1; i <= ROLLS; i++) {
      System.out.print("\nTirada de dados nº " + i + ": ");
      for (Dice d: dices) {
        d.roll();
        System.out.print(d + " ");
      }
    }
  }

}
