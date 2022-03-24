package org.iesgrancapitan.PROGR.examenes.trimestre2poo.currentaccount;

import java.time.LocalDate;

/**
 * Test Examen Programación 2º trimestre curso 2021/22.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class TestCurrentAccount {

  public static void main(String[] args) {
    CurrentAccount account1 = new CurrentAccount("Titular de la cuenta1");
    System.out.println("Creada cuenta1 -> " + account1);
    account1.deposit(LocalDate.of(2022, 3, 1), 2500, "Apertura de la cuenta1");
    
    CurrentAccount account2 = new CurrentAccount("Titular de la cuenta2");
    account2.deposit(LocalDate.of(2022, 3, 1), 1500, "Apertura de la cuenta2");
    System.out.println("Creada cuenta2 -> " + account2);
    
    CurrentAccount account3 = new CurrentAccount("Titular de la cuenta3");
    account3.deposit(LocalDate.of(2022, 3, 2), 6000, "Apertura de la cuenta2");
    System.out.println("Creada cuenta3 -> " + account3);
    
    account1.deposit(2000, "Cobro de nómina");
    account1.withdraw(600, "Recibo de la luz");
    account3.deposit(75, "Ingreso en cajero");
    account1.withdraw(55, "Recibo del agua");
    account2.transfer(account1, 100, "Deuda pendiente");
    account1.transfer(account3, 250, "Regalo de cumpleaños");
    account3.transfer(account1, 22, "Bizum de la cena");
    
    // El movimiento siguiente tiene que dar una excepción
    //account1.deposit(LocalDate.of(2022, 3, 1), 1500, "Este ingreso falla");
    
    // Impresión de movimientos
    System.out.println("\n" + account1.getMovements());
  }

}
