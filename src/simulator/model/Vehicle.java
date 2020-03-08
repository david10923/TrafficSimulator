package simulator.model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.json.JSONObject;


import Exceptions.InvalidArgumentException;

import java.math.*;

public class Vehicle extends SimulatedObject implements Comparable<Vehicle> {
	
	private List<Junction> Itinerary; 
	private  int Max_Speed; 
	private int Current_Speed;
	private VehicleStatus Status;
	private Road Road; 
	private  int Localization;
	private int Degree_of_Pollution; //contaminacion del vehiculo en cada paso de la simulacion
	private int Pollution; // durante todo el recorrido 
	private int Global_distance_traveled;	
	
	private int Last_Junction_index;	 
	private int ancientLocalization;
	private static int number = 10 ;
	
	
	
	
	
	public int getDegree_of_Pollution() {
		return Degree_of_Pollution;
	}


	public void setDegree_of_Pollution(int degree_of_Pollution) {
		Degree_of_Pollution = degree_of_Pollution;
	}


	public int getPollution() {
		return Pollution;
	}


	public void setPollution(int pollution) {
		Pollution = pollution;
	}


	public int getGlobal_distance_traveled() {
		return Global_distance_traveled;
	}


	public void setGlobal_distance_traveled(int global_distance_traveled) {
		Global_distance_traveled = global_distance_traveled;
	}


	public int getLast_Junction_index() {
		return Last_Junction_index;
	}


	public void setLast_Junction_index(int last_Junction_index) {
		Last_Junction_index = last_Junction_index;
	}


	public int getAncientLocalization() {
		return ancientLocalization;
	}


	public void setAncientLocalization(int ancientLocalization) {
		this.ancientLocalization = ancientLocalization;
	}


	
	//¿Hay que añadir el grado de contaminacion??
	
	
	
	protected Vehicle(String id,int maxSpeed ,int contClass,List<Junction> itinerary) throws Exception{
		super(id);
		
		if(maxSpeed < 0 ) {
			throw new InvalidArgumentException("Incorrect speed,Max Speed of the vehicle is less than 0");
		}
		else if(itinerary.size()<2) {
			throw new InvalidArgumentException("Incorrect , the cont of the list is less than 2");
		}
		else {
			this._id = id; 
			this.Max_Speed = maxSpeed;
			this.Itinerary = Collections.unmodifiableList(new ArrayList<>(itinerary));
			
		
			
			setContaminationClass(contClass);
			this.Last_Junction_index=0;
			this.Status= this.Status.PENDING;
			
		}
	}

	
	public int getMax_Speed() {
		return Max_Speed;
	}

	public void setMax_Speed(int max_Speed) {
		Max_Speed = max_Speed;
	}

	public int getCurrent_Speed() {
		return Current_Speed;
	}

	public void setCurrent_Speed(int current_Speed) {
		Current_Speed = current_Speed;
	}

	public int getLocalization() {
		return Localization;
	}

	public void setLocalization(int localization) {
		Localization = localization;
	}

	 
	
	
	

	@Override
	public void advance(int time)  {
		int Posible_Pollution = 0;
		
		if(Status == VehicleStatus.TRAVELING) {// Donde inicializar la localizacion		
			//a
			this.Localization = Math.min(this.Localization+this.Current_Speed, this.Road.getLength());
			//b
			this.Degree_of_Pollution= ((this.Localization-this.ancientLocalization)*this.Pollution/number);
			
			this.Pollution+= this.Degree_of_Pollution;
			
			try {
				this.Road.addContamination(this.Degree_of_Pollution);
			} catch (InvalidArgumentException e) {
				e.toString();
			}
			//c 
			if(this.Localization == this.Road.getLength()) {
				
				this.Itinerary.get(this.Last_Junction_index).enter(this, this.Road);
				this.Status = Status.WAITING;
				
				
				
		//	junction.getOutgoingRoadList();
		//	this.Road = junction.getValue(this.junction);
				
			}
			
		}
		
		
	}

	@Override
	public JSONObject report() {
		
		JSONObject vehicle = new JSONObject();
		
		
		vehicle.put("id", this._id);
		vehicle.put("speed", this.Current_Speed);
		vehicle.put("distance", this.Global_distance_traveled);
		vehicle.put("co2",this.Degree_of_Pollution);
		vehicle.put("class",this.Status);
		if(this.Status==VehicleStatus.TRAVELING || this.Status == VehicleStatus.WAITING ) {
			vehicle.put("road", this.Road);	
			vehicle.put("location",this.Localization);			
		}
		
		return vehicle;
	}
	
	
	 void setSpeed (int s) throws Exception {		
		if(s <0 ) {
			throw new InvalidArgumentException("Incorrect,the Speed is negative");
		}
		else {
			this.Current_Speed = Math.min(s, this.Max_Speed);
		}
	}
	
	 void setContaminationClass(int c) throws Exception{
		if(c<0 || c >10) {
			throw new InvalidArgumentException("Incorrect contClass value");	
			
		}else {
			this.Degree_of_Pollution = c;
		}
		
	}
	
	 void moveToNextRoad() throws Exception {
		Junction actualJunc , nextJunc;
		
		
		
		this.Road.exit(this);
		
		if(this.Status == Status.PENDING) { 
			
			actualJunc = this.Itinerary.get(this.Last_Junction_index);
			
			nextJunc=this.Itinerary.get(this.Last_Junction_index +1); 
			
			actualJunc.roadTo(nextJunc);
			
		}else {	
			
			actualJunc= this.Itinerary.get(this.Last_Junction_index); 
			
			nextJunc=this.Itinerary.get(this.Last_Junction_index +1); 
			
			this.Road=actualJunc.roadTo(nextJunc);	

			
			this.Road.enter(this);
			// falta ponerle en la localizacion 0 
			
		
		}
		
		
	}

	public List<Junction> getItinerary() {
		return Itinerary;
	}

	public void setItinerary(List<Junction> itinerary) {
		Itinerary = itinerary;
	}
	

	

	public Road getRoad() {
		return Road;
	}

	public void setRoad(Road road) {
		Road = road;
	}

	public VehicleStatus getStatus() {
		return Status;
	}

	public void setStatus(VehicleStatus status) {
		Status = status;
	}

	@Override
	public int compareTo(Vehicle o) {
		return Integer.valueOf(this.Localization).compareTo(o.getLocalization());
	}

	
	
	
	boolean recorreItinerario (Vehicle v) {
		boolean ok = true; 
		
		for (Junction junction : Itinerary) {
			if(junction.getOutgoingRoadList().isEmpty())
				ok = false; 
			}
		
		return ok; 
			
		}
	
	
	
	
	
	

}
