Tema 1:
1. Definir una clase Auto que no pueda ser instanciada y que tenga definidos los siguientes datos: marca, modelo, año de fabricación y potencia (caballos de fuerza). Hay tres tipos de autos: deportivo, lujoso y económico. La marca y el modelo no pueden ser modificados pero sí consultados. Cada auto tiene una autonomía (cantidad de kilómetros que puede recorrer sin re-abastecerse de combustible) que se calcula distinto según el tipo de auto:
1. Deportivo: 600 / potencia


1. Lujo: 600 *(número entre 0,7 y 0,9)


1. Económico: 720
Generar 20 autos utilizando un número al azar que nos indique el tipo de auto.  Imprimir por consola todos los datos de los autos (marca, modelo, año de fabricación, potencia y autonomía).
1. Implementar una calculadora que tenga las siguientes funcionalidades:
1. Sumar dos números
2. Multiplicar dos números
3. Imprimir por consola el cálculo realizado, indicando los operandos (números), si eran enteros o decimales, la operación y el resultado. Ejemplos:  
1. 1 + 1 = 2 (números enteros) 
2. 1,5 + 8,5 = 10 (números decimales)
1. El método para sumar números se llama sumar y el método para multiplicar se llama multiplicar. ¿Qué concepto de programación orientado a objetos se aplica para sumar/multiplicar números enteros y decimales con el mismo nombre de método?
1. Un celular tiene una marca, un modelo y N componentes. Cada componente tiene un nombre y costo. Crear tres celulares con al menos 15 componentes y no más de 25, y calcular su costo. Indicar cuál es el celular más económico y cuál es el más costoso.




________________
Tema 2:
1. Un celular tiene una marca, un modelo y N componentes. Cada componente tiene una vida útil medida en cantidad de días. Crear un celular con al menos 20 componentes y calcular cuántos días puede funcionar el celular sin que un componente exceda su vida útil.
2. Definir la clase Ascensor que permita subir y bajar N pisos sin escalas. El ascensor va a ser instalado en un edificio de X pisos (la cantidad de pisos es parametrizable). Validar que no se puede subir más del piso máximo así como tampoco bajar más allá de la PB (piso 0). Imprimir todas las órdenes que se le dan al ascensor, indicando el piso inicial y final en caso de que se haya realizado el recorrido o indicando que el recorrido no es válido.
3. La materia de Laboratorio 1 tiene 25 alumnos y cada alumno tiene un legajo y un nombre. Indicar las notas de los dos parciales de cada alumno de manera aleatoria e informar por consola si aprobaron, si van a final o si recursan teniendo en cuenta el siguiente criterio:
1. Si aprobaron los dos parciales con notas superiores a 6, aprueban la materia sin rendir final
2. Si su promedio es menor a 4, recursan
3. En cualquier otro caso, van a final
________________
Tema 3:
1. Un médico tiene una matrícula, un nombre y una especialidad. La especialidad está definida por un código y un nombre. Se necesita cargar los datos de los 30 médicos que trabajan en la clínica para poder recuperarlos por especialidad.
1.  Implementarlo usando un diccionario de datos
2. Implementarlo sin un usar un diccionario de datos
1. Un dado tiene 6 caras, cada cara tiene un número y un color. El color es un numero entero entre 0 y 10, no puede haber dos caras con el mismo color. Crear un dado y “tirarlo” (girarlo para que salga una cara de manera aleatoria) 15 veces, indicando por consola el número y color en cada tiro. Indicar también la cantidad de veces que salió cada número, detallando el número que más veces salió.
2. Modelar un motor de auto que está compuesto por N piezas que se diferencian entre sí solamente por su nombre. Al iniciar el motor se deben iniciar todas sus piezas, imprimiendo por consola un mensaje en cada inicialización. La inicialización de una pieza tiene un 90% de chances de ser exitosa. Si una pieza falla, se debe indicar por consola que el inicio del motor falló y finalizar la inicialización (si falla la inicialización de la primer pieza ya no es necesario que se inicialicen las siguientes).
________________
Tema 4:
1. Un restaurant desea implementar un sistema para cargar su menú de platos. Cada plato tiene un nombre y está compuesto por ingredientes. Cada ingrediente tiene un nombre y un costo. Crear 2 platos con N ingredientes e imprimir por consola su costo 
Ej.: 
Plato: Milanesa napolitana, costo: $10
Ingredientes: 
        150 grs. de carne, costo: $6
        100 grs. de jamón, costo: $3
        100 grs. de queso, costo: $1
Tener en cuenta que en este plato los ingredientes son: carne, jamón y queso, las cantidades no forman parte del ingrediente sino que indican la cantidad necesaria de ese ingrediente para preparar el plato.
1. Un mazo de cartas de truco tiene 40 naipes. Cada naipe tiene un número y un palo. Un palo es descripto por un nombre y la ruta de una imagen. Sacar cartas de manera aleatoria y mostrarlas por consola. Luego, indicar la cantidad de veces que salió cada carta y la carta que más veces salió.
2. Un banco tiene N cuentas bancarias donde cada cuenta es descripta por un número, un titular (nombre de persona) y un saldo.  Una cuenta puede transferir dinero a otra cuenta si se cumplen las siguientes condiciones:
1. La cuenta de origen tiene saldo suficiente
2. La transferencia no excede los $10.000
El saldo de la cuenta bancaria es un número aleatorio entre -$2.000 y $50.000
El valor de la transferencia es un número aleatorio positivo y menor o igual que el mayor de los saldo de las cuentas en cuestión (origen y destino).
Imprimir las operaciones por consola indicando cuenta de origen, destino, monto transferido y resultado (éxito o fracaso).
Ej:
Cuenta 000001, titular X, saldo $1.000. Cuenta 0000002, titular X2, saldo $15.000
Transferencia desde Cuenta 000001 a Cuenta 0000002:
1. Valor a transferir: $4.000  fracaso, no se dispone de saldo
2. Valor a transferir: $12.000  fracaso, excede máximo
3. Valor a transferir: $800  éxito