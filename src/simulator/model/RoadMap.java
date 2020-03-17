package simulator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import Exceptions.InvalidArgumentException;

public class RoadMap {
	private  List<Junction> JunctionList;
	private List<Road> RoadList; 
	private List<Vehicle> VehicleList;
	private Map<String,Junction> IdJunctionMap;
	private Map<String,Road> IdRoadMap;
	private Map<String,Vehicle> IdVehicleMap;
	
	
	public RoadMap() {
		this.IdJunctionMap = new HashMap<String,Junction>();
		this.JunctionList = new ArrayList<Junction>();
		this.RoadList = new ArrayList<Road>();
		this.VehicleList = new ArrayList<Vehicle>();
		this.IdRoadMap = new HashMap<String,Road>();
		this.IdVehicleMap = new HashMap<String,Vehicle>();
	}
	
	protected void addJunction(Junction j) {
		boolean ok = false; 
		
		for(int i = 0; i < this.JunctionList.size();i++) {
			if(	this.JunctionList.get(i).getId().equals(j._id)) {
			ok = true;
			}
		}
		
		if(!ok) {
			this.JunctionList.add(j); 
			this.IdJunctionMap.put(j.getId(), j);
			
		}
		
		
	}
	
	
	
	protected void addRoad(Road r) throws InvalidArgumentException {
		boolean ok = true, ok2 = false; 
		// I 
		for(int i = 0; i< this.RoadList.size();i++) {
			if(!this.RoadList.get(i).getId().equals(r.getId())) {
				ok = false;
			}
		}
		//II
		if(this.IdRoadMap.containsValue(r.getSource()) ||  this.IdRoadMap.containsValue(r.getDestination())) {
			ok2 = true;
		}
		
		
		if(ok2 && ok ) {
			this.RoadList.add(r); 
			this.IdRoadMap.put(r.getId(), r);
			
		}else {
			throw new InvalidArgumentException("You can not add the road you specified");
		}
		
	}
	
	protected void addVehicle(Vehicle v) throws InvalidArgumentException {
		boolean ok = false , ok2= false;
		
		//I
		for (int i = 0; i < this.VehicleList.size();i++) {
			if(this.VehicleList.get(i).getId().equals(v._id)) {
				ok = true;
			}
		}
		
		//II
		
		if (!v.recorreItinerario()) {
			ok2=true;
		}
		
		
		if(ok && ok2) {
			throw new  InvalidArgumentException("This Vehicle can not be add : "+ v._id);
		}else {
			this.VehicleList.add(v);
			this.IdVehicleMap.put(v._id, v);
		}
	}
	
	public Vehicle getVehicle(String id) {
		
		boolean ok = false;
		int i = 0;
		while(i < this.VehicleList.size() && ok) {
			if(this.VehicleList.get(i)._id.equals(id)) {
				ok =true;
			}
			i++;
		}
		
		if(ok) {
			return this.VehicleList.get(i);
		}
		else {
			return null;
		}
		
		
	}
	
	
	public Road getRoad(String id ) {
		boolean ok = false;
		int i = 0;
		while(i < this.RoadList.size() && ok) {
			if(this.RoadList.get(i)._id.equals(id)) {
				ok =true;
			}
			i++;
		}
		
		if(ok) {
			return this.RoadList.get(i);
		}
		else {
			return null;
		}
		
	}
	
	public Junction getJunction(String id ) {
		boolean ok = false;
		int i = 0;
		while(i < this.JunctionList.size() && ok) {
			if(this.JunctionList.get(i)._id.equals(id)) {
				ok =true;
			}
			i++;
		}
		
		if(ok) {
			return this.JunctionList.get(i);
		}
		else {
			return null;
		}
		
	}
	
	
	
	public Map<String, Junction> getIdJunctionMap() {
		return IdJunctionMap;
	}

	public void setIdJunctionMap(Map<String, Junction> idJunctionMap) {
		IdJunctionMap = idJunctionMap;
	}

	public Map<String, Road> getIdRoadMap() {
		return IdRoadMap;
	}

	public void setIdRoadMap(Map<String, Road> idRoadMap) {
		IdRoadMap = idRoadMap;
	}

	public Map<String, Vehicle> getIdVehicleMap() {
		return IdVehicleMap;
	}

	public void setIdVehicleMap(Map<String, Vehicle> idVehicleMap) {
		IdVehicleMap = idVehicleMap;
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
		
		this.IdJunctionMap = null;
		this.IdRoadMap = null;
		this.IdVehicleMap = null;
		this.JunctionList = null; 
		this.RoadList = null; 
		this.VehicleList = null;
	}
	
	
	
	public JSONObject report() {
		
		JSONObject roadMap = new JSONObject();
		
		roadMap.put("junctions :" ,reportJunctions()); 
		roadMap.put("roads :",reportRoads());
		roadMap.put("vehicles :",reportVehicles());
		
		
		
		return roadMap;
		
	}
	
	
	public List<JSONObject> reportJunctions () {
		 List<JSONObject> jlist = new ArrayList<JSONObject>();
		 
		 for(int i =0 ; i < JunctionList.size();i++) {
			 jlist.add(this.JunctionList.get(i).report());
		 }
		
		return jlist; 
		
	}
	
	
	

	public List<JSONObject> reportRoads () {
		 List<JSONObject> jlist = new ArrayList<JSONObject>();
		 
		 for(int i =0 ; i < this.RoadList.size();i++) {
			 jlist.add(this.RoadList.get(i).report());
		 }
		
		return jlist; 
		
	}
	
	public List<JSONObject> reportVehicles () {
		 List<JSONObject> jlist = new ArrayList<JSONObject>();
		 
		 for(int i =0 ; i < this.VehicleList.size();i++) {
			 jlist.add(this.VehicleList.get(i).report());
		 }
		
		return jlist; 
		
	}
	


	
}
