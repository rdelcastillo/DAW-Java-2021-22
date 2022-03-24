Vamos a crear la clase **CashRegister** que simula el comportamiento de una caja registradora como la que tiene cualquier establecimiento comercial. Nuestra caja tendrá las siguientes operaciones:

\- **Entrada y salida de efectivo**. Tenemos que registrar la cantidad que entra o sale, la fecha y hora de la operación y el concepto. Esta operación tiene un identificador numérico que se crea automáticamente y por defecto es el de la operación anterior incrementado en 1. No se puede añadir un movimiento con fecha y hora anterior al último. Si la fecha y hora no se indica se toma la actual.

\- **Borrado del último movimiento**. El resto de movimientos no se pueden borrar porque descuadrarían los saldos de la caja.

\- **Obtención de los movimientos de la caja**.

Estas operaciones se implementarán en los siguientes métodos:

- public void add(LocalDateTime dateTime, double amount, String concept)
  - lanza excepción si la fecha y hora del movimiento es anterior al último
- public void add(double amount, String concept)
  - añade el movimiento con la fecha y hora actual
- public void deleteLast()
  - borra el último movimiento
- public String toString()

Los movimientos de caja se guardarán en una colección y serán objetos de la clase **Movement**. Esta clase tendrá los siguientes atributos:

- int id
  - identificador numérico del movimiento, será el último asignado a la Caja a la que pertenece incrementado en 1
- LocalDateTime dateTime
  - fecha y hora del movimiento
- double amount
  - importe del movimiento, será positivo si es una entrada y negativo en caso contrario
- String concept

Los objetos de esta clase serán inmutables pero el atributo estático lastNumber sí es modificable.

Tenéis un programa test para comprobar que las clases funcionan.

Por último hay que hacer un programa con un menú para gestionar una caja registradora. Las opciones del menú serán:

1. Entrada de caja (con la fecha y hora actual).
1. Salida de caja (con la fecha y hora actual).
1. Borrado del último movimiento de la caja.
1. Impresión de la caja.
1. Salir.
