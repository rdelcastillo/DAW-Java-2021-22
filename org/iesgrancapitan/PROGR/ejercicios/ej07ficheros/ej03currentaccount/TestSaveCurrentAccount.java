package org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej03currentaccount;

import java.io.IOException;

public class TestSaveCurrentAccount {

  public static void main(String[] args) {
    CurrentAccount account1 = new CurrentAccount();
    CurrentAccount account2 = new CurrentAccount(1500);
    CurrentAccount account3 = new CurrentAccount(6000);
    account1.deposit(2000);
    account1.withdraw(600);
    account3.deposit(75);
    account1.withdraw(55);
    account2.transfer(account1, 100);
    account1.transfer(account3, 250);
    account3.transfer(account1, 22);
    try {
      account1.save("cuenta1.txt");
      account2.save("cuenta2.txt");
      account3.save("cuenta3.txt");
    } catch (IOException e) {
      System.err.println("Ha habido errores al guardar los ficheros.");
      e.printStackTrace();
    }
    System.out.println("Proceso realizado.");
  }

}
