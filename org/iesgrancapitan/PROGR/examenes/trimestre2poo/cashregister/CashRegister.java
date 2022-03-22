package org.iesgrancapitan.PROGR.examenes.trimestre2poo.cashregister;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

public class CashRegister {
  
  private List<Movement> movements = new ArrayList<>();
  
  public void add(LocalDateTime dateTime, double amount, String concept) {
    throwExceptionIfDateTimeIsWrong(dateTime);
    movements.add(new Movement(dateTime, amount, concept));
  }
  
  public void add(double amount, String concept) {
    add(LocalDateTime.now(), amount, concept);
  }
  
  public void deleteLast() {
    movements.remove(movements.size()-1);
    Movement.setLastId(lastMovement().getId());
  }

  private void throwExceptionIfDateTimeIsWrong(LocalDateTime dateTime) {
    if (movements.size() == 0) {
      return;
    }
    if (dateTime.isBefore(lastMovement().getDateTime())) {
      throw new IllegalArgumentException("La fecha del movimiento de caja que se quiere añadir "
          + "es anterior al último movimiento (" + lastMovement() + ")");
    }
  }

  private Movement lastMovement() {
    return movements.get(movements.size()-1);
  }

  @Override
  public String toString() {
    double balance = 0;
    String cashRegisterStr = 
        """
        LISTADO DE MOVIMIENTOS DE CAJA
        ------------------------------
        Número Fecha      Hora  Entrada  Salida   SALDO Concepto
        """;
    for (Movement m: movements) {
      balance += m.getAmount();
      cashRegisterStr += movementToStr(m, balance) + "\n";
    }
    LocalDateTime now = LocalDateTime.now();
    cashRegisterStr += "\nImpreso en Córdoba el " 
        + now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) + ", a las "
        + now.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)) + " horas.";
    return cashRegisterStr;
  }

  private String movementToStr(Movement m, double balance) {
    String formatAmount = m.getAmount() >= 0 ? "%7.2f        ": "%15.2f";
    return String.format("%6d %s %s " + formatAmount + " %7.2f %s", 
        m.getId(), 
        m.getDateTime().format(DateTimeFormatter.ofPattern("dd/MM/uuuu")),
        m.getDateTime().format(DateTimeFormatter.ofPattern("hh:mm")),
        Math.abs(m.getAmount()), balance, m.getConcept());
  }
  
}
