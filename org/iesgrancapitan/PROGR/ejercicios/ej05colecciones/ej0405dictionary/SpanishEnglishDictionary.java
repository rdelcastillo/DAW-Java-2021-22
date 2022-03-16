package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej0405dictionary;

import java.util.Map;

/**
 * Mini-diccionario español/inglés.
 * 
 * Aunque el ejercicio pide un HashMap lo hemos hecho con un Map.of() que nos da
 * un diccionario inmutable, ya que no hay que añadir nuevas palabras, en ese caso
 * habría que hacerlo con un HashMap.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class SpanishEnglishDictionary {
  
  public static final Map<String, String> DICT = Map.ofEntries(
      Map.entry("uno","one"), Map.entry("dos","two"), Map.entry("tres","three"), 
      Map.entry("cuatro","four"), Map.entry("cinco","five"), Map.entry("seis","six"), 
      Map.entry("siete","seven"), Map.entry("ocho","eight"), Map.entry("nueve","nine"), 
      Map.entry("diez","ten"), Map.entry("once","eleven"), Map.entry("doce","twelve"), 
      Map.entry("trece","thirteen"), Map.entry("catorce","fourteen"), 
      Map.entry("quince","fifteen"), Map.entry("dieciseis","sixteen"), 
      Map.entry("diecisiete","seventeen"), Map.entry("dieciocho","eighteen"), 
      Map.entry("diecinueve","nineteen"), Map.entry("veinte","twenty"));
}
