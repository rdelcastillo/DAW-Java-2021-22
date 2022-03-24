package org.iesgrancapitan.PROGR.examenes.trimestre2poo.cashregister;

import org.iesgrancapitan.PROGR.ejercicios.util.Menu;
import org.iesgrancapitan.PROGR.ejercicios.util.Util;

/**
 * Prueba con un menú de la clase CashRegister.
 * 
 * Examen Programación 2º trimestre curso 2021/22.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class CashRegisterMenu {
  
  private static CashRegister cash = new CashRegister();

  public static void main(String[] args) {
    Menu menu = new Menu("Gestión de la caja registradora",
        "Entrada de movimiento", "Salida de movimiento",
        "Borrado del último movimiento", "Mostrar caja", "Salir");

    int opc;
    do {
      opc = menu.choose();
      switch (opc) {
        case 1 -> makeEntry();
        case 2 -> makeOutput();
        case 3 -> cash.deleteLast();
        case 4 -> System.out.println(cash + "\n");
      }
    } while (opc != menu.lastOption());
    
    System.out.println("¡Adiós!");
  }

  private static void makeEntry() {
    double amount = Util.readDouble("Cantidad a añadir a la caja");
    String concept = Util.readStr("Concepto de la entrada","\n");
    cash.add(amount, concept);
  }

  private static void makeOutput() {
    double amount = Util.readDouble("Cantidad a retirar de la caja");
    String concept = Util.readStr("Concepto de la salida","\n");
    cash.add(-amount, concept);
  }

}
