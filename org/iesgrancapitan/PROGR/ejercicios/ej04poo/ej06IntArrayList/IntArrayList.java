package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej06IntArrayList;

import java.util.Arrays;

/**
 * Esta clase representará una estructura de datos tipo lista de números enteros.
 * 
 * Estado de los objetos:
 * 
 * - content: array de enteros donde guardaremos los elementos de la lista.
 * - contentSize: número de elementos guardados en la lista.
 * 
 * Comportamiento:
 * 
 * - IntArrayList(): crea una lista vacía cuyo tamaño máximo va a estar determinado por una constante 
 *  de la clase (10).
 *  
 * - IntArrayList(ele1, ..., eleN): crea una lista con los elementos ele1 ... eleN.
 *  
 * - add(elemento): añade "elemento" al final de la lista. 
 *  Devolveremos true o false en función del éxito de la operación.
 *
 * - add(índice, elemento): añade "elemento" en la posición "índice" de la lista.
 *  Devolveremos true o false en función del éxito de la operación.
 * 
 * - remove(índice): borra el elemento de la lista que está en la posición "índice" y devuelve el elemento borrado.
 * 
 * - removeInt(elemento): borra la 1ª ocurrencia de "elemento" de la lista y devuelve si ha habido éxito o no en la operación.
 * 
 * - size(): devuelve el número de elementos que hay en la lista.
 * 
 * - clear(): vacía la lista.
 *  
 * - isEmpty(): dice si la lista está vacía.
 * 
 * - contains(elemento): dice si "elemento" está en la lista.
 * 
 * - get(índice): devuelve el elemento que está en la posición "índice".
 * 
 * - set(índice, elemento): reemplaza el elemento que está en la posición "índice" por "elemento". Devuelve el elemento sustituido.
 * 
 * - indexOf(elemento): devuelve la posición donde está "elemento" y -1 si no existe.
 * 
 * - sort(): ordena la lista.
 * 
 * - equals(lista): comprueba si el contenido de nuestra lista es igual a la que hemos pasado como parámetro.
 * 
 * - clone(): devuelve una nueva lista con una copia exacta de su contenido.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class IntArrayList implements Cloneable {

  private static final int DEFAULT_SIZE = 10;

  private int[] content = new int[DEFAULT_SIZE]; // array donde almacenamos los elementos de la lista
  private int contentSize = 0;  // tamaño de la lista (nº de elementos almacenados)

  /**
   * Crea una lista vacía.
   */
  public IntArrayList() {}  // permitimos constructor vacío pero no hay que hacer nada

  /**
   * Crea una lista con los valores que llegan como parámetro.
   * @param content lista de enteros que conforman la lista.
   */
  public IntArrayList(int ... content) {
    for (int element : content) {  // metemos los valores llegados como parámetros en el array
      add(element);
    }
  }

  /**
   * Añade un elemento al final de la lista. 
   * @param element elemento a añadir
   */
  public void add(int element) {
    expandListIfIsFull();
    content[contentSize++] = element;
  }
  
  /**
   * Añade un elemento en la posición indicada de la lista.
   * @param element elemento a añadir
   * @param index índice donde hay que añadir element
   */
  public void add(int index, int element) {  
    throwExceptionIfIndexOutOfBounds(index);
    scrollListToRightFrom(index);
    content[index] = element;
  }
  
  /**
   * Desplaza la lista una posición a la derecha a partir de la posición indicada
   * y aumenta su tamaño en uno.
   * @param index posición a partir de la cual hay que desplazar la lista.
   */
  private void scrollListToRightFrom(int index) {
    expandListIfIsFull();
    for (int i = contentSize-1; i >= index; i--) {
      content[i+1] = content[i];
    }
    contentSize++;
  }
  
  /**
   * Amplía el tamaño del vector que almacena la lista si está llena. 
   */
  private void expandListIfIsFull() {
    if (isFull()) {
      expand();
    }
  }

  /**
   * Amplía el tamaño del vector que almacena la lista porque está llena. 
   */
  private void expand() {
    content = Arrays.copyOf(content, content.length + DEFAULT_SIZE);
  }
  
  /**
   * Devuelve el elemento de la lista que está en la posición pasada como parámetro.
   * @param index
   * @return elemento de la lista en la posición index
   */
  public int get(int index) {
    throwExceptionIfIndexOutOfBounds(index);
    return content[index];
  }
  
  /**
   * Reemplaza el elemento que está en la posición index por element.
   * @param index
   * @param element
   * @return elemento sustituido.
   */
  public int set(int index, int element) {
    int elementOld = get(index);
    content[index] = element;
    return elementOld;
  }
  
  /**
   * Borra el elemento que está en la posición index.
   * @param index
   * @return elemento borrado.
   */
  public int remove(int index) {
    int elementDeleted = get(index);
    scrollListToLeftFrom(index + 1);
    return elementDeleted;
  }
  
  /**
   * Desplaza la lista una posición a la izquierda a partir de la posición indicada
   * y disminuye su tamaño en uno.
   * @param index posición a partir de la cual hay que desplazar la lista.
   */  
  private void scrollListToLeftFrom(int index) {
    for (int i = index; i < contentSize; i++) {
      content[i-1] = content[i];
    }
    contentSize--;
  }
  
  /**
   * Devuelve la posición de la lista donde se encuentra element.
   * @param element
   * @return posición de element o -1 si no está.
   */
  public int indexOf(int element) {
    for (int index = 0; index < contentSize; index++) {
      if (content[index] == element) {
        return index;
      }
    }
    return -1;
  }
  
  public boolean contains(int element) {
    return indexOf(element) != -1;
  }
  
  /**
   * Borra la primera ocurrencia de un elemento en la lista.
   * @param element
   * @return éxito de la operación.
   */
  public boolean removeInt(int element) {
    int indexElement = indexOf(element);
    if (indexElement == -1) {
      return false;
    }
    remove(indexElement);
    return true;
  }
 
  /**
   * Vacía la lista.
   */
  public void clear() {
    contentSize = 0;
  }
  
  /**
   * @return si el array de la lista está lleno.
   */
  private boolean isFull() {
    return content.length == contentSize;
  }
  
  /**
   * @return si la lista está vacía.
   */
  public boolean isEmpty() {
    return contentSize == 0;
  }
    
  /**
   * @return número de elementos que hay en la lista.
   */
  public int size() {
    return contentSize;
  }
  
  /**
   * Ordena la lista.
   */
  public void sort() {
    int[] list = Arrays.copyOf(content, contentSize);
    Arrays.sort(list);
    content = Arrays.copyOf(list, contentSize);
  }

  /**
   * Si index está fuera de los límites del array lanza una excepción.
   * @param index
   * @throws IndexOutOfBoundsException
   */
  private void throwExceptionIfIndexOutOfBounds(int index) {
    if (index < 0 || index >= contentSize) {
      throw new IndexOutOfBoundsException("Posición fuera de los límites de la lista.");
    }
  }
  
  @Override
  public String toString() {
    int[] list = Arrays.copyOf(content, contentSize);
    return Arrays.toString(list);
  }
  
  @Override
  public IntArrayList clone() {
    return new IntArrayList(Arrays.copyOf(content, contentSize));
  }

  @Override
  public int hashCode() {   // ha sido necesario modificar lo generado por eclipse
    int[] list = Arrays.copyOf(content, contentSize);
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.hashCode(list);
    result = prime * result + contentSize;
    return result;
  }

  @Override
  public boolean equals(Object obj) { // ha sido necesario modificar lo generado por eclipse
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    IntArrayList other = (IntArrayList) obj;
    if (contentSize != other.contentSize)
      return false;
    int[] listThis = Arrays.copyOf(content, contentSize);
    int[] listOther = Arrays.copyOf(other.content, other.contentSize);
    if (!Arrays.equals(listThis, listOther))
      return false;
    return true;
  }
  
}