package org.iesgrancapitan.PROGR.examenes.trimestre2poo.cashregister;

import java.time.LocalDateTime;

public class TestCashRegister {

  public static void main(String[] args) {
    var cashRegister = new CashRegister();
    
    cashRegister.add(LocalDateTime.of(2022, 3, 18, 8, 10), 100, "Apertura de la caja");
    cashRegister.add(LocalDateTime.of(2022, 3, 19, 8, 11), -10, "Pago de tasas");
    cashRegister.add(LocalDateTime.of(2022, 3, 19, 8, 25), 15, "Venta variada");
    
    // si descomentamos la línea siguiente debe saltar una excepción 
    //cashRegister.add(LocalDateTime.of(2022, 3, 10, 7, 10), 10, "Apertura de la caja"); 
    
    cashRegister.add(LocalDateTime.of(2022, 3, 20, 8, 10), -50, "Compra de papel");
    cashRegister.add(LocalDateTime.of(2022, 3, 20, 10, 11), -10, "Pago al repartidor");
    cashRegister.add(LocalDateTime.of(2022, 3, 20, 18, 25), 150, "Venta de libros");
    cashRegister.add(LocalDateTime.of(2022, 3, 20, 19, 15), 15, "Venta variada");
    
    // añadimos movimiento, lo borramos y ponemos otro
    cashRegister.add(0.75, "Esto no debe salir");
    cashRegister.deleteLast();
    cashRegister.add(0.35, "Cuadre de caja");
    
    System.out.println(cashRegister);
  }

}
