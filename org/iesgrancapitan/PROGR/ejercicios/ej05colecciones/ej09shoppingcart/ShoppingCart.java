package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej09shoppingcart;

import java.util.ArrayList;

/**
 * Clase para el carrito de la compra. 
 * 
 * Mejora de la versión anterior para el carrito de tal forma que al intentar agregar 
 * un elemento al carrito, se compruebe si ya existe el producto y, en tal caso, se
 * incremente el número de unidades sin añadir un nuevo elemento. 
 * 
 * Se ha sobreescrito el método equals() en la clase Product para que dos productos con
 * el mismo nombre sean el mismo.
 * 
 * En esta clase sobreescribiremos el método add() (de ArrayList).
 * 
 * Ejercicio del libro "Aprende Java con Ejercicios", edición 2019.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

@SuppressWarnings("serial")
public class ShoppingCart extends ArrayList<Product> {

  public double totalPrice() {
    double price = 0;
    for (Product p: this) {
      price += p.totalPrice();
    }
    return price; 
  }

  @Override
  public String toString() {
    String shoppingCartStr = "Contenido del carrito\n=====================\n";
    for (Product p: this) {
      shoppingCartStr += p + "\n";
    }
    shoppingCartStr = shoppingCartStr.substring(0, shoppingCartStr.length()-1); // sin \n final
    return shoppingCartStr;
  }
  
  @Override
  public boolean add(Product p) {
    if (contains(p)) {
      addUnits(p);
      return true;
    }
    return super.add(p);
  }

  private void addUnits(Product p) {
    Product product = get(indexOf(p));
    if (product.price() != p.price()) {
      throw new IllegalArgumentException("Conflicto de precios para el producto " + p.name());
    }
    product.addUnits(p.units()); 
  }

}
