package org.iesgrancapitan.PROGR.ejemplos.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ejemplo de conexión y recorrido de una tabla de una mase de datos sqlite.
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Ejemplo01 {

  public static void main(String[] args) {

    String url = "jdbc:sqlite:agenda.sqlite"; // url base de datos
    
    try {
      Class.forName("org.sqlite.JDBC");  // (Opcional)
      Connection connection = DriverManager.getConnection(url);                 // 1. Crear conexión
      Statement statement = connection.createStatement();                       // 2. Crear Statement
      ResultSet resultset = statement.executeQuery("SELECT * FROM contactos");  // 3. Ejecutar SQL

      // 4. Recorrer ResultSet
      while (resultset.next()) {
        String name = resultset.getString("nombre");
        int phone = resultset.getInt("telefono");
        String email = resultset.getString("email");
        System.out.println(name + "\t" + phone + "\t" + email);
      }
 
      resultset.close();
      statement.close();
      connection.close();  // 5. Cerrar conexión (se puede usar try_with_resources)
    } 
    
    catch (SQLException e) {
      System.out.println("Error en la conexión de la base de datos");
      e.printStackTrace();
    } 
    catch (ClassNotFoundException e) {
      System.out.println("Error en el driver de la base de datos");
      e.printStackTrace();
    }

  }

}
