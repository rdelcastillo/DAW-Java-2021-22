package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej07stackqueue.test;

import static org.junit.jupiter.api.Assertions.*;
import org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej07stackqueue.IntStack;
import org.junit.jupiter.api.Test;

class IntStackTest {
  
  private IntStack stack1To5 = new IntStack(1,2,3,4,5); 

  @Test
  void testToString() {
    assertEquals("Stack[1, 2, 3, 4, 5]", stack1To5.toString());
  }

  @Test
  void testPush() {
    stack1To5.push(6);
    assertTrue(stack1To5.equals(new IntStack(1,2,3,4,5,6)));
  }

  @Test
  void testPop() {
    int element = stack1To5.pop();
    assertEquals(5, element);
    assertTrue(stack1To5.equals(new IntStack(1,2,3,4)));
    var stackEmpty = new IntStack();
    assertThrows(IndexOutOfBoundsException.class, () -> stackEmpty.pop());
  }

  @Test
  void testTop() {
    int element = stack1To5.top();
    assertEquals(5, element);
    assertTrue(stack1To5.equals(new IntStack(1,2,3,4,5)));
  }

}
