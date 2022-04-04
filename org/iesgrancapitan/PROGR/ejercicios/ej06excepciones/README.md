# Ejercicios de excepciones del libro "Aprende Java con Ejercicios", edición 2019

## Ejercicio 1

Realiza un programa que pida 6 números por teclado y nos diga cuál es el máximo. Si el usuario introduce un dato erróneo (algo que no sea un número entero) el programa debe indicarlo y debe pedir de nuevo el número.

## Ejercicio 2

Modifica la [clase Gato](https://github.com/LuisJoseSanchez/aprende-java-con-ejercicios/blob/master/ejemplos/09_POO/EjemploAnimal/Gato.java) vista anteriormente añadiendo el método apareaCon. Este método debe comprobar que los gatos son de distinto sexo, tras lo cual, genera un nuevo gato. Por ejemplo, sería válido algo como `Gato cria = garfield.apareaCon(lisa)`. En caso de que los gatos sean del mismo sexo, el método debe generar la excepción `ApareamientoImposibleException`. Crea un programa desde el que se pruebe el método.