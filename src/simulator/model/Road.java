package simulator.model;

import java.util.List;

import org.json.JSONObject;

public abstract class Road extends SimulatedObject {
	private int Length; 
	private Junction Destination; 
	private Junction Source;
	protected int Max_Speed; 
	protected int Max_Speed_limit; 
	protected int Masive_Pollution;
	protected Weather environmental_conditions; 
	protected int Global_Pollution; 
	protected List<Vehicle> Vehicles; 
	
	
	
	
	protected Road(String id ,Junction srcJunc ,Junction destJunc ,int maxSpeed,int contLimit ,int length) {
		super(id);
		
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
	
	public void enter(Vehicle v) {
		
	}
	
	public void exit(Vehicle v) {
		
	}
	
	public void setWeather(Weather w) {
		
	}
	
	public void addContamination(int c){
		
	}
	
	
	
	public int getLength() {
		return Length;
	}

	public void setLength(int length) {
		Length = length;
	}

	public Junction getDestination() {
		return Destination;
	}

	public void setDestination(Junction destination) {
		Destination = destination;
	}

	public Junction getSource() {
		return Source;
	}

	public void setSource(Junction source) {
		Source = source;
	}
	
	protected abstract void reduceTotalContamination() ;
	protected abstract void updateSpeedLimit(); 
	protected abstract int calculateVehicleSpeed();
	

}
