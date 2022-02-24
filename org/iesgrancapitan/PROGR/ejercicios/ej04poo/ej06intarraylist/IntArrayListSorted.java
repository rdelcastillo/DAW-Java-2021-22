package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej06intarraylist;

/**
 * Esta clase modela una lista de enteros ordenada.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class IntArrayListSorted extends IntArrayList {
  
  public IntArrayListSorted(int ... content) {
    super(content);
  }
  
  @Override
  public void add(int element) {
    super.add(element);
    sort();
  }
  
  @Override
  public void add(int index, int element) {
    add(element);
  }
  
  @Override
  public int set(int index, int element) {
    int elementOld = super.set(index, element);
    sort();
    return elementOld;
  }

}
