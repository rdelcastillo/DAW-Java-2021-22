package org.iesgrancapitan.PROGR.ejemplos.poo.record;

/**
 * Clase "Fracción" como Record.
 * 
 * Ejercicio ya resuelto como clase estándar.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public record Fraction(int numerator, int denominator) implements Comparable<Fraction>, Cloneable {
        
  public Fraction { 
    if (denominator == 0) {
      throw new ArithmeticException("Una fracción no puede tener de denominador cero.");
    }
    int mcd = greatestCommonDivisor(numerator, denominator);
    numerator /= mcd;
    denominator /= mcd;
  }
    
  // métodos de Comparable y Cloneable, equals() y hashcode()
  
  @Override
  public int compareTo(Fraction other) {
    return numerator*other.denominator - other.numerator*denominator;
  }
  
  @Override
  public Fraction clone() {
    return new Fraction(numerator, denominator);
  }
  
  public double result() {
    return (double) numerator / denominator;
  }
  
  public Fraction multiply(int n) {
    return new Fraction(numerator * n, denominator);
  }
  
  public Fraction multiply(Fraction other) {
    return new Fraction(numerator * other.numerator, denominator * other.denominator);
  }
  
  public Fraction divide(Fraction other) {
    return new Fraction(numerator * other.denominator, denominator * other.numerator);
  }
  
  public Fraction add(Fraction other) {
    return new Fraction(numerator * other.denominator + other.numerator * denominator, 
        denominator * other.denominator);
  }
  
  public Fraction subtract(Fraction other) {
    return add(other.multiply(-1));
  }
    
  // cálculo de máximo común divisor usando Euclides: https://es.wikipedia.org/wiki/Algoritmo_de_Euclides
  private static int greatestCommonDivisor(int n1, int n2) {   
    int a = Math.abs(n1);
    int b = Math.abs(n2);
    while (b > 0) {
      int r = a % b;
      a = b;
      b = r;
    }
    return a;
  }

}
