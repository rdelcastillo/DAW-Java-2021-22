package org.iesgrancapitan.PROGR.ejemplos.poo.exceptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ExceptionExample {

  public static void main(String[] args) {
    String date1 = "Esto debería ser una fecha pero no lo es";
    String date2 = "22/02/2022";
    
    System.out.println(isDateOk(date1));
    System.out.println(isDateOk(date2));
  }

  private static boolean isDateOk(String date) {
    try {
      LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
      return true;
    } catch (DateTimeParseException e) {
      return false;
    }
  }

  

}
