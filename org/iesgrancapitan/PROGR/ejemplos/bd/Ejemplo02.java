package org.iesgrancapitan.PROGR.ejemplos.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Ejemplo anterior usando try-with-resources
 * 
 * @author Rafael del Castillo Gomariz
 *
 */

public class Ejemplo02 {

  public static void main(String[] args) {

    try(Connection connection = DriverManager.getConnection("jdbc:sqlite:agenda.sqlite");
        Statement statement = connection.createStatement();
        ResultSet resultset = statement.executeQuery("SELECT * FROM contactos")) {

      while (resultset.next()) {
        String name = resultset.getString("nombre");
        int phone = resultset.getInt("telefono");
        String email = resultset.getString("email");
        System.out.println(name + "\t" + phone + "\t" + email);
      }

    } catch (SQLException e) {
      System.out.println("Error en la conexión de la base de datos");
      e.printStackTrace();
    }

  }

}
