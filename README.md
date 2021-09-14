# TrafficSimulator
Una simulación permite ejecutar un modelo en un ordenador para poder observar
su comportamiento y aplicar este comportamiento a la vida real. Las prácticas de TP2
consistirán en construir un simulador de tráfico, que modelará vehículos, carreteras y cruces,
teniendo en cuenta la contaminación ambiental. Habrá diferentes políticas en los cruces
para permitir el paso de los vehículos, diferentes tipos de carreteras en función del grado
de contaminación y vehículos con distintos identificadores ambientales. De esta forma
modelaremos una aplicación (usando orientación a objetos) de un problema de la vida
real.
Construiremos el simulador utilizando entrada/salida estándar (ficheros y/o consola).
El simulador contendrá una colección de objetos simulados (vehículos y carreteras conectadas
a través de cruces), otra colección de eventos a ejecutar y un contador de tiempo
que se incrementará en cada paso de la simulación. Un paso de la simulación consiste en
realizar las siguientes operaciones:
  1. Procesar los eventos. En particular estos eventos pueden añadir y/o alterar el estado
  de los objetos simulados;
  2. Avanzar el estado actual de los objetos simulados atendiendo a su comportamiento.
  3. Mostrar el estado actual de los objetos simulados.
Los eventos se leen de un fichero de texto antes de que la simulación comience. Una
vez leídos, se inicia la simulación, que se ejecutará un número determinado de unidades
de tiempo (llamadas ticks) y, en cada tick, se mostrará el estado de la simulación, bien en
la consola o en un fichero de texto.


![image](https://user-images.githubusercontent.com/49251020/133243681-c8df4ee0-d6e0-46c3-9e7f-d1d71cc0da15.png)
