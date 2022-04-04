package org.iesgrancapitan.PROGR.ejercicios.ej06excepciones.ej02gato;

public class TestGato {

  public static void main(String[] args) {
    Gato peluso = new Gato(Sexo.MACHO);
    Gato pulgoso = new Gato(Sexo.MACHO);
    Gato tomasa = new Gato();
    Gato peggy = new Gato();
    
    try {
      System.out.println("Peluso se aparea con Tomasa: " + peluso.apareaCon(tomasa));
      System.out.println("Peggy se aparea con Tomasa: " + peggy.apareaCon(tomasa));
      System.out.println("Peggy se aparea con Pulgoso: " + peggy.apareaCon(pulgoso));

    } catch (ApareamientoImposibleException e) {
      System.err.println("Ha habido un error al mezclar a los gatos");
      e.printStackTrace();
    }

  }

}
