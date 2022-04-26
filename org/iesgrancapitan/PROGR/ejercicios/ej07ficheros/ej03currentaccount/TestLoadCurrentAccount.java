package org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej03currentaccount;

import java.io.IOException;

public class TestLoadCurrentAccount {

  public static void main(String[] args) {
    try {
      CurrentAccount account1 = new CurrentAccount("cuenta1.txt");
      CurrentAccount account2 = new CurrentAccount("cuenta2.txt");
      CurrentAccount account3 = new CurrentAccount("cuenta3.txt");
      System.out.println(account1.getMovements() + "\n");
      System.out.println(account2.getMovements() + "\n");
      System.out.println(account3.getMovements());
      
    } catch (IOException e) {
      System.err.println("Ha habido algún error al abrir los ficheros de cuentas");
      e.printStackTrace();
    } catch (ParseErrorCurrentAccountException e) {
      System.err.println("Algún fichero tiene un formato incorrecto");
      e.printStackTrace();
    } 

  }

}
