package org.iesgrancapitan.PROGR.ejemplos.poo.record.test;

import org.iesgrancapitan.PROGR.ejemplos.poo.record.Point;
import org.iesgrancapitan.PROGR.ejemplos.poo.record.SmallPoint;

public class TestPoint {

  public static void main(String[] args) {
    Point p1 = new Point(2, 3);
    System.out.println("p1 (new Point(2, 3)): " + p1);
    System.out.println("Coordenadas p1: " + p1.x() + "," + p1.y() + "\n");
    
    Point p2 = new Point(3, 4);
    System.out.println("p2 (new Point(3, 4)): " + p2);
    System.out.println("p1.equals(p2) --> " + p1.equals(p2) + "\n");
    
    SmallPoint p3 = new SmallPoint(100, -100);
    System.out.println("p3 (new SmallPoint(100, -100)): " + p3);
    
    SmallPoint p4 = new SmallPoint(150, -200);
    System.out.println("p4 (new SmallPoint(150, -200)): " + p4);
    System.out.println("p3.equals(p4) --> " + p3.equals(p4) + "\n");
  }

}
