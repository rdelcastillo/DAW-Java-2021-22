package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej10currentaccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Ampliación de la clase Cuenta Corriente del tema anterior.
 * 
 * Cada cuenta lleva un registro de todos los movimientos realizados: ingresos, cargos y
 * transferencias (tanto enviadas como recibidas).
 * 
 * Ejercicio del libro "Aprende Java con Ejercicios", edición 2019.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class CurrentAccount {
  
  private static List<Long> accounts = new ArrayList<Long>();
  
  private long number;
  private double balance;
  private List<String> movements;
  
  public CurrentAccount() {
    balance = 0;
    createNumberAccount();
    createMovementsAccount();
  }
  
  public CurrentAccount(int balance) {
    this.balance = balance;
    createNumberAccount();
    createMovementsAccount();
  }

  private void createNumberAccount() {
    do {
      number = 1 + (long) (Math.random() * 9999999999L);
    } while (accounts.contains(number));
    accounts.add(number);
  }
  
  private void createMovementsAccount() {
    movements = new ArrayList<>();
    movements.add("Creada cuenta " + numberToStr() + " " + balanceToStr());
  }
  
  public long getNumber() {
    return number;
  }

  public double getBalance() {
    return balance;
  }
  
  public String getMovements() {
    String movementsStr = "Movimientos de la cuenta " + numberToStr() + "\n"
        + "-----------------------------------\n";
    for (String m: movements) {
      movementsStr += m + "\n";
    }
    movementsStr = movementsStr.substring(0, movementsStr.length()-1);  // quito el \n final
    return movementsStr;
  }

  public void deposit(double money) {
    throwExceptionIfMoneyIsNegative(money);
    balance += money;
    movements.add("Ingreso de " + moneyToStr(money) +  " " + balanceToStr());
  }

  public void withdraw(double money) {
    throwExceptionIfMoneyIsNegative(money);
    balance -= money;
    movements.add("Cargo de " + moneyToStr(money) + " " + balanceToStr());
  }

  public void transfer(CurrentAccount other, double money) {
    throwExceptionIfMoneyIsNegative(money);
    balance -= money;
    movements.add("Transferencia emitida de " + moneyToStr(money) + " a la cuenta " 
        + other.numberToStr() + " " + balanceToStr());
    other.balance += money;
    other.movements.add("Transferencia recibida de " + moneyToStr(money) + " de la cuenta "
        + numberToStr() + " " + other.balanceToStr());
  }

  private void throwExceptionIfMoneyIsNegative(double money) {
    if (money <= 0) {
      throw new IllegalArgumentException("El dinero de esta operación tiene que ser mayor que cero.");
    }
  }

  @Override
  public String toString() {
    return "Número de cuenta: " + numberToStr() + " Saldo: " + moneyToStr(balance);
  }

  private String numberToStr() {
    return String.format("%010d", number);
  }
  
  private String balanceToStr() {
    return "Saldo: " + moneyToStr(balance);
  }
  
  private String moneyToStr(double money) {
    return String.format("%.2f €", money);
  }
  
}
