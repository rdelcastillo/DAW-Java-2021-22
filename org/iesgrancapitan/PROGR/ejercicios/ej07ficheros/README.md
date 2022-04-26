# Ejercicios de ficheros

## Ejercicio 1

Escribe un programa que guarde en un fichero con nombre primos.txt los números primos que hay entre 1 y 500.

## Ejercicio 2

Escribe un programa que sea capaz de leer el fichero anterior y lo muestre por la pantalla.

## Ejercicio 3

Modifica el ejercicio de POO que gestiona una cuenta bancaria con movimientos, de forma que añadas a la clase un método para guardar todos los datos de la cuenta bancaria (número, saldo y movimientos) en un fichero elegido por el cliente, y un nuevo constructor que reciba como parámetro un fichero como el anterior y cree el objeto con esos datos. Pruébalo con un programa.

## Ejercicio 4

Realiza un programa que sea capaz de ordenar alfabéticamente las palabras contenidas en un fichero de texto. El nombre del fichero que contiene las palabras se debe pasar como argumento en la línea de comandos. El nombre del fichero resultado debe ser el mismo que el original añadiendo la coletilla sort, por ejemplo *palabras_sort.txt*. Suponemos que cada palabra ocupa una línea.

## Ejercicio 5

Escribe un programa que guarde en un fichero el contenido de otros dos ficheros, de tal forma que en el fichero resultante aparezcan las líneas de los primeros dos ficheros mezcladas, es decir, la primera línea será del primer fichero, la segunda será del segundo fichero, la tercera será la siguiente del primer fichero, etc.

Los nombres de los dos ficheros origen y el nombre del fichero destino se deben pasar como argumentos en la línea de comandos.

Hay que tener en cuenta que los ficheros de donde se van cogiendo las líneas pueden tener tamaños diferentes.

## Ejercicio 6

Realiza un programa que diga cuántas ocurrencias de una palabra hay en un fichero. Tanto el nombre del fichero como la palabra se deben pasar como argumentos en la línea de comandos.

## Ejercicio 7

Escribe un programa capaz de quitar los comentarios de un programa de Java.

Se utilizaría de la siguiente manera:

    java QuitaComentarios <PROGRAMA_ORIGINAL> <PROGRAMA_LIMPIO>

Por ejemplo:

    java QuitaComentarios Hola.java HolaSinComentarios.java

crea un fichero con nombre *HolaSinComentarios.java* que contiene el código de *Hola.java* pero sin los comentarios.

## Ejercicio 8

Modifica el ejercicio de la cuenta corriente para que el método que almacena en un fichero el estado del objeto guarde el objeto entero y el que lo recupera lo restaure. En esta versión no le pasamos nombre de fichero al método a la hora de guardarlo, usará el número de cuenta corriente para ello.

## Ejercicio 9

Crea un programa que encripte un fichero que le pasamos como parámetro y almacene el resultado en otro, que también pasamos como parámetro, de manera que:

  * Si el programa no recibe el número de parámetros adecuado termina con un error 1.
  * Si el programa recibe un solo parámetro guardará la información encriptada en el mismo archivo del que lee, pero antes advertirá al usuario de que machacará el archivo origen, dando opción a que la operación no se haga.
  * Si el fichero origen no existe (da error al abrirlo como lectura) el programa termina con un mensaje de error y código 2.
  * Si en el fichero destino no se puede escribir (da error al abrirlo como escritura) el programa termina con un mensaje de error y código 3.
  * Para encriptar usa el método César, necesitarás una clave que debes pedir al usuario.

## Ejercicio 10

Haz un programa que reciba como parámetro un fichero encriptado con el método César, lo desencripte y almacene el resultado en otro archivo, que también pasamos como parámetro, de manera que:

  * Si el programa no recibe el número de parámetros adecuado termina con un error 1.
  * Si el programa recibe un solo parámetro guardará la información encriptada en el mismo archivo del que lee, pero antes advertirá al usuario de que machacará el archivo origen, dando opción a que la operación no se haga.
  * Si el fichero origen no existe (da error al abrirlo como lectura) el programa termina con un mensaje de error y código 2.
  * Si en el fichero destino no se puede escribir (da error al abrirlo como escritura) el programa termina con un mensaje de error y código 3.
  * Para desencriptar necesitas una clave que debes pedir al usuario.
  * ¿Se te ocurre alguna forma de desencriptar este archivo sin pedir clave? Coméntala, y si te atreves... ¡impleméntala!