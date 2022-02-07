package org.iesgrancapitan.PROGR.ejemplos.poo.date;

/**
 * Esta clase modela una fecha que puede modificarse.
 * 
 * Lanzará la excepción IllegalArgumentException cuando los parámetros sean erróneos.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Date implements Comparable<Date> {
  
  private static final int DAYS_WEEK = 7;
  
  // atributos
  private int day;
  private int month;
  private int year;
  
  // constructores
  public Date(int day, int month, int year) {
    setMonth(month);
    setYear(year);
    setDay(day);    // importante que el día se asigne al final
  }
  
  public Date() {
    day = 1;
    month = 1;
    year = 1;
  }
  
  // getters
  public int getDay() {
    return day;
  }
  
  public int getMonth() {
    return month;
  }
  
  public int getYear() {
    return year;
  }

  // setters y métodos auxiliares
  public void setDay(int day) {
    if (day < 1 || day > daysOfMonth()) { 
      throw new IllegalArgumentException("El día " + day + " es incorrecto");
    }
    this.day = day;
  }
  
  private int daysOfMonth() {
    int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
    if (isLead()) { 
      days[1] = 29;
    }
    return days[month-1];
  }

  private boolean isLead() {
    return year%400==0 || (year%4==0 && year%100!=0);
  }
  
  public void setMonth(int month) {
    if (month < 1 || month > 12) {
      throw new IllegalArgumentException("El mes " + month + " es incorrecto");
    } 
    this.month = month;
  }

  public void setYear(int year) {
    if (year <= 0) {
      throw new IllegalArgumentException("El año " + year + " es incorrecto");
    } 
    this.year = year;
  }

  // resto de comportamiento
  @Override
  public String toString() {
    return String.format("%02d/%02d/%04d", day, month, year);
  }
 
  public void addDays(int days) {
    if (days < 0) {
      throw new IllegalArgumentException("El número de días a sumar no puede ser negativo");
    } 
    for (int i = 0; i < days; i++) {
      add1Day();
    }
  }

  private void add1Day() {
    day++;
    if (day > daysOfMonth()) {
      day = 1;
      month++;
      if (month > 12) {
        month = 1;
        year++;
      }
    }
  }
  
  public void subtractDays(int days) {
    if (days < 0) {
      throw new IllegalArgumentException("El número de días a restar no puede ser negativo");
    } 
    for (int i = 0; i < days; i++) {
      subtract1Day();
    }
  }
  
  private void subtract1Day() {
    if (day==1 && month==1 && year==1) { // de esta fecha no podemos bajar
      throw new IllegalArgumentException("La fecha no puede ser anterior al 01/01/0001");
    }
    day--;
    if (day == 0) {
      month--;
      if (month == 0) {
        month = 12;
        year--;
      }
      day = daysOfMonth();
    }
  }
  
  public int dayOfWeek() {
    Date firstDate = new Date(1,1,1); // ese día fue lunes (0)
    int totalDays = 0;
    while (! this.equals(firstDate)) {
      firstDate.add1Day();
      totalDays++;
    }
    return totalDays % DAYS_WEEK;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + day;
    result = prime * result + month;
    result = prime * result + year;
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
    Date other = (Date) obj;
    if (day != other.day)
      return false;
    if (month != other.month)
      return false;
    if (year != other.year)
      return false;
    return true;
  }

  @Override
  public int compareTo(Date date) {
    // convertimos las fechas a datos númericos aaaammdd y devolvemos su resta
    // este método devuelve <0 si la fecha almacenada es anterior a la enviada
    // 0 si son iguales y >0 en caso contrario.
    int date1 = this.year*10000 + this.month*100 + this.day;
    int date2 = date.year*10000 + date.month*100 + date.day;
    return date1-date2;
  }
  
 
}
