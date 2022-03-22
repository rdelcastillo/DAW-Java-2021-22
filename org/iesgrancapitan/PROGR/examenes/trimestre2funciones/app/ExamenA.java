package org.iesgrancapitan.PROGR.examenes.trimestre2funciones.app;

/**
 * Enunciado del examen:
 * 
 * Muestra un menú, que debe ser gestionado con una función que devuelva la opción elegida, 
 * con las siguientes opciones:
 * 
 * - Introducir (por teclado) un valor de tiempo en formato hh:mm:ss que se almacenará como String.
 * 
 * Pide un instante de tiempo al usuario, si no se introduce correctamente se muestra un mensaje de error. 
 * Usa una función booleana para validar el valor de tiempo.
 * 
 * - Sumar segundos al valor de tiempo.
 * 
 * Pide un número de segundos (positivo) para sumar al valor de tiempo introducido previamente y actualiza 
 * su valor. Esta opción sólo podrá realizarse si hay un valor de tiempo introducido, si no lo hay mostrará 
 * un mensaje de error, si el número de segundos introducido no es positivo también. Usa una función que 
 * recibirá el valor de tiempo, el número de segundos a sumarle y devolverá el valor de tiempo.
 * 
 * - Restar segundos al valor de tiempo.
 * 
 * Igual que el apartado anterior pero restando al valor de tiempo.
 * 
 * - Sumar minutos al valor de tiempo.
 * 
 * Pide un número de minutos (positivo) para sumar al valor de tiempo introducido previamente y actualiza su 
 * valor. Esta opción sólo podrá realizarse si hay un valor de tiempo introducido, si no lo hay mostrará un 
 * mensaje de error, si el número de minutos introducido no es positivo también. Usa una función que recibirá
 * el valor de tiempo, el número de minutos a sumarle y devolverá el valor de tiempo.
 * 
 * - Restar minutos al valor de tiempo.
 * 
 * Igual que el apartado anterior pero restando al valor de tiempo.
 * 
 * - Sumar horas al valor de tiempo.
 * 
 * Pide un número de horas (positivo) para sumar al valor de tiempo introducido previamente y actualiza su 
 * valor. Esta opción sólo podrá realizarse si hay un valor de tiempo introducido, si no lo hay mostrará un 
 * mensaje de error, si el número de minutos introducido no es positivo también. Usa una función que recibirá 
 * el valor de tiempo, el número de horas a sumarle y devolverá el valor de tiempo.
 * 
 * - Restar horas al valor de tiempo.
 * 
 * Igual que el apartado anterior pero restando al valor de tiempo.
 * 
 * - Comparar el valor de tiempo introducido con otro.
 * 
 * Pide un valor de tiempo al usuario (válido, si no lo es da error) y lo comparará con el que tenemos 
 * almacenado, posteriormente mostrará si ese valor es anterior, igual o posterior al que tenemos almacenado, 
 * usará una función para ello a la que le pasaremos los dos valores de tiempo y devolverá un valor negativo 
 * si el 1ª es ANTERIOR al 2ª, 0 si son IGUALES y un valor positivo si es POSTERIOR.
 * 
 * - Mostrar el valor de tiempo.
 * 
 * - Terminar.
 * 
 * @author Rafael del Castillo Gomariz
 */

import java.util.Scanner;
import org.iesgrancapitan.PROGR.examenes.trimestre2funciones.time.Time;

public class ExamenA {

  public static Scanner in = new Scanner(System.in);
  public static String time = "";
  
  public static void main(String[] args) {
    boolean menuIsActive = true;
    
    while (menuIsActive) {
      int option = menu();
      
      // Controlamos que no se pueda ejecutar ninguna opción que no sea 1 o 10 si no hay valor de tiempo
      if (option > 1 && option < 10 && time.isEmpty()) {
        System.out.println("Primero debe introducir un valor de tiempo.\n");
        continue;
      }
      
      // Proceso normal
      switch (option) {
        case 1 -> readTime();
        case 2 -> addSecondsToTime();
        case 3 -> subtractSecondsFromTime();
        case 4 -> addMinutesToTime();
        case 5 -> subtractMinutesFromTime();
        case 6 -> addHoursToTime();
        case 7 -> subtractHoursFromTime();
        case 8 -> compareTimes();
        case 9 -> System.out.println("El valor de tiempo es: " + time);
        case 10 -> menuIsActive = false;
        default -> System.out.println("Opción incorrecta.");
      }
    }
    
    in.close();
    System.out.println("¡Adiós!");
  }
  
  public static int menu() {
    System.out.println("\nMenú de opciones");
    System.out.println("----------------");
    System.out.println(" 1. Introducir un valor de tiempo.\n"
        + " 2. Sumar segundos al valor de tiempo.\n"
        + " 3. Restar segundos al valor de tiempo.\n"
        + " 4. Sumar minutos al valor de tiempo.\n"
        + " 5. Restar minutos al valor de tiempo.\n"
        + " 6. Sumar horas al valor de tiempo.\n"
        + " 7. Restar horas al valor de tiempo.\n"
        + " 8. Comparar el valor de tiempo introducido con otro.\n"
        + " 9. Mostrar el valor de tiempo.\n"
        + "10. Finalizar.");
   
    // leo la opción
    System.out.print("\nIntroduce una opción: ");
    int option = in.nextInt();
    
    // acabo
    in.nextLine();   // vacío buffer de teclado
    System.out.println();
    return option;
  }

  public static void readTime() {
    System.out.print("Introduce un valor de tiempo: ");
    String newTime = in.nextLine();
    if (Time.isOk(newTime)) {
      time = newTime;
    } else {
      System.out.println("\nHa introducido un valor de tiempo incorrecto.");
    }
  }

  public static void addSecondsToTime() {
    int seconds = readPositiveInt("Introduce un número de segundos a sumar a " + time + ": ");
    time = Time.addSeconds(time, seconds);
  }
  
  public static void subtractSecondsFromTime() {
    int seconds = readPositiveInt("Introduce un número de segundos a restar a " + time + ": ");
    time = Time.subtractSeconds(time, seconds);
  }

  public static void addMinutesToTime() {
    int minutes = readPositiveInt("Introduce un número de minutos a sumar a " + time + ": ");
    time = Time.addMinutes(time, minutes);
  }

  public static void subtractMinutesFromTime() {
    int minutes = readPositiveInt("Introduce un número de minutos a restar a " + time + ": ");
    time = Time.subtractMinutes(time, minutes);
  }
  
  public static void addHoursToTime() {
    int hours = readPositiveInt("Introduce un número de horas a sumar a " + time + ": ");
    time = Time.addHours(time, hours);
  }
  
  public static void subtractHoursFromTime() {
    int hours = readPositiveInt("Introduce un número de horas a restar a " + time + ": ");
    time = Time.subtractHours(time, hours);
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
  
  public static void compareTimes() {
    // pedimos valor de tiempo a comparar y salimos si es incorrecto
    System.out.print("Introduce un valor de tiempo para comparar con " + time + ": ");
    String timeToCompare = in.nextLine();
    if (!Time.isOk(timeToCompare)) {
      System.out.println("\nHa introducido un valor de tiempo incorrecto.");
      return;
    }
    // comparamos y mostramos resultado
    String result;
    int compareResult = Time.compareTo(timeToCompare, time);
    if (compareResult < 0) {
      result = "ANTERIOR";
    } else if (compareResult > 0) {
      result = "POSTERIOR";
    } else {
      result = "IGUAL";
    }
    System.out.println(timeToCompare + " es " + result + " a " + time);
  }
  
}
