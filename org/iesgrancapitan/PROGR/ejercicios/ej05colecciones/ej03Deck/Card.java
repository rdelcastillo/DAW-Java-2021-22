package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej03Deck;

/**
 * Modelamos una carta de la baraja española:
 * 
 * - Palos: BASTOS, COPAS, ESPADAS, OROS.
 * - Números: del 1 al 7, 10, 11, 12.
 * 
 * Permitimos crear una carta aleatoria o dándole el palo (como enumerado o cadena) y 
 * el número.
 *
 * @author Rafael del Castillo Gomariz
 *
 */

public class Card implements Comparable<Card> {
  
  private Suit suit;
  private int number;
  
  public Card() {
    generateRandomSuit();
    generateRandomNumber();
  }
  
  public Card(Suit suit, int number) {
    if (!isNumberOk(number)) {
      throw new IllegalArgumentException(number + " no es un número de carta válido");
    }
    this.suit = suit;
    this.number = number;
  }
  
  public Card(String suit, int number) {
    if (!isNumberOk(number)) {
      throw new IllegalArgumentException(number + " no es un número de carta válido");
    }
    if (!isSuitOk(suit)) {
      throw new IllegalArgumentException(suit + " no es un palo de carta válido"); 
    }
    this.suit = Suit.valueOf(suit);
    this.number = number;
  }

  public Suit getSuit() {
    return suit;
  }

  public int getNumber() {
    return number;
  }

  @Override
  public String toString() {
    return numberToStr() + " de " + suit.name().toLowerCase();
  }
  
  public String numberToStr() {
    final String[] numbersStr = {"as", "dos", "tres", "cuatro", "cinco", "seis", "siete",
        "sota", "caballo", "rey"};
    return (number <= 7) ? numbersStr[number-1] : numbersStr[number-3];
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + number;
    result = prime * result + ((suit == null) ? 0 : suit.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Card other = (Card) obj;
    if (number != other.number)
      return false;
    if (suit != other.suit)
      return false;
    return true;
  }
  
  @Override
  public int compareTo(Card other) {
    if (suit.equals(other.suit)) {
      return number - other.number;
    } else {
      return suit.compareTo(other.suit);
    }
  }

  private boolean isNumberOk(int number) {
    return (number >= 1 && number <= 7) || (number >= 10 && number <= 12);
  }
  
  private boolean isSuitOk(String suit) {
    try {
      Suit.valueOf(suit.toUpperCase());
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }

  private void generateRandomNumber() {
    number = (int) (Math.random()*10 + 1);
    if (number > 7) {   // no existe el 8 y el 9, del 7 pasamos al 10
      number += 2;
    }
  }

  private void generateRandomSuit() {
    Suit[] suits = Suit.values();
    suit = suits[(int) (Math.random()*suits.length)];
  }
  
}
