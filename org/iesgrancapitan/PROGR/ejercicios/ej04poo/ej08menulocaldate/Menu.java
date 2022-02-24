package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej08menulocaldate;

/**
 * Clase para gestionar menús.
 * 
 * @author Rafael del Castillo.
 * 
 */

import java.util.Arrays;
import java.util.Scanner;

public class Menu {

  private String title;
  private String[] options;
  private Scanner in = new Scanner(System.in);
  
  public Menu(String title, String ... options) {
    this.title = title;
    this.options = options;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public void add(String option) {
    String[] options = Arrays.copyOf(this.options, this.options.length+1);
    options[options.length-1] = option;
    this.options = options;
  }
  
  public void remove(int option) {  // las opciones empiezan en 1
    if (option < 1 || option > this.options.length) {
      throw new IndexOutOfBoundsException("Opción de menú a borrar fuera de rango.");
    }
    String[] options = Arrays.copyOf(this.options, this.options.length-1);
    for (int i = option; i < this.options.length; i++) {
      options[i-1] = this.options[i];
    }
    this.options = options;
  }
  
  public int choose() {
    while (true) {
      printTitle();
      printOptions();
      int option = readOption();
      if (option >= 1 && option <= this.options.length) {
        return option;
      }
      printError();
    }
  }

  private void printTitle() {
    if (title != null && !title.isEmpty()) {
      System.out.println(title);
      System.out.println("-".repeat(title.length()));
    }
  }

  private void printOptions() {
    int option = 0;
    for (String menuOption: this.options) {
      System.out.println(++option + ". " + menuOption);
    }
    System.out.println();
  }

  private int readOption() {
    System.out.print("Introduzca una opción (1-" + options.length + "): ");
    int option = in.nextInt();
    in.nextLine();  // sacamos el salto de línea del buffer de teclado
    System.out.println();
    return option;
  }
  
  private void printError() {
    System.out.println("Opción incorrecta. Pulse Intro para continuar...");
    in.nextLine();
    System.out.println();
  }

  @Override
  public String toString() {
    return "Menu [title=" + title + ", options=" + Arrays.toString(options) + "]";
  }

}
