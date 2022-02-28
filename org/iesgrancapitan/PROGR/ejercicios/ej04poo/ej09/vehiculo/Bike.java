package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej09.vehiculo;

public class Bike extends Vehicle {
  
  public Bike() {
    super();
  }
  
  public void doWheelie() { // http://stuffthatspins.com/stuff/ASCII-Art-bicycle-bike-cycling.html
    System.out.println("            o       _      _          _\n"
        + "   _o      /\\_    _ \\\\o   (_)\\__/o   (_)\n"
        + " _< \\_    _>(_)  (_)/<_     \\_| \\    _|/' \\/\n"
        + "(_)>(_)  (_)         (_)    (_)     (_)'  _\\o_\n"
        + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~1DAW~~\n");
  }

  @Override
  public String toString() {
    return "Bike [getKilometers()=" + getKilometers() + "]";
  }

}
