package org.iesgrancapitan.PROGR.ejemplos.poo.time;

/**
 * Clase para manejar valores horarios entre 00:00:00 y 23:59:59.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Time implements Comparable<Time>, Cloneable {

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

  public Time addSeconds(int seconds) {
    return timeFromSeconds(secondsTotal() + seconds);
  }

  public Time addMinutes(int minutes) {
    return timeFromSeconds(secondsTotal() + minutes*60);
  }
  
  public Time addHours(int hours) {
    return timeFromSeconds(secondsTotal() + hours*3600);
  }
  
  private int secondsTotal() {
    return hours*3600 + minutes*60 + seconds;
  }

  private Time timeFromSeconds(int seconds) {
    return new Time(seconds/3600, seconds%3600/60, seconds%3600%60);
  }

  @Override
  public String toString() {
    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
  }

  @Override
  public int compareTo(Time other) {
    return secondsTotal() - other.secondsTotal();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + hours;
    result = prime * result + minutes;
    result = prime * result + seconds;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Time other = (Time) obj;
    if (hours != other.hours)
      return false;
    if (minutes != other.minutes)
      return false;
    if (seconds != other.seconds)
      return false;
    return true;
  }
  
  @Override
  public Time clone() {
    return new Time(hours, minutes, seconds);
  }
}
