package org.iesgrancapitan.PROGR.ejemplos.poo.date;

import java.util.Scanner;

public class DateTest {

  private static Scanner in = new Scanner(System.in);
  private static String[] DAY_OF_WEEK = {"lunes", "martes", "miércoles", "jueves", "viernes",
      "sábado", "domingo"};

  public static void main(String[] args) {
    Date date1 = new Date();
    System.out.println("Hemos creado un objeto Date vacío: " + date1);
    
    System.out.println("\nAhora vamos a crearlo desde su constructor con parámetros.");
    date1 = readDate("Introduce una fecha.");
    System.out.println("Objeto creado: " + date1);
    System.out.println("El día de la semana correspondiente a esa fecha fue " + DAY_OF_WEEK[date1.dayOfWeek()]);
    
    int days = readInt("\n¿Cuantos días añadimos a la fecha?");
    date1.addDays(days);
    System.out.println("La fecha resultante es " + date1);
    
    days = readInt("\n¿Cuantos días restamos a la fecha?");
    date1.subtractDays(days);
    System.out.println("La fecha resultante es " + date1);
    
    Date date2 = readDate("\nIntroduce otra fecha para compararla con " + date1 + ".");
    System.out.println(date1 + " es " + comparisonResult(date1, date2) + " a " + date2);
    
    in.close();
  }

  private static Date readDate(String prompt) {
    System.out.println(prompt);
    System.out.print("Día: ");
    int day = in.nextInt();
    System.out.print("Mes: ");
    int month = in.nextInt();
    System.out.print("Año: ");
    int year = in.nextInt();
    return new Date(day, month, year);
  }
  
  private static int readInt(String prompt) {
    System.out.print(prompt + " ");
    return in.nextInt();
  }
  
  private static String comparisonResult(Date date1, Date date2) {
    int compare = date1.compareTo(date2);
    String result;
    if (compare < 0) {
      result = "ANTERIOR";
    } else if (compare > 0) {
      result = "POSTERIOR";
    } else {
      result = "IGUAL";
    }
    return result;
  }
}
