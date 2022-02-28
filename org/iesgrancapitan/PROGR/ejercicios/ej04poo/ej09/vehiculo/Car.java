package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej09.vehiculo;

public class Car extends Vehicle {

  public Car() {
    super();
  }
  
  public void doBurnout() { // https://ascii.co.uk/art/formula1
    System.out.println("  _    _             /'_'_/.-''/                             _______\n"
        + "  \\`../ |o_..__     / /__   / /  -= WORLD CHAMPIONSHIP =-   _\\=.o.=/_\n"
        + "`.,(_)______(_).>  / ___/  / /                             |_|_____|_|\n"
        + "~~~~~~~~~~~~~~~~~~/_/~~~~~/_/~~~~~~~~~~~~~~1DAW~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
  }

  @Override
  public String toString() {
    return "Car [getKilometers()=" + getKilometers() + "]";
  }
  
}
