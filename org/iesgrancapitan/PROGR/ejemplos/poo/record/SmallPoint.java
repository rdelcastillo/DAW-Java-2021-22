package org.iesgrancapitan.PROGR.ejemplos.poo.record;

public record SmallPoint(int x, int y) {
  
  public SmallPoint {
    if (Math.abs(x) > 100) {
      x = Integer.signum(x) * 100;
    }
    if (Math.abs(y) > 100) {
      y = Integer.signum(y) * 100;
    }
  }

}
