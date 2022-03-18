package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej09shoppingcart;

import java.util.Objects;

/**
 * Mejora de la versión anterior para el carrito de tal forma que al intentar agregar 
 * un elemento al carrito, se compruebe si ya existe el producto y, en tal caso, se
 * incremente el número de unidades sin añadir un nuevo elemento. 
 * 
 * Esta clase no puede ser un record, ya no va a ser inmutable, las unidades pueden cambiar.
 * Desde "fuera" no tienen porqué darse cuenta, para ello los getters, excepcionalmente, van
 * a tener los mismos nombres que antes: name(), units(), price().
 * 
 * Vamos a sobreescribir el método equals() para que dos productos con el mismo nombre
 * sean el mismo.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

class Product {
  
  private String name;
  private double price;
  private int units;

  Product(String name, double price, int units) {
    throwExceptionIfIllegalArgument(name, price, units);
    this.name = name;
    this.price = price;
    this.units = units;
  }

  String name() {
    return name;
  }

  double price() {
    return price;
  }

  int units() {
    return units;
  }

  void setUnits(int units) {
    trowExceptionIfNegativeUnits(units);
    this.units = units;
  }
  
  void addUnits(int units) {
    trowExceptionIfNegativeUnits(units);
    this.units += units;
  }

  @Override
  public String toString() {
    return String.format("%s PVP: %.2f€ Unidades: %d Subtotal: %.2f€", name, price, units, totalPrice());
  }

  double totalPrice() {
    return units * price;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Product other = (Product) obj;
    return Objects.equals(name, other.name);
  }

  private void throwExceptionIfIllegalArgument(String name, double price, int units) {
    if (price < 0) {
      throw new IllegalArgumentException("El precio del producto no puede ser negativo");
    }
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
    }
    trowExceptionIfNegativeUnits(units);
  }

  private void trowExceptionIfNegativeUnits(int units) {
    if (units <= 0) {
      throw new IllegalArgumentException("Las unidades del producto tienen que ser mayores que cero");
    }
  }
  
}
