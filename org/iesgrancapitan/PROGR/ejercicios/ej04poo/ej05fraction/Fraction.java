package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej05fraction;

/**
 * Clase "Fracción" inmutable que permite hacer las siguientes operaciones:
 * 
 * - Construir un objeto Fracción pasándole al constructor el numerador y el denominador. 
 *   La fracción se construye simplificada, no se puede dividir por cero.
 *   
 * - Obtener resultado de la fracción (número real).
 * - Multiplicar la fracción por un número (el método devuelve otra fracción, simplificada).
 * - Multiplicar, dividir, sumar y restar fracciones (los métodos devuelven otra fracción, simplificada).
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Fraction implements Comparable<Fraction>, Cloneable {
    
  private int numerator;
  private int denominator;
    
  public Fraction(int numerator, int denominator) { // No vamos a permitir como denominador cero
    if (denominator == 0) {
      throw new ArithmeticException("Una fracción no puede tener de denominador cero.");
    }
    this.numerator = numerator;
    this.denominator = denominator;
    simplify();
  }
  
  // getters y toString()
  
  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  @Override
  public String toString() {
    return numerator + "/" + denominator;
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
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + denominator;
    result = prime * result + numerator;
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
    Fraction other = (Fraction) obj;
    if (denominator != other.denominator)
      return false;
    if (numerator != other.numerator)
      return false;
    return true;
  }

  // resto de comportamiento
  
  public double result() {
    return (double) numerator / denominator;
  }
  
  public Fraction multiply(int n) {
    return new Fraction(numerator * n, denominator);
  }
  
  public Fraction multiply(Fraction other) {
    return new Fraction(numerator * other.numerator, this.denominator * other.denominator);
  }
  
  public Fraction add(Fraction other) {
    return new Fraction(numerator * other.denominator + other.numerator * denominator, 
        denominator * other.denominator);
  }
  
  public Fraction subtract(Fraction other) {
    return add(other.multiply(-1));
  }
  
  private void simplify() {
    int mcd = greatestCommonDivisor(numerator, denominator);
    numerator /= mcd;
    denominator /= mcd;
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
