package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej06IntArrayList.test;

import static org.junit.jupiter.api.Assertions.*;
import org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej06IntArrayList.IntArrayListSorted;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntArrayListSortedTest {
  
  IntArrayListSorted list1To5 = new IntArrayListSorted(1,2,3,4,5);

  @Test
  @DisplayName("Probamos añadir un elemento y ver si la lista acaba ordenada")
  void testAddInt() {
    list1To5.add(0);
    assertTrue(list1To5.equals(new IntArrayListSorted(0,1,2,3,4,5)));
  }

  @Test
  @DisplayName("Probamos añadir un elemento en una posición y ver si la lista acaba ordenada")
  void testAddIntInt() {
    list1To5.add(3,0);
    assertTrue(list1To5.equals(new IntArrayListSorted(0,1,2,3,4,5)));
  }

  @Test
  @DisplayName("Probamos sustituir un elemento y ver si la lista acaba ordenada")
  void testSet() {
    list1To5.set(1,0);
    assertTrue(list1To5.equals(new IntArrayListSorted(0,1,3,4,5)));
  }

  @Test
  @DisplayName("Probamos crear una lista desordenada y ver si acaba ordenada")
  void testIntArrayListSorted() {
    IntArrayListSorted list = new IntArrayListSorted(2,3,1,5,4);
    assertTrue(list.equals(list1To5));
  }

}
