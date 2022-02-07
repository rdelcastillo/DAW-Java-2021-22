package org.iesgrancapitan.PROGR.ejercicios.ej02repetitivas;

/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.concurrent.TimeUnit;

public class Ej08Cronometro {

  // ################################################################################
  // Hacer un programa que muestre un cronometro, indicando las horas, minutos y segundos.
  // ################################################################################
  // Análisis
  // Necesito realizar 3 bucles anidados: el más interno es que me permite recorrer
  // los segundos, el intermedio me permite recorrer los minutos y el más externo
  // recorre las horas.
  // Datos de entrada: Nada
  // Información de salida: La hora (hora, minutos y segundos)
  // Variables: hora,minuto,segundo (entero)
  // ################################################################################

  public static void main(String args[]) throws InterruptedException {
    int hora=0;
    int minuto=0;
    int segundo=0;
    String borraAnterior="\b\b\b\b\b\b\b\b";  // ver https://docs.oracle.com/javase/tutorial/java/data/characters.html

    while (true) {
      // escribe hora:minutos:segundos (actualizandose a medida que va pasando cada segundo)
      System.out.printf("%02d:%02d:%02d",hora,minuto,segundo);
      TimeUnit.SECONDS.sleep(1);
      // pasar al siguiente segundo
      if (segundo < 59) {
        segundo++;
      } else {
        segundo=0;
        if (minuto < 59) {
          minuto++;
        } else {
          minuto = 0;
          hora++;
        }
      }
      // ponemos el cursor al principio de la línea
      System.out.print(borraAnterior);
    }
  }


}

