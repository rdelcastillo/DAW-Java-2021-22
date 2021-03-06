package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej08menulocaldate;

/**
 * Muestra un menú con las siguientes opciones:
 * 
 * - Introducir (por teclado) una fecha pidiendo por teclado año, mes y día en formato dd/mm/aaaa.
 * - Añadir días a la fecha. 
 * - Añadir meses a la fecha. 
 * - Añadir años a la fecha. 
 * - Comparar la fecha introducida con otra. 
 * - Mostrar la fecha en formato largo (ejemplo: "lunes, 1 de febrero de 2021").
 * - Terminar.
 * 
 * @author Rafael del Castillo
 * 
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import org.iesgrancapitan.PROGR.ejercicios.util.Menu;
import org.iesgrancapitan.PROGR.ejercicios.util.Util;

public class Ej08MenuLocalDate {

  private static LocalDate date;

  public static void main(String[] args) {
    Menu menu = createMenu();
    
    int option;
    do {
      option = menu.choose();
      if (date == null && option > 1 && option != menu.lastOption()) {
        System.err.println("La fecha no ha sido introducida.\n");
        continue;
      }
      switch (option) {
        case 1 -> readDate();
        case 2 -> addDaysToDate();
        case 3 -> addMonthsToDate();
        case 4 -> addYearsToDate();
        case 5 -> compareDates();
        case 6 -> printDate();
      }
    } while (option != menu.lastOption());
    
    System.out.println("¡Hasta la próxima! ;-)");
  }

  private static Menu createMenu() {
    return new Menu("Menú de opciones",
        "Introducir fecha", 
        "Añadir días a la fecha",
        "Añadir meses a la fecha", 
        "Añadir años a la fecha",
        "Comparar una fecha con la almacenada",
        "Mostrar la fecha almacenada",
        "Terminar");
  }

  private static void readDate() {
    String dateStr = Util.readStr("Fecha (dd/mm/aaaa)","\n");
    if (isDateOk(dateStr)) {
      date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    } else {
      System.err.println("La fecha introducida es errónea.\n");
    }
  }

  private static void addDaysToDate() {
    int days = Util.readInt("Número de días a añadir a la fecha almacenada","\n");
    date = date.plusDays(days);
  }

  private static void addMonthsToDate() {
    int months = Util.readInt("Número de meses a añadir a la fecha almacenada","\n");
    date = date.plusMonths(months);
  }

  private static void addYearsToDate() {
    int years = Util.readInt("Número de años a añadir a la fecha almacenada","\n");
    date = date.plusYears(years);
  }

  private static void compareDates() {
    String dateStr = Util.readStr("Fecha (dd/mm/aaaa) a comparar con la almacenada","\n");
    if (isDateOk(dateStr)) {
      LocalDate dateToCompare = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
      String resultCompare = dateToCompare.equals(date) ? "IGUAL" :
          dateToCompare.isBefore(date) ? "ANTERIOR" : "POSTERIOR";
      System.out.println("La fecha introducida es " + resultCompare + " a la almacenada.");
      System.out.println("El número de días entre ambas fechas es de " 
          + Math.abs(ChronoUnit.DAYS.between(dateToCompare, date)) + "\n");

    } else {
      System.err.println("La fecha introducida es errónea.\n");
    }
  }

  private static void printDate() {
    System.out.println("La fecha almacenada es " 
        + date.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)) + "\n");
  }
  
  private static boolean isDateOk(String dateStr) {
    try {
      LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/uuuu")
          .withResolverStyle(ResolverStyle.STRICT));
      return true;      
    } catch (DateTimeParseException e) {
      return false;
    }
  }

}
