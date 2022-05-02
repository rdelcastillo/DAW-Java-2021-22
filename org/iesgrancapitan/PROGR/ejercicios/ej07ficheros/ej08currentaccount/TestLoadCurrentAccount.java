package org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej08currentaccount;

import java.io.IOException;
import org.iesgrancapitan.PROGR.ejercicios.util.Util;

public class TestLoadCurrentAccount {

  public static void main(String[] args) {
    try {
      String fileAccount = Util.readStr("Nombre de fichero donde se almacenó la cuenta");
      CurrentAccount account = new CurrentAccount(fileAccount);
      System.out.println("\n" + account + "\n\n" + account.getMovements());    
    } 
    catch (IOException e) {
      System.err.println("Ha habido algún error al abrir los ficheros de cuentas.");
      e.printStackTrace();
    } 
    catch (ClassNotFoundException e) {
      System.err.println("El fichero no contiene información de la cuenta corriente.");
      e.printStackTrace();
    } 
  }
}
