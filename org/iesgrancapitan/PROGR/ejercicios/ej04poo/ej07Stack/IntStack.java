package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej07Stack;

import org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej06IntArrayList.IntArrayList;

public class IntStack extends IntArrayList {
  
  public IntStack(int ... content) {
    super(content);
  }
  
  public void push(int element) {
    add(element);
  }
  
  public int pop() {
    return remove(size()-1);
  }
  
  public int top() {
    return get(size()-1);
  }
  
  @Override
  public String toString() {
    return "Stack" + super.toString();
  }

}
