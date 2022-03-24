package org.iesgrancapitan.PROGR.examenes.trimestre2poo.currentaccount;

import java.time.LocalDate;

/**
 * Clase Movimiento de Cuenta Corriente.
 * 
 * Examen Programación 2º trimestre curso 2021/22.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

class Movement {
  
  private static int lastNumber = 0;
  
  private int number;
  private LocalDate date;
  private double amount;
  private MovementType type;
  private String concept;
  private long associatedNumberAccount;
  
  Movement(LocalDate date, double amount, MovementType type, String concept,
      long associatedNumberAccount) {
    this.date = date;
    this.amount = amount;
    this.type = type;
    this.concept = concept;
    this.associatedNumberAccount = associatedNumberAccount;
    number = ++lastNumber;
  }
  
  Movement(LocalDate date, double amount, MovementType type, String concept) {
    this(date, amount, type, concept, 0);
  }

  int getNumber() {
    return number;
  }

  LocalDate getDate() {
    return date;
  }

  double getAmount() {
    return amount;
  }

  MovementType getType() {
    return type;
  }

  String getConcept() {
    return concept;
  }

  long getAssociatedNumberAccount() {
    return associatedNumberAccount;
  }

  @Override
  public String toString() {
    return "Movement [number=" + number + ", date=" + date + ", amount=" + amount + ", type=" + type
        + ", concept=" + concept + ", associatedNumberAccount=" + associatedNumberAccount + "]";
  }

}
