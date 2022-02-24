package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej07stackqueue.test;

import static org.junit.jupiter.api.Assertions.*;
import org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej07stackqueue.IntQueue;
import org.junit.jupiter.api.Test;

class IntQueueTest {
  
  private IntQueue queue1To5 = new IntQueue(1,2,3,4,5); 

  @Test
  void testToString() {
    assertEquals("Queue[1, 2, 3, 4, 5]", queue1To5.toString());
  }

  @Test
  void testEnqueue() {
    queue1To5.enqueue(6);
    assertTrue(queue1To5.equals(new IntQueue(1,2,3,4,5,6)));
  }

  @Test
  void testDequeue() {
    int element = queue1To5.dequeue();
    assertEquals(1, element);
    assertTrue(queue1To5.equals(new IntQueue(2,3,4,5)));
    var queueEmpty = new IntQueue();
    assertThrows(IndexOutOfBoundsException.class, () -> queueEmpty.dequeue());
  }

  @Test
  void testFront() {
    int element = queue1To5.front();
    assertEquals(1, element);
    assertTrue(queue1To5.equals(new IntQueue(1,2,3,4,5)));
  }

}
