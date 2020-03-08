package simulator.model;

import java.util.List;

public interface DequeingStrategy {
	List<Vehicle> dequeue(List<Vehicle> q);
	
	// las dos estrategias que implementan esta interfaz eliminan vehiculos de las carreteras entrantes cuyo semaforo este a verde

}
