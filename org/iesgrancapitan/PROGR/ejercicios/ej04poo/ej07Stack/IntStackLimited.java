package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej07Stack;

/**
 * Esta clase modela una pila con un tamaño máximo de 10 elementos.
 * 
 * Es interesante reflexionar acerca si este modelado tal como está hecho es
 * compatible con los principios SOLID.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class IntStackLimited extends IntStack {

  private static int MAX_SIZE = 10;
  
  public IntStackLimited(int ... content) {
    super(content);
  }
  
  @Override
  public void add(int element) {
    throwExceptionIfIsFull();
    super.add(element);
  }
  
  @Override
  public void add(int index, int element) {
    throwExceptionIfIsFull();
    super.add(index, element);
  }
  
  private void throwExceptionIfIsFull() {
    if (isFull()) {
      throw new IndexOutOfBoundsException("La pila supera el máximo permitido");
    }
  }
  
  private boolean isFull() {
    return size() == MAX_SIZE;
  }
  
}
