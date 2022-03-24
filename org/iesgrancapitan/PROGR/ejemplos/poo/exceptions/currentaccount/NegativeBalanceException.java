package org.iesgrancapitan.PROGR.ejemplos.poo.exceptions.currentaccount;

public class NegativeBalanceException extends Exception {

  private static final long serialVersionUID = 1L;

  public NegativeBalanceException(String message) {
    super(message);
  }
    
}
