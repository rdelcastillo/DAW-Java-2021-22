package org.iesgrancapitan.PROGR.ejemplos.poo.exceptions.currentaccount;

public class TestCurrentAccount {

  public static void main(String[] args) {
    CurrentAccount account1 = new CurrentAccount();
    CurrentAccount account2 = new CurrentAccount(1500);
    CurrentAccount account3 = new CurrentAccount(6000);

    try {
      account1.deposit(2000);
      account2.withdraw(600);
      account3.deposit(75);
      account1.withdraw(55);
      account3.withdraw(7000);
      account2.transfer(account3, 100);
      
    } catch (NegativeBalanceException e) {
      System.out.println("Error al hacer las operaciones: " + e.getMessage());
    
    } finally {
      System.out.println("\nLas cuentas después de las operaciones han quedado así");
      System.out.println(account1);
      System.out.println(account2);
      System.out.println(account3);
    }

  }

}
