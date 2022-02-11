package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej05fraction;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FractionTest {
  
  Fraction f1 = new Fraction(1,2);
  Fraction f2 = new Fraction(2,3);

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @Test
  void testFraction() {
    Fraction f3 = new Fraction(2, 5);
    assertEquals("2/5", f3.toString());
    Fraction f4 = new Fraction(4, 10);  // fracción que debe simplicarse
    assertEquals("2/5", f4.toString());
    // ¿lanza excepción con división por cero?
    assertThrows(ArithmeticException.class, () -> new Fraction(1, 0));
  }
  
  @Test
  void testGetNumerator() {
    assertEquals(1, f1.getNumerator());
    assertEquals(2, f2.getNumerator());
  }

  @Test
  void testGetDenominator() {
    assertEquals(2, f1.getDenominator());
    assertEquals(3, f2.getDenominator());
  }

  @Test
  void testToString() {
    assertEquals("1/2", f1.toString());
    assertEquals("2/3", f2.toString());
  }

  @Test
  void testCompareTo() {
    assertTrue(f1.compareTo(f2) < 0);
    assertTrue(f2.compareTo(f1) > 0);
  }

  @Test
  void testClone() {
    Fraction f3 = f1.clone();
    assertFalse(f1==f3);
    assertTrue(f1.equals(f3));
  }

  @Test
  void testEqualsObject() {
    assertFalse(f1.equals(f2));
    assertTrue(f1.equals(new Fraction(1,2)));
  }

  @Test
  void testResult() {
    assertEquals(0.5, f1.result());
  }

  @Test
  void testMultiplyInt() {
    Fraction f3 = f1.multiply(2);
    Fraction f4 = new Fraction(1, 1);
    assertTrue(f3.equals(f4));
  }

  @Test
  void testMultiplyFraction() {
    Fraction f3 = f1.multiply(f2);
    assertEquals(new Fraction(1, 3), f3);
  }

  @Test
  void testDivide() {
    Fraction f3 = f1.divide(f2);
    assertEquals(new Fraction(3, 4), f3);
  }

  @Test
  void testAdd() {
    Fraction f3 = f1.add(f2);
    assertEquals(new Fraction(7, 6), f3);
  }

  @Test
  void testSubtract() {
    Fraction f3 = f1.subtract(f2);
    assertEquals(new Fraction(-1, 6), f3);
  }

}
