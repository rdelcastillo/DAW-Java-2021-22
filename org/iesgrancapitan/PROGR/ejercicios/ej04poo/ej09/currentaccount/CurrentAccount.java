package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej09.currentaccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Cuenta Corriente.
 * Ejercicio del libro "Aprende Java con Ejercicios", edición 2019.
 * 
 * Cada cuenta corriente tiene un número de cuenta de 10 dígitos. 
 * Para simplificar, el número de cuenta (que no se puede repetir)
 * se genera de forma aleatoria cuando se crea una cuenta nueva. 
 * 
 * La cuenta se puede crear con un saldo inicial; en caso de no especificar 
 * saldo, se pondrá a cero inicialmente.
 * 
 * En una cuenta se pueden hacer ingresos y gastos. También es posible hacer
 * una transferencia entre una cuenta y otra. Se permite el saldo negativo.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class CurrentAccount {
  
  private static List<Long> accounts = new ArrayList<Long>();
  
  private long number;
  private double balance;
  
  public CurrentAccount() {
    balance = 0;
    createNumberAccount();
  }
  
  public CurrentAccount(int balance) {
    this.balance = balance;
    createNumberAccount();
  }

  private void createNumberAccount() {
    do {
      number = 1 + (long) (Math.random() * 9999999999L);
    } while (accounts.contains(number));
    accounts.add(number);
  }
  
  public long getNumber() {
    return number;
  }

  public double getBalance() {
    return balance;
  }

  public void deposit(double money) {
    throwExceptionIfMoneyIsNegative(money);
    balance += money;
  }
  
  public void withdraw(double money) {
    throwExceptionIfMoneyIsNegative(money);
    balance -= money;
  }
  
  public void transfer(CurrentAccount other, double money) {
    throwExceptionIfMoneyIsNegative(money);
    this.balance -= money;
    other.balance += money;
  }

  private void throwExceptionIfMoneyIsNegative(double money) {
    if (money <= 0) {
      throw new IllegalArgumentException("El dinero de esta operación tiene que ser mayor que cero.");
    }
  }

  @Override
  public String toString() {
    return "Número de cuenta: " + String.format("%010d", number) + " Saldo: " + String.format("%.2f €", balance);
  }
  
}
