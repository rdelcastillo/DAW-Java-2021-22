package org.iesgrancapitan.PROGR.ejercicios.ej01alternativas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej19DiasDelMes {

  // ################################################################################
  // Escribe un programa que pida un número entero entre uno y doce e imprima el
  // número de días que tiene el mes correspondiente.
  // Si introducimos otro número nos da un error.
  // ################################################################################
  // Análisis
  // Leer un mes como entero e indica los días que tiene el mes.
  // El mes de febrero ponemos que tiene 28 o 29 días.
  // Si el número introducido es incorrecto mostrar mensaje de error.
  // Datos de entrada: mes (entero)
  // Información de salida: cantidad de días del mes indicado o mensaje de error
  // Variables: mes (entero)
  // ################################################################################
  // Diseño
  // 1. Leer mes como entero
  // 2. Según el valor del mes:
  // 3. Si es el 1,3,5,7,8,10,12: tiene 31 días
  // 4. Si es el 2: tiene 28 o 29 días
  // 5. Si es el 2,4,9,11: tiene 30 días
  // 6. Si es otro número, mostrar mensaje de error
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    int mes;

    // Pedimos datos
    System.out.print("Introduce el número de mes (1-12): ");
    mes = s.nextInt();

    // Proceso
    switch (mes) {
      case 1: case 3: case 5: case 7: case 8: case 10: case 12:
        System.out.println("31 días");
        break;
      case 2:
        System.out.println("28 o 29 días");
        break;
      case 4: case 6: case 9: case 11:
        System.out.println("30 días");
        break;
      default:
        System.out.println("Mes incorrecto");
    }
  }


}

