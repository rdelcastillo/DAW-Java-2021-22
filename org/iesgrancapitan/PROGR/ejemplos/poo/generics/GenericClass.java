package org.iesgrancapitan.PROGR.ejemplos.poo.generics;

/**
 * Ejemplo de uso de clase genérica.
 * 
 * Se trata de una clase parametrizada sobre uno o más tipos.
 * 
 * @author Rafael del Castillo Gomariz
 *
 * @param <N>
 * 
 * N será reemplazado por una clase real derivada de Number 
 * cuando se cree un objeto.
 * 
 * Ejemplos: 
 * 
 *      GenericClass<Double> d = new GenericClass<>();
 *      var e = new GenericClass<Integer>(10);
 */

public class GenericClass<N extends Number> {
  
  private N attribute;

  public GenericClass() {
    this.attribute = null;
  }
  
  public GenericClass(N atributte) {
    this.attribute = atributte;
  }

  public N getAttribute() {
    return attribute;
  }

  public void setAttribute(N attribute) {
    this.attribute = attribute;
  }

  public String getClassName() {
    return this.attribute.getClass().getName();
  }

}
