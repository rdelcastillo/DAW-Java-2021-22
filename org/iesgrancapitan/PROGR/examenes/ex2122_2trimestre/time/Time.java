package org.iesgrancapitan.PROGR.examenes.ex2122_2trimestre.time;

/**
 * Funciones para manejo de valores de tiempo usada por ExamenA.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Time {
  
  public static boolean isOk(String time) {
    if (time.length() != 8) {   // longitud ok
      return false;
    }
    if (time.charAt(2) != ':' || time.charAt(5) != ':') {   // ':' ok
      return false;
    }
    // horas, minutos y segundos enteros
    String hoursStr = time.substring(0, 2); 
    String minutesStr = time.substring(3, 5);
    String secondsStr = time.substring(6);
    if (!isNumber(hoursStr) || !isNumber(minutesStr) || !isNumber(secondsStr)) {
      return false;
    }
    // minutos y segundos <= 59
    int minutes = Integer.parseInt(minutesStr);
    int seconds = Integer.parseInt(secondsStr);
    if (minutes > 59 || seconds > 59) {
      return false;
    }
    // si llegamos aquí, todo ok
    return true;
  }
  
  private static boolean isNumber(String str) {
    for (char ch: str.toCharArray()) {
      if (! Character.isDigit(ch)) {
        return false;
      }
    }
    return true;
  }

  public static String addSeconds(String time, int secondsToAdd) {
    // calculo segundos totales del nuevo valor de tiempo
    int hours = Integer.parseInt(time.substring(0, 2));
    int minutes = Integer.parseInt(time.substring(3, 5));
    int seconds =  Integer.parseInt(time.substring(6));
    int secondsTotal = hours*3600 + minutes*60 + seconds + secondsToAdd;
    
    // he podido meter demasiados segundos y obtener un valor de tiempo que sea
    // negativo o demasiado grande, en ese caso devolveremos el valor actual
    // y daremos un error en el dispositivo estándar de error, aunque lo suyo
    // sería generar una excepción (ya lo veremos).
    if (secondsTotal < 0 || secondsTotal > 360000) {
      System.err.println("Error, el valor de tiempo obtenido no es válido (" 
          + secondsTotal + " segundos). No hay cambios.");
      return time;
    }
    
    // calculo nuevos valores de horas, minutos y segundos y lo devuelvo formateado
    int newHours = secondsTotal / 3600;
    int newMinutes = secondsTotal % 3600 / 60; 
    int newSeconds = secondsTotal % 3600 % 60;
    return String.format("%02d:%02d:%02d", newHours, newMinutes, newSeconds);
  }
  
  public static String subtractSeconds(String time, int seconds) {
    return addSeconds(time, -seconds);
  }
  
  public static String addMinutes(String time, int minutes) {
    return Time.addSeconds(time, 60*minutes);
  }
  
  public static String subtractMinutes(String time, int minutes) {
    return addSeconds(time, -60*minutes);
  }
  
  public static String addHours(String time, int hours) {
    return addSeconds(time, 3600*hours);
  }
  
  public static String subtractHours(String time, int hours) {
    return addSeconds(time, -3600*hours);
  }

  public static int compareTo(String time1, String time2) {
    return time1.compareTo(time2);
  }

}
