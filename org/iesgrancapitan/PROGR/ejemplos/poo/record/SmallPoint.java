package org.iesgrancapitan.PROGR.ejemplos.poo.record;

public record SmallPoint(int x, int y) {
  
  public int x() { 
    return x < 100 ? x : 100; 
  }
  
  public int y() { 
    return y < 100 ? y : 100; 
  }

}
