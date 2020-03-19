package simulator.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import Exceptions.InvalidArgumentException;

public class TrafficSimulator {
	
	private RoadMap map_of_roads;
	private List<Event> list_of_events; 
	private int time_of_simulation; 
	
	public TrafficSimulator(){ // REVISAR 
		 
	}
	
	
	public void addEvent (Event e) {
		this.list_of_events.add(e); 
		
	}
	
	public void advance() {
		
		
		
		this.time_of_simulation++;
		
		for (int i = 0 ; i< this.list_of_events.size();i++) {
			
			if(this.list_of_events.get(i).getTime() == this.time_of_simulation) {
				try {
					this.list_of_events.get(i).execute(this.map_of_roads);
				} catch (InvalidArgumentException e) {
					// TODO Auto-generated catch block
					e.getMessage();
				}
				
			}
			
			this.list_of_events.remove(i);
		}
		
		//paso 3
		
		for(int i = 0; i< this.map_of_roads.getJunctions().size();i++) {
			this.map_of_roads.getJunctions().get(i).advance(this.time_of_simulation);
		}
		
		// paso 4 
		
		for(int i = 0; i< this.map_of_roads.getRoads().size();i++) {
			this.map_of_roads.getRoads().get(i).advance(this.time_of_simulation);
		}
		
		
	}
	
	public void reset() {
		
		this.map_of_roads.reset(); 		
		this.list_of_events.clear();	
		this.time_of_simulation = 0;
	}
	
	
	
	public JSONObject report() {
		JSONObject j = new JSONObject();
		
		j.put("time : ", this.time_of_simulation);
		j.put("state : ", this.map_of_roads.report()); 	
		
		return j;	
		
	}


	public RoadMap getMap_of_roads() {
		return map_of_roads;
	}


	public void setMap_of_roads(RoadMap map_of_roads) {
		this.map_of_roads = map_of_roads;
	}


	public List<Event> getList_of_events() {
		return list_of_events;
	}


	public void setList_of_events(List<Event> list_of_events) {
		this.list_of_events = list_of_events;
	}


	public int getTime_of_simulation() {
		return time_of_simulation;
	}


	public void setTime_of_simulation(int time_of_simulation) {
		this.time_of_simulation = time_of_simulation;
	}

}
