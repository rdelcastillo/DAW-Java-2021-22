package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej09.mobile.v2;

import org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej09.terminal.Terminal;

/**
 * Ejercicio del libro "Aprende Java con Ejercicios", edición 2019.
 * 
 * Subclase de Terminal. Cada móvil lleva asociada una tarifa que puede ser
 * “rata”, “mono” o “bisonte”. El coste por minuto es de 6, 12 y 30 céntimos
 * respectivamente. Se tarifican los segundos exactos. Obviamente, cuando un
 * móvil llama a otro, se le cobra al que llama, no al que recibe la llamada.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Mobile extends Terminal {
  
  private String rate;
  private double price; 
  
  public Mobile(String number, String rate) {
    super(number);
    if (!Rates.exists(rate)) {
      throw new IllegalArgumentException("La tarifa indicada es errónea");
    }
    this.rate = rate;
    this.price = 0;
  }

  public String getRate() {
    return rate;
  }
  
  public double getPrice() {
    return price;
  }
  
  @Override
  public void call(Terminal other, int seconds) {
    super.call(other, seconds);
    price += Rates.price(rate) * seconds / 60;
  }

  @Override
  public String toString() {
    return super.toString() + " - tarificados " + String.format("%.2f euros", price);
  }
}
