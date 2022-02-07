package org.iesgrancapitan.PROGR.ejercicios.ej00secuenciales;
/* Este codigo ha sido generado por el modulo psexport 20180125-l64 de PSeInt.
Es posible que el codigo generado no sea completamente correcto. Si encuentra
errores por favor reportelos en el foro (http://pseint.sourceforge.net).

Retocado por Rafael del Castillo con el comando sed. */

import java.util.Scanner;

public class Ej16CalcularAdelantamiento {

  // ################################################################################
  // Dos vehículos viajan a diferentes velocidades (v1 y v2) y están distanciados
  // por una distancia d.
  // El que está detrás viaja a una velocidad mayor. Se pide hacer un algoritmo
  // para ingresar la distancia entre los dos vehículos (km) y sus respectivas
  // velocidades (km/h) y con esto determinar y mostrar en que tiempo (minutos)
  // alcanzará el vehículo más rápido al otro.
  // ################################################################################
  // Análisis
  // Hay que saber la velocidad de cada vehículo, y la distancia entre ambos
  // Hay que calcular el tiempo que tardará el que está detrás (y va más rápido)
  // alcanzar al primero.
  // Datos de entrada: velocidad1, velocidad2 km/h (real) y distancia (real).
  // Información de salida: Tiempo en minutos (real)
  // Variables: velocidad1, velocidad2, distancia (real), tiempo (real).
  // ################################################################################
  // Diseño
  // 1. Leer las dos velocidades y la distancia (no puedo controlar que v1 > v2.
  // 2. Calcular tiempo: (v=s/t), por lo tanto t=s/v. Tiempo = distancia / (v1-v2)
  // 3. El tiempo hay que pasarlo a minútos
  // 4. Mostrar tiempo
  // ################################################################################

  public static void main(String args[]) {
    Scanner s = new Scanner(System.in);
    double distancia;
    double tiempo;
    double velocidad1;
    double velocidad2;

    System.out.print("Dime la velocidad del coche 1 (km/h): ");
    velocidad1 = s.nextDouble();
    System.out.print("Dime la velocidad del coche 2 (más pequeña)(km/h): ");
    velocidad2 = s.nextDouble();
    System.out.print("Dime la distancia entre los coches (km): ");
    distancia = s.nextDouble();

    tiempo = distancia/(velocidad1-velocidad2);
    tiempo = tiempo*60;

    System.out.println("Lo alcanza en "+tiempo+" minutos.");
  }


}

