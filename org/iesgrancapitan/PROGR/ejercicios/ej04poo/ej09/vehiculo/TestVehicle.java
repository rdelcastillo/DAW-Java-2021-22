package org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej09.vehiculo;

import org.iesgrancapitan.PROGR.ejercicios.ej04poo.ej08menulocaldate.Menu;

public class TestVehicle {
  
  private static final int MAX_TRAVEL_BIKE = 50;
  private static final int MIN_TRAVEL_BIKE = 10;
  private static final int MIN_TRAVEL_CAR = 50;
  private static final int MAX_TRAVEL_CAR = 500;
  
  private static Car myCar = new Car();
  private static Bike myBike = new Bike();

  public static void main(String[] args) {
    Menu menu = createMenu();
    
    int option;
    do {
      option = menu.choose();
      switch (option) {
        case 1 -> travelWithBike();
        case 2 -> doWheelieWithBike();
        case 3 -> travelWithCar();
        case 4 -> doBurnoutWithCar();
        case 5 -> showBikeMileage();
        case 6 -> showCarMileage();
        case 7 -> showTotalMileage();
      }
    } while (option != menu.lastOption());
    
    System.out.println("¡Hasta la próxima! ;-)");
  }

  private static Menu createMenu() {
    return new Menu("VEHÍCULOS",
        "Anda con la bicicleta",
        "Haz el caballito con la bicicleta",
        "Anda con el coche",
        "Quema rueda con el coche",
        "Ver kilometraje de la bicicleta",
        "Ver kilometraje del coche",
        "Ver kilometraje total",
        "Salir");
  }

  private static void travelWithBike() {
    int kilometers = getRandomNumber(MIN_TRAVEL_BIKE, MAX_TRAVEL_BIKE);
    myBike.travel(kilometers);
    System.out.println("La bicicleta recorre " + kilometers + " kms.\n");
  }

  private static void doWheelieWithBike() {
    myBike.doWheelie();
  }

  private static void travelWithCar() {
    int kilometers = getRandomNumber(MIN_TRAVEL_CAR, MAX_TRAVEL_CAR);
    myCar.travel(kilometers);
    System.out.println("El coche recorre " + kilometers + " kms.\n");
  }

  private static void doBurnoutWithCar() {
    myCar.doBurnout();
  }

  private static void showBikeMileage() {
    System.out.println("El kilometraje de la bicicleta es de " + myBike.getKilometers() + " kms.\n");
  }

  private static void showCarMileage() {
    System.out.println("El kilometraje del coche es de " + myCar.getKilometers() + " kms.\n");
  }

  private static void showTotalMileage() {
    System.out.println("El kilometraje TOTAL es de " + Vehicle.getTotalKilometers() + " kms.\n");
  }
  
  private static int getRandomNumber(int min, int max) {
    return min + (int) ((Math.random() * (max - min + 1)));
}

}
