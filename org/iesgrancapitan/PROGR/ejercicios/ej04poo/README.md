## Ejercicios tanda 1

1. Crea una clase "Dado" que simule el funcionamiento de un dado con caras del 1 al 6 que tienen la misma probabilidad de salir y un programa de prueba.

2. Implementa una clase Point con sus atributos x e y. La clase debe contener: su constructor, los getters y setters, un invertCoordinates() que invierta las coordenadas x e y del punto. Además la clase debe tener un toString() para poder imprimir los puntos en formato “(x,y)”. Implementa un clase tester PointTester con un método main() donde crees un punto, lo imprimas utilizando de manera implícita el toString(), imprimas su coordenada x, asignes 0 a su coordenada x, y vuelvas a imprimir el punto.

3. Implementa la clase Rectangulo (determinado por dos objetos Point) que además de su constructor, tendrá dos métodos para calcular su área y su perímetro. Implementa también una clase tester que cree dos puntos y un rectángulo a partir de estos dos puntos y que muestre el área y perímetro de dicho rectángulo.

4. Implementar otra clase Dado (esta vez lo haremos en inglés, la llamaremos Dice). Por defecto el dado tendrá 6 caras. Tendremos tres constructores (uno al que no se le pasa nada e inicializa el dado al azar, otro al que sólo se le pasa que número tiene el dado en la cara superior y otro con el número del dado en la cara superior y el número de caras del dado). Implementa los getters, el método roll() que tirará el dado al azar y el toString(). Implementa un tester que tenga un vector de 4 dados y los lance una serie de veces.

## Ejercicios tanda 2

Estas clases deben testearse usando JUnit, además, si es oportuno, deben implementar equals() y las interfaces Comparable y Cloneable.

5. Crea una clase "Fracción" inmutable (no hay setters, solo getters para numerador y denominador) de forma que podamos hacer las siguientes operaciones:

    * Construir un objeto Fracción pasándole al constructor el numerador y el denominador. La fracción se construye simplificada, no se puede dividir por cero.
    * Obtener resultado de la fracción (número real).
    * Multiplicar la fracción por un número (el método devuelve otra fracción, simplificada).
    * Multiplicar, dividir, sumar y restar fracciones (los métodos devuelven otra fracción, simplificada).

6. Crea una clase que represente una estructura de datos tipo lista de números enteros que internamente se almacenan en un array que va cambiando de tamaño según lo necesite (de 10 en 10), su comportamiento será el siguiente:

    * IntArrayList(): crea una lista vacía (internamente un array de 10 enteros).
    * IntArrayList(ele1, ..., eleN): crea una lista con los elementos ele1 ... eleN.
    * add(elemento): añade "elemento" al final de la lista. 
    * add(índice, elemento): añade "elemento" en la posición "índice" de la lista.
    * remove(índice): borra el elemento de la lista que está en la posición "índice" y devuelve el elemento borrado.
    * removeInt(elemento): borra la 1ª ocurrencia de "elemento" de la lista y devuelve si ha habido éxito o no en la operación.
    * size(): devuelve el número de elementos que hay en la lista.
    * clear(): vacía la lista.
    * isEmpty(): dice si la lista está vacía.
    * contains(elemento): dice si "elemento" está en la lista.
    * get(índice): devuelve el elemento que está en la posición "índice".
    * set(índice, elemento): reemplaza el elemento que está en la posición "índice" por "elemento". Devuelve el elemento sustituido.
    * indexOf(elemento): devuelve la posición donde está "elemento" y -1 si no existe.
    * sort(): ordena la lista.
    * equals(lista): comprueba si el contenido de nuestra lista es igual a la que hemos pasado como parámetro.
    * clone(): devuelve una nueva lista con una copia exacta de su contenido.
   
7. Usando la clase anterior como superclase crea una clase que represente una estructura de datos tipo pila y otra tipo cola. La pila y la cola permitirán estas operaciones:

    * Crear la pila o la cola con o sin valores iniciales.
    * Obtener el número de elementos almacenados (tamaño).
    * Saber si la pila o la cola está vacía.
    * Vaciar completamente la pila o la cola.
    * Para el caso de la pila:
        * Apilar (push): se añade un elemento a la pila. Se añade al principio de esta.
        * Desapilar (pop): se saca (debe devolverse) un elemento de la pila y se elimina. 
        * Leer el elemento superior de la pila sin retirarlo (top).
    * Para el caso de la cola:
        * Encolar (enqueue): se añade un elemento a la cola. Se añade al final de esta.
        * Desencolar (dequeue): se saca (debe devolverse) y se elimina el elemento frontal de la cola, es decir, el primer elemento que entró.
        * Leer el elemento frontal de la cola, es decir, el primer elemento que entró, sin retirarlo (front).

8. Muestra un menú con las siguientes opciones:

    * Introducir (por teclado) una fecha pidiendo por teclado año, mes y día en formato dd/mm/aaaa. Si no se introduce correctamente se devuelve un mensaje de error. Usa una función booleana para validar la fecha.
    * Añadir días a la fecha. Pide un número de días para sumar a la fecha introducida previamente y actualiza su valor. Si el número es negativo restará los días. Esta opción sólo podrá realizarse si hay una fecha introducida (se ha ejecutado la opción anterior), si no la hay mostrará un mensaje de error. 
    * Añadir meses a la fecha. El mismo procedimiento que la opción anterior.
    * Añadir años a la fecha. El mismo procedimiento que la opción 2.
    * Comparar la fecha introducida con otra. Pide una fecha al usuario en formato dd/mm/aaaa (válida, si no lo es da error) y la comparará con la que tenemos guardada, posteriormente mostrará si esta fecha es anterior, igual o posterior a la que tenemos almacenada y el número de días comprendido entre las dos fechas.
    * Mostrar la fecha en formato largo (ejemplo: "lunes, 1 de febrero de 2021").
    * Terminar.

    Consideraciones a tener en cuenta:

    * El menú lo hacemos con una clase a la que llamaremos Menú, esa clase permitirá ir añadiendo opciones y escoger alguna opción.
    * Las fechas las manejaremos con la clase LocalDate.

9. Ejercicios del libro "Aprende Java con ejercicios" (a partir de la página 194): 2 (con la clase Menú realizada en el ejercicio 6), 8, 9 y 13.