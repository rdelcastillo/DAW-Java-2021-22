Vamos a modificar el ejercicio de Colecciones de la cuenta bancaria al que le habíamos añadido el registro de sus movimientos de manera que ahora los movimientos sean objetos de la clase **Movement** que se almacenarán en un contenedor (esta vez la clase NO hereda de un contenedor, lo tiene).

Esta clase tendrá los siguientes atributos:

private static int lastNumber = 0;



private int number;

private LocalDate date;

private double amount;

private MovementType type;

private String concept;

private long associatedNumberAccount;

Cada movimiento tiene un identificador numérico que se genera automáticamente (el siguiente al último generado), una fecha, una cantidad (positiva para entradas y negativa para salidas de la cuenta), un tipo de movimiento (INGRESO, CARGO, TRANSFERENCIA\_ENVIADA, TRANSFERENCIA\_RECIBIDA), un concepto y, en el caso de las transferencias, un número de cuenta asociada. Sus constructores tienen esta cabecera:

Movement(LocalDate date, double amount, MovementType type, String concept,

`      `long associatedNumberAccount)

Movement(LocalDate date, double amount, MovementType type, String concept)

Los objetos de esta clase serán inmutables pero el atributo estático lastNumber sí es modificable.

La clase **CurrentAccount** simulará el comportamiento de una cuenta bancaria. Los objetos de esta clase tendrán los siguientes atributos:

private long number;

private String holder;

private List<Movement> movements

Nuestra cuenta tendrá las siguientes operaciones:

\- **Creación de la cuenta**. Para crear una cuenta tenemos que indicar el titular de la cuenta. Además durante el proceso de creación se debe crear un número de cuenta aleatorio de 10 dígitos (recomiendo un long) que no puede repetirse. El método de la clase encargado será el constructor:

`	`public CurrentAccount(String holder)

\- **Obtención del saldo**. El saldo ya no es un atributo de la clase, es un valor calculado a partir de los movimientos de la cuenta.

`	`public double getBalance()

\- **Ingreso**. Registrará un movimiento tipo INGRESO en la fecha especificada, si no se indica fecha en la actual. El importe se almacena con signo positivo.

public void deposit(LocalDate date, double money, String concept)

public void deposit(double money, String concept)

\- **Cargo**. Registrará un movimiento tipo CARGO en la fecha especificada, si no se indica fecha en la actual. El importe se almacena con signo negativo.

public void withdraw(LocalDate date, double money, String concept)

public void withdraw(double money, String concept)

\- **Transferencia**. Registrará un movimiento tipo TRANSFERENCIA\_ENVIADA en la fecha especificada, si no se indica fecha en la actual, y en la cuenta desde la que se hace la transferencia. El importe se almacena con signo negativo. Igualmente registrará un movimiento tipo TRANSFERENCIA\_RECIBIDA en la cuenta a la que se hace la transferencia y en la misma fecha.

public void transfer(LocalDate date, CurrentAccount other, double money, String concept)

public void transfer(CurrentAccount other, double money, String concept)

**IMPORTANTE:** No se puede añadir un movimiento a una cuenta de fecha anterior al último, si esto pasa se genera una excepción.

\- **Obtención de los movimientos de la cuenta**.

`	`public String getMovements()

Tenéis un programa test para comprobar que las clases funcionan.

