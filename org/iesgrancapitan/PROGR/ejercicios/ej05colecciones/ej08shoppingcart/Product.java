package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej08shoppingcart;

/**
 * El producto va ligado al carrito, no tiene sentido sin él, por lo que ponemos
 * su visibilidad a nivel de paquete.
 * 
 * Otra opción hubiera sido ponerlo como clase privada dentro de la clase del carrito.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

record Product(String name, double price, int units) {

  Product {
    if (price < 0) {
      throw new IllegalArgumentException("El precio del producto no puede ser negativo");
    }
    if (units <= 0) {
      throw new IllegalArgumentException("Las unidades del producto tienen que ser mayores que cero");
    }
  }

  @Override
  public String toString() {
    return String.format("%s PVP: %.2f€ Unidades: %d Subtotal: %.2f€", name, price, units, totalPrice());
  }

  double totalPrice() {
    return units * price;
  }
  
}
