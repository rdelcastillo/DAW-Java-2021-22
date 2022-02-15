package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej06IntArrayList;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IntArrayListTest {
  
  IntArrayList listEmpty = new IntArrayList();
  IntArrayList list1To5 = new IntArrayList(1,2,3,4,5);
  IntArrayList list1To10 = new IntArrayList(1,2,3,4,5,6,7,8,9,10);

  @BeforeAll
  static void setUpBeforeClass() throws Exception {}

  @Test
  void testIntArrayList() {
    assertEquals("[]", listEmpty.toString());
  }

  @Test
  void testIntArrayListIntArray() {
    assertEquals("[1, 2, 3, 4, 5]", list1To5.toString());
    int[] params = {1,2,3,4,5,6,7,8,9,10};
    var list = new IntArrayList(params);
    assertEquals(list1To10.toString(), list.toString());
  }

  @Test
  void testAddInt() {
    listEmpty.add(1);
    assertEquals("[1]", listEmpty.toString());
    list1To5.add(6);
    assertEquals("[1, 2, 3, 4, 5, 6]", list1To5.toString());
    list1To10.add(11);
    assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]", list1To10.toString());
  }

  @Test
  void testAddIntInt() {
    list1To5.add(0, 0);
    assertEquals("[0, 1, 2, 3, 4, 5]", list1To5.toString());
    list1To5.add(5, 0);
    assertEquals("[0, 1, 2, 3, 4, 0, 5]", list1To5.toString());
    list1To10.add(4, 0);
    assertEquals("[1, 2, 3, 4, 0, 5, 6, 7, 8, 9, 10]", list1To10.toString());
    assertThrows(IndexOutOfBoundsException.class, () -> list1To10.add(100, 0));
  }

  @Test
  void testGet() {
    assertEquals(5, list1To10.get(4));
    assertThrows(IndexOutOfBoundsException.class, () -> listEmpty.get(5));
  }

  @Test
  void testSet() {
    int elementOld = list1To5.set(3, 100);
    assertEquals(4, elementOld);
    assertEquals(list1To5, new IntArrayList(1,2,3,100,5));
  }

  @Test
  void testRemove() {
    list1To5.remove(3);
    list1To5.equals(new IntArrayList(1,2,3,5));
    list1To5.remove(3);
    list1To5.equals(new IntArrayList(1,2,3));
    assertThrows(IndexOutOfBoundsException.class, () -> list1To5.remove(3));
  }

  @Test
  void testIndexOf() {
    assertEquals(2, list1To5.indexOf(3));
    assertEquals(-1, listEmpty.indexOf(3));
    assertEquals(-1, list1To10.indexOf(1000));
  }

  @Test
  void testContains() {
    assertTrue(list1To5.contains(5));
    assertFalse(list1To10.contains(1000));
  }

  @Test
  void testRemoveInt() {
    list1To5.removeInt(3);
    list1To5.equals(new IntArrayList(1,2,4,5));
    list1To5.removeInt(5);
    list1To5.equals(new IntArrayList(1,2,4));
  }

  @Test
  void testClear() {
    list1To10.clear();
    assertTrue(list1To10.isEmpty());
  }

  @Test
  void testIsEmpty() {
    assertTrue(listEmpty.isEmpty());
    assertFalse(list1To10.isEmpty());
  }

  @Test
  void testSize() {
    assertEquals(0, listEmpty.size());
    assertEquals(5, list1To5.size());
    assertEquals(10, list1To10.size());
    list1To10.add(11);
    list1To10.add(12);
    assertEquals(12, list1To10.size());
  }

  @Test
  void testSort() {
    var listUnsorted = new IntArrayList(1,3,2,5,4);
    var listSorted = new IntArrayList(1,2,3,4,5);
    listUnsorted.sort();
    listUnsorted.equals(listSorted);
  }

  @Test
  void testClone() {
    var list = list1To10.clone();
    assertTrue(list.equals(list1To10));
  }

  @Test
  void testEqualsObject() {
    var list = list1To10.clone();
    assertTrue(list.equals(list1To10));
    assertTrue(list.equals(list));
    list.add(100);
    assertFalse(list1To10.equals(list));
    list.removeInt(100);
    assertTrue(list.equals(list1To10));
  }

}
