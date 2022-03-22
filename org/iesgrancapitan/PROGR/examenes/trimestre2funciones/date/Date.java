package org.iesgrancapitan.PROGR.examenes.trimestre2funciones.date;

public class Date {

  private static final int DAYS_WEEK = 7;

  public static boolean isOk(String date) {
    // compruebo que la longitud sea 10
    if (date.length() != 10) {
      return false;
    }
    // compruebo que / está donde debe
    if (date.charAt(2)!='/' || date.charAt(5)!='/') {
      return false;
    }
    // compruebo que día, mes y año son numéricos
    String dayStr = date.substring(0, 2);
    String monthStr = date.substring(3, 5);
    String yearStr = date.substring(6);
    if (!isNumber(dayStr) || !isNumber(monthStr) || !isNumber(yearStr)) {
      return false;
    }
    // año correcto
    if (year(date) < 2000 || year(date) > 2099) {
      return false;
    }
    // mes correcto
    if (month(date) < 1 || month(date) > 12) {
      return false;
    }
    // día correcto
    if (day(date) < 1 || day(date) > daysOfMonth(month(date), year(date))) {
      return false;
    }
    return true;
  }

  private static boolean isNumber(String str) {
    for (char ch: str.toCharArray()) {
      if (!Character.isDigit(ch)) {
        return false;
      }
    }
    return true;
  }

  public static String addDays(String date, int days) {
    String newDate = date;
    for (int i = 0; i < Math.abs(days); i++) {
      newDate = (days > 0) ? add1Day(newDate) : subtract1Day(newDate);
    }
    return newDate;
  }
  
  private static String add1Day(String date) {
    int day = day(date) + 1;
    int month = month(date);
    int year = year(date);
    if (day > daysOfMonth(month, year)) {
      day = 1;
      month++;
      if (month > 12) {
        month = 1;
        year++;
      }
    }
    String newDate = formatedDate(day, month, year);
    // hay que comprobar si no me paso del 31/12/2099, en ese caso no cambiamos nada
    return isOk(newDate) ? newDate : date;
  }

  private static int day(String date) {
    return Integer.parseInt(date.substring(0, 2));
  }
  
  private static int month(String date) {
    return Integer.parseInt(date.substring(3, 5));
  }
  
  private static int year(String date) {
    return Integer.parseInt(date.substring(6));
  }
  
  private static int daysOfMonth(int month, int year) {
    int[] daysOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
    if (isLeap(year)) {
      daysOfMonth[1] = 29;
    }
    return daysOfMonth[month-1];
  }

  private static boolean isLeap(int year) {
    return year%400==0 || (year%4==0 && year%100!=0);
  }
  
  public static String formatedDate(int day, int month, int year) {
    return String.format("%02d/%02d/%04d", day, month, year);
  }
  
  public static String subtractDays(String date, int days) {
    return addDays(date, -days);
  }

  private static String subtract1Day(String date) {
    int day = day(date) - 1;
    int month = month(date);
    int year = year(date);
    if (day == 0) {
      month--;
      if (month == 0) {
        month = 12;
        year--;
      }
      day = daysOfMonth(month, year);
    }
    String newDate = formatedDate(day, month, year);
    return isOk(newDate) ? newDate : date;
  }

  public static int compareTo(String date1, String date2) {
    String date1Str = formatToCompare(date1);
    String date2Str = formatToCompare(date2);
    return date1Str.compareTo(date2Str);
  }

  private static String formatToCompare(String date) {
    return date.substring(6) + date.substring(3, 5) + date.substring(0, 2);
  }

  public static int dayOfWeek(String date) {
    String firstDate = "31/12/1999"; // ese día fue viernes (5), el 27/12 fue lunes
    int totalDays = 4;  // días del 27/12/1999 al 31/12/1999
    while (! date.equals(firstDate)) {
      firstDate = add1Day(firstDate);
      totalDays++;
    }
    return totalDays % DAYS_WEEK;
  }
}
