package simulator.model;

import java.util.List;

import Exceptions.InvalidArgumentException;
import simulator.misc.Pair;

public class SetWeatherEvent extends Event {
	
	private List<Pair<String,Weather>> ws;
	
	
	public SetWeatherEvent(int time,List<Pair<String,Weather>> ws) throws InvalidArgumentException {
		super(time);
		
		if(ws != null) {
			this.ws = ws;
		}
		else {
			throw new InvalidArgumentException("The list is null");
		}
		
	}

	@Override
	void execute(RoadMap map) throws InvalidArgumentException {
		String id ; 
		
		for(int i =0 ; i< this.ws.size();i++) {
			if(	map.getRoad(this.ws.get(i).getFirst()) != null) { // si esta en la lista
				id = this.ws.get(i).getFirst() ; // t da el string de la carretera
				
			}
			else {
				throw new InvalidArgumentException("The String does not exist in the list");
			}
			
		}
		
	}
	
	
	public List<Pair<String, Weather>> getWs() {
		return ws;
	}

	public void setWs(List<Pair<String, Weather>> ws) {
		this.ws = ws;
	}

}
