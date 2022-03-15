package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej09shoppingcart;

public class TestShoppingCart {

  public static void main(String[] args) {
    ShoppingCart myShoppingCart = new ShoppingCart();
    myShoppingCart.add(new Product("Tarjeta SD 64Gb", 19.95, 2));
    myShoppingCart.add(new Product("Canon EOS 2000D", 449, 1));
    System.out.println(myShoppingCart);
    System.out.print("Hay " + myShoppingCart.size());
    System.out.println(" productos en la cesta.");
    System.out.println("El total asciende a "
        + String.format("%.2f", myShoppingCart.totalPrice()) + " euros");
    
    System.out.println("\nContinúa la compra...\n");
    
    myShoppingCart.add(new Product("Samsung Galaxy Tab", 199, 3));
    myShoppingCart.add(new Product("Tarjeta SD 64Gb", 19.95, 1));
    System.out.println(myShoppingCart);
    System.out.print("Ahora hay " + myShoppingCart.size());
    System.out.println(" productos en la cesta.");
    System.out.println("El total asciende a "
        + String.format("%.2f", myShoppingCart.totalPrice()) + " euros");
  }

}
