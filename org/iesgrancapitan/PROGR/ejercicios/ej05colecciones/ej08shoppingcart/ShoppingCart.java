package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej08shoppingcart;

import java.util.ArrayList;

/**
 * Clase para el carrito de la compra. 
 * 
 * Al carrito se le pueden ir agregando elementos (productos) que se guardarán en una lista. 
 * Cada elemento del carrito deberá contener el nombre del producto, su precio y la cantidad 
 * (número de unidades de dicho producto).
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

}
