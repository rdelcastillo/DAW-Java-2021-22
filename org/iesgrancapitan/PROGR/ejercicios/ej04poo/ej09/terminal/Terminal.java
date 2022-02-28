package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej09.terminal;

/**
 * Ejercicio del libro "Aprende Java con Ejercicios", edición 2019.
 * 
 * Un terminal tiene asociado un número. Los terminales se pueden llamar unos a otros 
 * y el tiempo de conversación corre para ambos
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Terminal {
  
  private String number;
  private int talkTime;
  
  public Terminal(String number) {
    if (!isPhoneNumber(number)) {
      throw new IllegalArgumentException("El número de teléfono es erróneo");
    }
    this.number = number.replace(" ", "");
  }

  public String getNumber() {
    return number;
  }

  public int getTalkTime() {
    return talkTime;
  }
  
  public void call(Terminal other, int time) {
    if (time < 0) {
      throw new IllegalArgumentException("El tiempo de conversación no puede ser negativo");
    }
    talkTime += time;
    other.talkTime += time;
  }

  static private boolean isPhoneNumber(String number) {
    try {
      Integer.parseInt(number.replace(" ", ""));
      return true;
    } catch (NumberFormatException e) {
      return false;
    } catch (NullPointerException e) {
      return false;
    }
  }
  
  @Override
  public String toString() {
    return "Nº " + number + " - " + talkTime + "s de conversación";
  }

}
