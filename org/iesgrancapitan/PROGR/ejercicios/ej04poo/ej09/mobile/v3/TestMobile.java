package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej09.mobile.v3;

public class TestMobile {

  public static void main(String[] args) {
    Mobile m1 = new Mobile("678 11 22 33", "rata");
    Mobile m2 = new Mobile("644 74 44 69", "mono");
    Mobile m3 = new Mobile("622 32 89 09", "bisonte");
    System.out.println(m1);
    System.out.println(m2);
    m1.call(m2, 320);
    m1.call(m3, 200);
    m2.call(m3, 550);
    System.out.println(m1);
    System.out.println(m2);
    System.out.println(m3);
  }

}
