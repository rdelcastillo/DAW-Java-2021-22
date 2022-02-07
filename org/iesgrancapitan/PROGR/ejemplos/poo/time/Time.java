package org.iesgrancapitan.PROGR.ejemplos.poo.time;

/**
 * Clase para manejar valores horarios entre 00:00:00 y 23:59:59.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Time {
  
  private int hours;
  private int minutes;
  private int seconds;
  
  public Time() {}
  
  public Time(int hours, int minutes, int seconds) {
    setHours(hours);
    setMinutes(minutes);
    setSeconds(seconds);
  }

  public int getHours() {
    return hours;
  }

  public int getMinutes() {
    return minutes;
  }

  public int getSeconds() {
    return seconds;
  }

  public void setHours(int hours) {
    if (hours < 0 || hours >= 24) { // aquí lanzamos una excepción por parámetro incorrecto
      throw new IllegalArgumentException("Error al asignar " + hours + " horas al objeto");
    }
    this.hours = hours;
  }

  public void setMinutes(int minutes) {
    if (minutes < 0 || minutes >= 60) { // aquí lanzamos una excepción por parámetro incorrecto
      throw new IllegalArgumentException("Error al asignar " + minutes + " minutos al objeto");
    }
    this.minutes = minutes;
  }

  public void setSeconds(int seconds) {
    if (seconds < 0 || seconds >= 60) {  // aquí lanzamos una excepción por parámetro incorrecto
      throw new IllegalArgumentException("Error al asignar " + seconds + " segundos al objeto");
    }
    this.seconds = seconds;
  }

  @Override
  public String toString() {
    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
  }
  
  public Time addSeconds(int seconds) {
    int secondsTotal = this.hours*3600 + this.minutes*60 + this.seconds + seconds;
    return new Time(secondsTotal/3600, secondsTotal%3600/60, secondsTotal%3600%60);
  }
  
}
