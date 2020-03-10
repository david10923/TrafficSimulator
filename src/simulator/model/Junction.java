package simulator.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import Exceptions.InvalidArgumentException;

public class Junction extends SimulatedObject {
	private int xCoor; 
	private int yCoor; 
	private  List<Road> IncomingRoadList;
	private Map<Junction,Road> OutgoingRoadList; 
	private List<List<Vehicle>> QueueList; 
	private int TrafficLight ; 
	private int Last_TrafficLight_change;
	private LightSwitchingStrategy Strategy_of_Change;
	private  DequeingStrategy Strategy_of_droping_vehicles;
	private Map<Road,List<Vehicle>> mapOfQueueRoad; 
	
	
	private final int ReedLight=-1;
	
	


	Junction(String id ,LightSwitchingStrategy isStratregy ,DequeingStrategy dqStrategy,int xCoor,int yCoor) throws InvalidArgumentException{
		super(id);
		
		
		if(isStratregy ==null || dqStrategy == null )	
			throw new InvalidArgumentException("There are some null atributes while creating the juction");	
		
		else if(xCoor < 0 || yCoor <0 ) {
			throw new InvalidArgumentException("There are some negatives values while creating");
		}
		else {

			this.setyCoor(xCoor);
			this.setyCoor(yCoor); 
			
			this.OutgoingRoadList = new HashMap<Junction,Road>();
			//this.QueueList = new LinkedList<List<Vehicle>>();
			
			//this.mapOfQueueRoad= new HashMap<Road,List<Vehicle>>();
			
		}
			
		
	}
	
	

