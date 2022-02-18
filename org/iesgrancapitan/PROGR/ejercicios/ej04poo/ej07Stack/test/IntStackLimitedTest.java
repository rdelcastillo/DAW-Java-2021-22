package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej07Stack.test;

import static org.junit.jupiter.api.Assertions.*;
import org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej07Stack.IntStackLimited;
import org.junit.jupiter.api.Test;

class IntStackLimitedTest {
  
  IntStackLimited stack1To5 = new IntStackLimited(1,2,3,4,5);
  IntStackLimited stack1To10 = new IntStackLimited(1,2,3,4,5,6,7,8,9,10);

  @Test
  void testIntStackLimited() {
    assertThrows(IndexOutOfBoundsException.class, 
        () -> new IntStackLimited(1,2,3,4,5,6,7,8,9,10,11));
  }
  
  @Test
  void testAddInt() {
    assertThrows(IndexOutOfBoundsException.class, 
        () -> stack1To10.add(11));
  }

  @Test
  void testAddIntInt() {
    stack1To5.add(0, 0);
    assertTrue(stack1To5.equals(new IntStackLimited(0,1,2,3,4,5)));
    assertThrows(IndexOutOfBoundsException.class, () -> stack1To10.add(0, 0));
  }

  @Test
  void testPush() {
    stack1To5.push(6);
    assertTrue(stack1To5.equals(new IntStackLimited(1,2,3,4,5,6)));
    assertThrows(IndexOutOfBoundsException.class, () -> stack1To10.push(11));
  }

}
