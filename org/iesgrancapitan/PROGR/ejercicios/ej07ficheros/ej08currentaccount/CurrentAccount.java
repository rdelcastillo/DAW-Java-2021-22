package org.iesgrancapitan.PROGR.ejercicios.ej07ficheros.ej08currentaccount;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Ampliación de la clase Cuenta Corriente del tema anterior.
 * 
 * Cada cuenta lleva un registro de todos los movimientos realizados: ingresos, cargos y
 * transferencias (tanto enviadas como recibidas).
 * 
 * Además añadimos un método para guardar todos los datos de la cuenta bancaria (número, saldo 
 * y movimientos) como objeto en un fichero cuyo nombre será la cuenta cuenta corriente, y un 
 * nuevo constructor que reciba como parámetro el fichero como el anterior y cree el objeto con 
 * esos datos. 
 * 
 * Ejercicio del libro "Aprende Java con Ejercicios", edición 2019.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class CurrentAccount implements Serializable {
  
  private static final long serialVersionUID = 1L;

  private static List<Long> accounts = new ArrayList<Long>();
  
  private long number;
  private double balance;
  private List<String> movements = new ArrayList<>();
  
  public CurrentAccount() {
    balance = 0;
    createNumberAccount();
    createMovementsAccount();
  }
  
  public CurrentAccount(int balance) {
    this.balance = balance;
    createNumberAccount();
    createMovementsAccount();
  }

  private void createNumberAccount() {
    do {
      number = 1 + (long) (Math.random() * 9999999999L);
    } while (accounts.contains(number));
    accounts.add(number);
  }
  
  private void createMovementsAccount() {
    movements.add("Creada cuenta " + numberToStr() + " " + balanceToStr());
  }
  
  public long getNumber() {
    return number;
  }

  public double getBalance() {
    return balance;
  }
  
  public String getMovements() {
    String movementsStr = "Movimientos de la cuenta " + numberToStr() + "\n"
        + "-----------------------------------\n";
    for (String m: movements) {
      movementsStr += m + "\n";
    }
    movementsStr = movementsStr.substring(0, movementsStr.length()-1);  // quito el \n final
    return movementsStr;
  }

  public void deposit(double money) {
    throwExceptionIfMoneyIsNegative(money);
    balance += money;
    movements.add("Ingreso de " + moneyToStr(money) +  " " + balanceToStr());
  }

  public void withdraw(double money) {
    throwExceptionIfMoneyIsNegative(money);
    balance -= money;
    movements.add("Cargo de " + moneyToStr(money) + " " + balanceToStr());
  }

  public void transfer(CurrentAccount other, double money) {
    throwExceptionIfMoneyIsNegative(money);
    balance -= money;
    movements.add("Transferencia emitida de " + moneyToStr(money) + " a la cuenta " 
        + other.numberToStr() + " " + balanceToStr());
    other.balance += money;
    other.movements.add("Transferencia recibida de " + moneyToStr(money) + " de la cuenta "
        + numberToStr() + " " + other.balanceToStr());
  }

  private void throwExceptionIfMoneyIsNegative(double money) {
    if (money <= 0) {
      throw new IllegalArgumentException("El dinero de esta operación tiene que ser mayor que cero.");
    }
  }

  @Override
  public String toString() {
    return "Número de cuenta: " + numberToStr() + " Saldo: " + moneyToStr(balance);
  }

  private String numberToStr() {
    return String.format("%010d", number);
  }
  
  private String balanceToStr() {
    return "Saldo: " + moneyToStr(balance);
  }
  
  private String moneyToStr(double money) {
    return String.format("%.2f €", money);
  }
  
  // Métodos añadidos en este ejercicio
  
  public void save() throws IOException {
    String fileName = String.valueOf(number) + ".obj";
    ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(fileName));
    file.writeObject(this);
    file.close();
  }
  
  public CurrentAccount(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
    // Creamos un objeto con la información del fichero
    ObjectInputStream file = new ObjectInputStream(new FileInputStream(fileName));
    CurrentAccount obj = (CurrentAccount) file.readObject();
    file.close();

    if (accounts.contains(obj.number)) {  // cuenta duplicada
      throw new IllegalArgumentException("Ya existe ese número de cuenta");
    }
    
    // Registramos el número de cuenta y copiamos los datos al objeto actual
    accounts.add(obj.number);
    this.number = obj.number;
    this.balance = obj.balance;
    this.movements = obj.movements;
  }
}
