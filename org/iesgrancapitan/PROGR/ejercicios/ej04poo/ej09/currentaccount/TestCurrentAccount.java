package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej09.currentaccount;

public class TestCurrentAccount {

  public static void main(String[] args) {
    CurrentAccount account1 = new CurrentAccount();
    CurrentAccount account2 = new CurrentAccount(1500);
    CurrentAccount account3 = new CurrentAccount(6000);
    System.out.println(account1);
    System.out.println(account2);
    System.out.println(account3);
    account1.deposit(2000);
    account2.withdraw(600);
    account3.deposit(75);
    account1.withdraw(55);
    account2.transfer(account3, 100);
    System.out.println(account1);
    System.out.println(account2);
    System.out.println(account3);
  }

}
