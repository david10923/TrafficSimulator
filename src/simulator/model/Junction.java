package simulator.model;

import org.json.JSONObject;

public class Junction extends SimulatedObject {
	private int xCoor; 
	private int yCoor; 
	
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
	
	public void enter(Vehicle v) {
		
	}
	
	public Road roadTo(Junction j) {
		return null;
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
	
	
}

