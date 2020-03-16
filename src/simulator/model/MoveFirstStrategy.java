package simulator.model;

import java.util.List;

public class MoveFirstStrategy implements DequeingStrategy {
	
	private final int CERO = 0;
	
	
	@Override
	public List<Vehicle> dequeue(List<Vehicle> q) {
		List<Vehicle> listaAux; 
		
		listaAux = q; 
		
		 listaAux.set(CERO, q.get(CERO));
		
		 return listaAux;
	}
	
	

}
