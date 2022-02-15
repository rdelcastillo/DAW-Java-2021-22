package org.iesgrancapitan.PROGR.ejemplos.poo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

/**
 * Prueba clase LocalDate.
 * 
 * @author rafa
 *
 */
public class TestLocalDate {

  public static void main(String[] args) {
    LocalDate date1 = LocalDate.now();
    LocalDate date2 = LocalDate.of(2022,2,15);
    LocalDate date3 = date1.plusDays(0);  // sumamos 0 días, misma fecha
    LocalDate date4 = date1;              // esta clase es inmutable
    
    // Inicio
    System.out.println("Momento inicial:");
    System.out.println("Fecha1: " + date1);
    System.out.println("Fecha2: " + date2);
    System.out.println("Fecha3: " + date3);
    System.out.println("Fecha4: " + date4.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + "\n");
    
    // Cambiamos f3
    date3 = LocalDate.of(date3.getYear(), date3.getMonthValue(), 12);
    System.out.println("Asignamos 12 al día de Fecha3: " + date3);
     
    // Cambiamos f4 
    System.out.println("Restamos dos años a Fecha4: " + date4);
    date4 = date4.minusYears(2);
    System.out.println("Fecha4: " + date4 + "\n");
    
    // Comparamos
    System.out.println("Comparamos Fecha1 (" + date1 + ") y Fecha2 (" + date2 + ") " + date1.compareTo(date2));
    System.out.println("Comparamos Fecha3 (" + date3 + ") y Fecha1 (" + date1 + ") " + date3.compareTo(date1) + "\n");
    System.out.println("¿'" + date1 + "' es igual a '" + date4 + "'? " + date1.equals(date4));
    System.out.println("¿'" + date2 + "' es anterior a '" + date3 +"'? " + date2.isBefore(date3) + "\n");
    
    // Sumamos y restamos
    System.out.print("Sumamos 50 días a Fecha1 (" + date1 + ") y se lo asignamos a Fecha2: ");
    date2 = date1.plus(50, ChronoUnit.DAYS);
    System.out.println(date2.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
    System.out.println("Y Fecha2 sin esos 50 días es Fecha1: " + date2.minusDays(50) + "\n");
    
    // Probamos la resta de fechas
    System.out.println("La diferencia entre " + date1 + " y " + date2 + " son " + ChronoUnit.DAYS.between(date1, date2) + " días.");
  }

}
