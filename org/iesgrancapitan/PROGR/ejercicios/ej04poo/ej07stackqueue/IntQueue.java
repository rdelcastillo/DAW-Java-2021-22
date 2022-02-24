package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej07stackqueue;

import org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej06intarraylist.IntArrayList;

public class IntQueue extends IntArrayList {
  
  public IntQueue(int ... content) {
    super(content);
  }
  
  public void enqueue(int element) {
    add(element);
  }
  
  public int dequeue() {
    return remove(0);
  }
  
  public int front() {
    return get(0);
  }
  
  @Override
  public String toString() {
    return "Queue" + super.toString();
  }

}
