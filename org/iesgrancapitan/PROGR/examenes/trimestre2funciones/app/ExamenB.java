package org.iesgrancapitan.PROGR.examenes.trimestre2funciones.app;

import java.util.Scanner;
import org.iesgrancapitan.PROGR.examenes.trimestre2funciones.date.Date;

public class ExamenB {

  public static Scanner in = new Scanner(System.in);
  public static String date = "";
  
  public static void main(String[] args) {
    boolean menuIsActive = true;

    while (menuIsActive) {
      int option = menu();
      
      // Controlamos que no se pueda ejecutar ninguna opción que no sea 1 o 7 si no hay valor de tiempo
      if (option > 1 && option < 7 && date.isEmpty()) {
        System.out.println("Primero debe introducir una fecha.\n");
        continue;
      }
      
      // Proceso normal
      switch (option) {
        case 1 -> readDate();
        case 2 -> addDaysToDate();
        case 3 -> subtractDaysFromDate();
        case 4 -> compareDates();
        case 5 -> printDayOfWeek();
        case 6 -> System.out.println("El valor de la fecha es: " + date);
        case 7 -> menuIsActive = false;
        default -> System.out.println("Opción incorrecta.");
      }
    }
    
    in.close();
    System.out.println("¡Adiós!");
  }

  public static int menu() {
    System.out.println("\nMenú de opciones");
    System.out.println("----------------");
    System.out.println("1. Introducir una fecha entre el 01/01/2000 y el 31/12/2099.\n"
        + "2. Sumar días a la fecha.\n"
        + "3. Restar días a la fecha.\n"
        + "4. Comparar la fecha con otra.\n"
        + "5. Decir el día de la semana de la fecha.\n"
        + "6. Mostrar la fecha.\n"
        + "7. Finalizar.");
   
    // leo la opción
    System.out.print("\nIntroduce una opción: ");
    int option = in.nextInt();
    
    // acabo
    in.nextLine();   // vacío buffer de teclado
    System.out.println();
    return option;
  }

  public static void readDate() {
    System.out.print("Introduce una fecha en formato dd/mm/aaaa: ");
    String newDate = in.nextLine();
    if (Date.isOk(newDate)) {
      date = newDate;
    } else {
      System.out.println("\nHa introducido una fecha incorrecta.");
    }
  }

  public static void addDaysToDate() {
    int days = readPositiveInt("Introduce un número de días a sumar a " + date + ": ");
    date = Date.addDays(date, days);
  }
  
  public static void subtractDaysFromDate() {
    int days = readPositiveInt("Introduce un número de días a restar a " + date + ": ");
    date = Date.subtractDays(date, days);
  }
  
  public static int readPositiveInt(String prompt) {
    System.out.print(prompt);
    int n = in.nextInt();
    while (n < 0) {
      System.out.print("Error, no ha introducido un valor positivo, vuelva a intentarlo: ");
      n = in.nextInt();
    }
    return n;
  }
  
  public static void compareDates() {
    System.out.print("Introduce una fecha para comparar con " + date + ": ");
    String dateToCompare = in.nextLine();
    if (!Date.isOk(dateToCompare)) {
      System.out.println("\nHa introducido un valor de tiempo incorrecto.");
      return;
    }
    System.out.println(dateToCompare + " es " + resultCompareDates(dateToCompare) + " a " + date);
  }

  public static String resultCompareDates(String dateToCompare) {
    int compareResult = Date.compareTo(dateToCompare, date);
    String result;
    if (compareResult < 0) {
      result = "ANTERIOR";
    } else if (compareResult > 0) {
      result = "POSTERIOR";
    } else {
      result = "IGUAL";
    }
    return result;
  }
  
  public static void printDayOfWeek() {
    final String[] daysOfWeek = {"lunes", "martes", "miércoles", "jueves", "viernes",
        "sábado", "domingo"};
    System.out.println("El día de la semana de " + date + " es " + daysOfWeek[Date.dayOfWeek(date)]);
  }
  
}
