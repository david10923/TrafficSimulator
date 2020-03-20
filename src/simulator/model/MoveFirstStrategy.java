package simulator.model;

import java.util.List;

public class MoveFirstStrategy implements DequeingStrategy {
	
	private final int CERO = 0;
	
	
	@Override
	public List<Vehicle> dequeue(List<Vehicle> q) {
		
		if(q.size() >0){
			List<Vehicle>  listaAux = q; 
			listaAux.add(q.get(CERO));
			 return listaAux;
		}
		return null;
		
	}
	
	

}
