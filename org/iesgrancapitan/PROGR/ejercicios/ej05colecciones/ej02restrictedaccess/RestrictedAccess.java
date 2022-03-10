package org.iesgrancapitan.PROGR.ejercicios.ej05colecciones.ej02restrictedaccess;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Ejemplo de control de acceso al área restringida de un programa. 
 * Se pide un nombre de usuario y una contraseña. Si el usuario introduce los datos 
 * correctamente, el programa dice “Ha accedido al área restringida”. 
 * El usuario tendrá un máximo de 3 oportunidades. Si se agotan las oportunidades el 
 * programa dice “Lo siento, no tiene acceso al área restringida”. 
 * Los nombres de usuario con sus correspondientes contraseñas estarán almacenados en
 * una estructura de la clase HashMap.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class RestrictedAccess {
  
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Map<String,String> passwords = new HashMap<>(Map.of(
        "user1","password1",
        "user2","password2",
        "user3","password3",
        "user4","password4",
        "user5","password5"));
    
    System.out.println("Acceso al área restringida");
    System.out.println("--------------------------");
    
    String user = null;
    String pass = null;
    boolean access = false;
    int attemp = 0;
    
    do {
      attemp++;
      System.out.println("Introduzca los datos de acceso (intento " + attemp + "/3)");
      System.out.print("Usuario: ");
      user = in.nextLine();
      if (passwords.containsKey(user)) {
        System.out.print("Contraseña: ");
        pass = in.nextLine();
        if (passwords.get(user).equals(pass)) {
          System.out.println("\nHa accedido al área restringida");
          access = true;
        } else {
          System.out.println("Contraseña incorrecta\n");
        }
      } else {
        System.out.println("Usuario incorrecto\n");
      }
    } while (!access && attemp < 3);
    
    if (!access) {
      System.out.println("Lo siento, no tiene acceso al área restringida");
    }
  }

}
