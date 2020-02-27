package simulator.model;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

public class Junction extends SimulatedObject {
	private int xCoor; 
	private int yCoor; 
	private  List<Road> RoadList;
	private Map<Junction,Road> OutgoingRoadList; 
	private List<List<Vehicle>> QueueList; 
	private int TrafficLight ; 
	private int Last_TrafficLight_change;
	private LightSwitchingStrategy Strategy_of_Change;
	private  DequeingStrategy Strategy_of_droping_vehicles;
	
	
	
	
	Junction(String id ,LightSwitchingStrategy isStratregy ,DequeingStrategy dqStrategy,int xCoor,int yCoor){
		super(id);
		this.setyCoor(xCoor);
		this.setyCoor(yCoor); 
	}
	
	

	@Override
	void advance(int time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public JSONObject report() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void addIncomingRoad(Road r) {
		
	}
	
	public void addOutgoingRoad(Road r) {
		
	}
	
	public void enter(Vehicle v,Road r) {
		
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



	public List<Road> getRoadList() {
		return RoadList;
	}



	public void setRoadList(List<Road> roadList) {
		RoadList = roadList;
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
	
	/*
	public Road getValue(Junction j) {
		return this.OutgoingRoadList.get(j);
	}
	*/
	
	
}

