package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej0405dictionary;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.iesgrancapitan.PROGR.ejercicios.util.Util;

/**
 * Programa que escoge al azar 5 palabras en español del minidiccionario español-inglés e irá 
 * pidiendo que el usuario teclee la traducción al inglés de cada una de las palabras comprobando
 * si son correctas. Al final, el programa deberá mostrar cuántas respuestas son válidas y cuántas
 * erróneas.
 * 
 * Ejercicio del libro "Aprende Java con Ejercicios", edición 2019.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class EnglishTest {
  
  private static final int NUM_QUESTIONS = 5;

  public static void main(String[] args) {    
    System.out.println("Test de inglés");
    System.out.println("--------------");
    
    // Escojemos las palabras a preguntar en español
    List<String> wordsInSpanish = new ArrayList<>(SpanishEnglishDictionary.DICT.keySet());
    Set<String> testWords = new HashSet<>();
    while (testWords.size() < NUM_QUESTIONS) {
      int randomQuestion = Util.randomInt(0, wordsInSpanish.size()-1);
      String word = wordsInSpanish.get(randomQuestion);
      testWords.add(word);
    }
    
    // Hacemos el test
    int numAnswerOk = 0;
    for (String word: testWords) {
      String answer = Util.readStr("Traducción de " + word);
      if (answer.equals(SpanishEnglishDictionary.DICT.get(word))) {
        numAnswerOk++;
      }
    }
    
    // Resultados
    System.out.println("Ha acertado " + numAnswerOk + " palabras.");
    System.out.println("Ha fallado " + (NUM_QUESTIONS-numAnswerOk) + " palabras.");
  }

}