	@Override
	void advance(int time) {
		int index;
		
		/*
		index = this.Strategy_of_Change.chooseNextGreen(this.IncomingRoadList, this.QueueList, this.TrafficLight, 
				this.Last_TrafficLight_change, time);		
		*/
		
		if(this.TrafficLight ==-1) {
			List<Vehicle> q = this.QueueList.get(this.TrafficLight); 	
			List<Vehicle> list = new ArrayList<Vehicle>();
			
			list = this.Strategy_of_droping_vehicles.dequeue(q);
			for(int i = 0;i < list.size();i++) {
				try {
					list.get(i).moveToNextRoad();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				q.remove(list.get(i));
				
			}
		}
		
		int nextGreen = this.Strategy_of_Change.chooseNextGreen(this.IncomingRoadList, this.QueueList,
				this.TrafficLight, this.Last_TrafficLight_change, time);
		
		
		
	
		
	}

	@Override
	public JSONObject report() {
	

		JSONObject Junction = new JSONObject();
		
		
		Junction.put("id", this._id);
		
		if(this.TrafficLight == this.ReedLight) {
			Junction.put("green", "none");
		}else {
			Junction.put("green", this.TrafficLight);
		}
		
		Junction.put("queues", this);
		
		
		//reportRoad();
		//reportVehicles();
		
		return Junction;
	}
	
	
	
	 void addIncomingRoad(Road r) throws Exception {
		int indexOfTheRoad; 	
		
		
		if(r.getDestination() != this) {		
			throw  new Exception("The road that you specified is not an incoming road");
		}
		else {

			this.IncomingRoadList.add(r); 
			
			this.QueueList = new LinkedList<List<Vehicle>>();	
			
			this.mapOfQueueRoad= new HashMap<Road,List<Vehicle>>();
			
			indexOfTheRoad = this.IncomingRoadList.indexOf(r);
			
			this.QueueList.add(indexOfTheRoad, this.IncomingRoadList.get(indexOfTheRoad).Vehicles);
			
			this.mapOfQueueRoad.put(r, this.IncomingRoadList.get(indexOfTheRoad).Vehicles);
					
			
		}
	
		
	}
	
	 void addOutgoingRoad(Road r) throws Exception {
		
		if((this.OutgoingRoadList.containsKey(this)) || (r.getSource() != this )) { // si alguna carretera va al cruce  o r es un cruce entrante
			throw new Exception("The road can not be a OutgoingRoad");		
		}
		else {
			this.OutgoingRoadList.put(this,r);	
			
		}
		
		
	}					
	
	public void enter(Vehicle v,Road r) {
		
		try {
			r.enter(v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		List<Vehicle> lista;
		int i=0;
		boolean ok = false;
		
		lista = this.mapOfQueueRoad.get(r);
		
		while(i < this.QueueList.size() && ok) {
			if(lista.equals(this.QueueList.get(i))) {
				ok = true;
			}
		}		
		
		this.QueueList.add(i, lista);	
		
		this.mapOfQueueRoad.get(r).add(v);
		*/
		
	}
	
	public Road roadTo(Junction j) {
		
		return this.OutgoingRoadList.get(j);	
		
	}



	public int getyCoor() {
		
		return yCoor;
	}
	
	



	public void setyCoor(int yCoor) {
		this.yCoor = yCoor;
	}



	public int setxCoor() {
		return xCoor;
	}



	public void setxCoor(int xCoor) {
		this.xCoor = xCoor;
	}



	public List<Road> getIncomingRoadList() {
		return IncomingRoadList;
	}



	public void setRoadList(List<Road> roadList) {
		IncomingRoadList = roadList;
	}



	public Map<Junction,Road> getOutgoingRoadList() {
		return OutgoingRoadList;
	}



	public void setOutgoingRoadList(Map<Junction,Road> outgoingRoadList) {
		OutgoingRoadList = outgoingRoadList;
	}



	public List<List<Vehicle>> getQueueList() {
		return QueueList;
	}



	public void setQueueList(List<List<Vehicle>> queueList) {
		QueueList = queueList;
	}



	public int getTrafficLight() {
		return TrafficLight;
	}



	public void setTrafficLight(int trafficLight) {
		TrafficLight = trafficLight;
	}



	public int getLast_TrafficLight_change() {
		return Last_TrafficLight_change;
	}



	public void setLast_TrafficLight_change(int last_TrafficLight_change) {
		Last_TrafficLight_change = last_TrafficLight_change;
	}



	public LightSwitchingStrategy getStrategy_of_Change() {
		return Strategy_of_Change;
	}



	public void setStrategy_of_Change(LightSwitchingStrategy strategy_of_Change) {
		Strategy_of_Change = strategy_of_Change;
	}



	public DequeingStrategy getStrategy_of_droping_vehicles() {
		return Strategy_of_droping_vehicles;
	}



	public void setStrategy_of_droping_vehicles(DequeingStrategy strategy_of_droping_vehicles) {
		Strategy_of_droping_vehicles = strategy_of_droping_vehicles;
	}
	
	
	
	
	public Map<Road, List<Vehicle>> getMapOfQueueRoad() {
		return mapOfQueueRoad;
	}



	public void setMapOfQueueRoad(Map<Road, List<Vehicle>> mapOfQueueRoad) {
		this.mapOfQueueRoad = mapOfQueueRoad;
	}


	
	
	/*
	public Road getValue(Junction j) {
		return this.OutgoingRoadList.get(j);
	}
	*/
	
	
	public List<JSONObject> reportRoads () {
		 List<JSONObject> jlist = new ArrayList<JSONObject>();
		 
		 for(int i =0 ; i < this.IncomingRoadList.size();i++) {
			 jlist.add(this.IncomingRoadList.get(i).report());
		 }
		
		return jlist; 
		
	}
	
	public List<JSONObject> reportVehicles (Road r) {
		 List<JSONObject> jlist = new ArrayList<JSONObject>();
		 
		 for(int i =0 ; i < this.QueueList.size();i++) {
			 jlist.add(this.mapOfQueueRoad.get(r).get(i).report());
		 }
		
		return jlist; 
		
	}
	
	
	
}

