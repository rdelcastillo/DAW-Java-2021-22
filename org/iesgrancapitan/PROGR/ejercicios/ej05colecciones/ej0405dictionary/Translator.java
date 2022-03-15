package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej0405dictionary;

/**
 * Ejemplo de mini-diccionario español-inglés que usa un objeto de la clase HashMap para 
 * almacenar las parejas de palabras. 
 * 
 * El programa pedirá palabras en español y dará la correspondiente traducción en inglés.
 *  
 * @author Rafael del Castillo
 * 
 */

import org.iesgrancapitan.PROGR.ejercicios.util.Util;

public class Translator {
  
  public static void main(String[] args) {
    System.out.println("Mini-diccionario español-inglés");
    System.out.println("-------------------------------");
    
    for (;;) {
      String wordInSpanish = Util.readStr("\nPalabra a traducir (Intro para terminar)");
      if (wordInSpanish.isBlank()) {
        break;
      }
      
      String wordInEnglish = SpanishEnglishDictionary.DICT.get(wordInSpanish);
      if (wordInEnglish != null) {
        System.out.println("Traducción: " + wordInEnglish);
      } else {
        System.out.println("La palabra " + wordInSpanish + " no está en el diccionario");
      }
    }
    
    System.out.println("\nBye! ;-)");
  }

}
