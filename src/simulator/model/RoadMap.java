package simulator.model;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class RoadMap {
	private  List<Junction> JunctionList;
	private List<Road> RoadList; 
	private List<Vehicle> VehicleList;
	protected Map<String,Junction> IdJunctionMap;
	protected Map<String,Road> IdRoadMap;
	protected Map<String,Vehicle> IdVehicleMap;
	
	protected void addJunction(Junction j) {
		
	}
	
	
	protected void addRoad(Road r) {
		
	}
	
	protected void addVehicle(Vehicle v) {
		
	}
	
	public Junction getJunction(String id) {
		return null; 
	}
	
	public Road RoadGetRoad(String id) {
		return null; 
	}

	public Vehicle getVehicle(String id) {
		return null; 
	}


	public List<Junction> getJunctionList() {
		return JunctionList;
	}


	public void setJunctionList(List<Junction> junctionList) {
		JunctionList = junctionList;
	}


	public List<Road> getRoadList() {
		return RoadList;
	}


	public void setRoadList(List<Road> roadList) {
		RoadList = roadList;
	}


	public List<Vehicle> getVehicleList() {
		return VehicleList;
	}


	public void setVehicleList(List<Vehicle> vehicleList) {
		VehicleList = vehicleList;
	}
	
	protected void reset() {
		
	}
	
	public JSONObject report() {
		return null;
	}
	
	
	

	
}
