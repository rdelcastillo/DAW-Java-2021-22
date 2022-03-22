package org.iesgrancapitan.PROGR.examenes.trimestre2poo.cashregister;

import java.time.LocalDateTime;

class Movement {
  
  private static int lastId = 0;
  
  private int id;
  private LocalDateTime dateTime;
  private double amount;
  private String concept;
  
  Movement(LocalDateTime dateTime, double amount, String concept) {
    this.dateTime = dateTime;
    this.amount = amount;
    this.concept = concept;
    id = ++lastId;
  }

  int getId() {
    return id;
  }

  LocalDateTime getDateTime() {
    return dateTime;
  }

  double getAmount() {
    return amount;
  }

  String getConcept() {
    return concept;
  }

  static int getLastId() {
    return lastId;
  }

  static void setLastId(int lastId) {
    Movement.lastId = lastId;
  }

  @Override
  public String toString() {
    return "Movement [number=" + id + ", dateTime=" + dateTime + ", amount=" + amount
        + ", concept=" + concept + "]";
  }
  
}
