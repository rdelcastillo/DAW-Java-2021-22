package org.iesgrancapitan.PROGR.examenes.trimestre2poo.currentaccount;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Cuenta Corriente.
 * 
 * Examen Programación 2º trimestre curso 2021/22.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class CurrentAccount {
  
  private static List<Long> accounts = new ArrayList<Long>();
  
  private long number;
  private String holder;
  private List<Movement> movements = new ArrayList<>();
  
  public CurrentAccount(String holder) {
    if (holder == null || holder.isBlank()) {
      throw new IllegalArgumentException("El titular de la cuenta no puede estar vacío.");
    }
    this.holder = holder;
    createNumberAccount();
  }
  
  private void createNumberAccount() {
    do {
      number = 1 + (long) (Math.random() * 9999999999L);
    } while (accounts.contains(number));
    accounts.add(number);
  }
  
  public String getHolder() {
    return holder;
  }

  public long getNumber() {
    return number;
  }

  public double getBalance() {
    double balance = 0;
    for (Movement m: movements) {
      balance += m.getAmount();
    }
    return balance;
  }
  
  public String getMovements() {
    double balance = 0;
    String movementsStr = 
        """
        LISTADO DE MOVIMIENTOS DE CUENTA
        --------------------------------
        Operación Tipo Fecha        Ingresos     Cargos      SALDO Concepto
        """;
    for (Movement m: movements) {
      balance += m.getAmount();
      movementsStr += movementToStr(m, balance) + "\n";
    }
    LocalDateTime now = LocalDateTime.now();
    movementsStr += "\n" + this + ". A fecha: "
        + now.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) + " a las "
        + now.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)) + " horas.";
    return movementsStr;
  }

  private String movementToStr(Movement m, double balance) {
    String formatAmount = m.getAmount() >= 0 ? "%10.2f           ": "%21.2f";
    return String.format("%9d %s %s " + formatAmount + " %10.2f %s%s", 
        m.getNumber(), m.getType().code(), m.getDate().format(DateTimeFormatter.ISO_DATE), 
        Math.abs(m.getAmount()), balance, 
        m.getAssociatedNumberAccount() != 0 ? m.getType() + "-" + m.getAssociatedNumberAccount() + ". ": "",
        m.getConcept());
  }

  public void deposit(LocalDate date, double money, String concept) {
    throwExceptionIfMoneyIsNegative(money);
    throwExceptionIfDateIsWrong(date);
    movements.add(new Movement(date, money, MovementType.INGRESO, concept));
  }
  
  public void deposit(double money, String concept) {
    deposit(LocalDate.now(), money, concept);
  }

  public void withdraw(LocalDate date, double money, String concept) {
    throwExceptionIfMoneyIsNegative(money);
    throwExceptionIfDateIsWrong(date);
    movements.add(new Movement(date, -money, MovementType.CARGO, concept));
  }
  
  public void withdraw(double money, String concept) {
    withdraw(LocalDate.now(), money, concept);
  }

  public void transfer(LocalDate date, CurrentAccount other, double money, String concept) {
    throwExceptionIfMoneyIsNegative(money);
    throwExceptionIfDateIsWrong(date);  
    other.throwExceptionIfDateIsWrong(date);
    movements.add(new Movement(date, -money, MovementType.TRANSFERENCIA_ENVIADA, concept, other.number));
    other.movements.add(new Movement(date, money, MovementType.TRANSFERENCIA_RECIBIDA, concept, number));
  }
  
  public void transfer(CurrentAccount other, double money, String concept) {
    transfer(LocalDate.now(), other, money, concept);
  }

  @Override
  public String toString() {
    return "Cuenta: " + numberToStr() + ". Titular: " + holder + ". Saldo: " + moneyToStr(getBalance());
  }

  private String numberToStr() {
    return String.format("%010d", number);
  }
    
  private String moneyToStr(double money) {
    return String.format("%.2f €", money);
  }
  
  private void throwExceptionIfMoneyIsNegative(double money) {
    if (money <= 0) {
      throw new IllegalArgumentException("El dinero de esta operación tiene que ser mayor que cero.");
    }
  }
  
  private void throwExceptionIfDateIsWrong(LocalDate date) {
    if (!movements.isEmpty() && date.isBefore(lastMovement().getDate())) {
      throw new IllegalArgumentException("La fecha del movimiento bancario que se quiere añadir "
          + "es anterior al último movimiento (" + lastMovement() + ")");
    }
  }
  
  private Movement lastMovement() {
    return movements.get(movements.size()-1);
  }
  
}
