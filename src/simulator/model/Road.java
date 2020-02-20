package simulator.model;

import java.util.List;

import org.json.JSONObject;

import Exceptions.InvalidArgumentException;

public abstract class Road extends SimulatedObject {
	private int Length; 
	private Junction Destination; 
	private Junction Source;
	protected int Max_Speed; 
	protected int Current_Max_Speed_limit; 
	protected int Masive_Pollution;
	protected Weather environmental_conditions; 
	protected int Global_Pollution; 
	protected List<Vehicle> Vehicles; 
	
	
	
	
	 Road(String id ,Junction srcJunc ,Junction destJunc ,int maxSpeed,int contLimit ,int length,Weather weather)throws Exception {
		super(id);		
		
		if(maxSpeed <0 ) 
			throw new InvalidArgumentException("Incorrect road , the max speed is less than 0");
		
		else if(contLimit<0) {
			throw new InvalidArgumentException("Incorrect road ,the contLimit is negative");
		}
		else if(length<0) {
			throw new InvalidArgumentException("Incorrect road ,the contLimit is negative");
		}
		else if(srcJunc == null || destJunc == null || weather == null) {
			throw new InvalidArgumentException("Incorrect road ,the contLimit is negative");
		}
		else {
			this.Max_Speed = maxSpeed; 
			this.Length = length; 
			setWeather(weather);
			this.Destination = destJunc; 
			this.Source= srcJunc; 
			
		}
	}
			
		
		

	@Override
	void advance(int time) {
		
		//1
		reduceTotalContamination();
		//2
		updateSpeedLimit();
		//3
		for(Vehicle c : this.Vehicles) {
			c.Current_Speed = calculateVehicleSpeed();
			c.advance(time);		
		}
		
		
		this.Vehicles.sort(null); 
		
	}

	@Override
	public JSONObject report() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void enter(Vehicle v) throws Exception {
		
		if(v.Localization==0 &&v.Current_Speed ==0) {
			this.Vehicles.add(v);
		}
		else {
			throw new Exception("The localization or speed of the vehicle is not 0");
		}
			
	}
	
	public void exit(Vehicle v) {
		
		this.Vehicles.remove(this.Vehicles.indexOf(v));
	}
	
	public void setWeather(Weather w) {//pone que debe lanzar una excepcion pero ya se comprueba en el constructor
		this.environmental_conditions = w ; 
	}
	
	
	public void addContamination(int c){// el mismo caso que weather
		
		
	
		this.Global_Pollution += c ; 
		
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
