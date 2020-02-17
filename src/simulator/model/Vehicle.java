package simulator.model;


import java.util.List;

import org.json.JSONObject;


import Exceptions.InvalidArgumentException;

import java.math.*;

public class Vehicle extends SimulatedObject{
	
	private List<Junction> Itinerary; 
	protected int Max_Speed; 
	protected int Current_Speed;
	private VehicleStatus Status;
	private Road Road; 
	protected int Localization;
	protected int Degree_of_Pollution; //contaminacion del vehiculo en cada paso de la simulacion
	protected int Pollution; // durante todo el recorrido 
	protected int Global_distance_traveled;
	
	protected int Last_Junction_index;
	protected int ancientLocalization;
	private static int number = 10 ;
	
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
			this.Itinerary = itinerary;
			
			setContaminationClass(contClass);
			this.Last_Junction_index=0;
			
		}
	}

	@Override
	public void advance(int time) {
		int Posible_Pollution = 0;
		if(Status == VehicleStatus.TRAVELING) {// Donde inicializar la localizacion		
			//a
			this.Localization = Math.min(this.Localization+this.Current_Speed, this.Road.getLength());
			//b
			this.Degree_of_Pollution= ((this.Localization-this.ancientLocalization)*this.Pollution/number);
			
			this.Pollution+= this.Degree_of_Pollution;
			
			this.Road.addContamination(this.Degree_of_Pollution);
			//c 
			if(this.Localization == this.Road.getLength()) {
				// entrar en la cola del metodo correspodiente del cruce
				this.Itinerary.add(this.Road.getDestination());
				
			}
			
		}
		
		
	}

	@Override
	public JSONObject report() {
		
		return null;
	}
	
	
	protected void setSpeed (int s) throws Exception {		
		if(s <0 ) {
			throw new InvalidArgumentException("Incorrect,the Speed is negative");
		}
		else {
			this.Current_Speed = Math.min(s, this.Max_Speed);
		}
	}
	
	protected void setContaminationClass(int c) throws Exception{
		if(c<0 || c >10) {
			throw new InvalidArgumentException("Incorrect contClass value");	
			
		}else {
			this.Degree_of_Pollution = c;
		}
		
	}
	
	protected void moveToNextRoad() {
		Junction j;
		
		this.Road.exit(this);
		
		if(this.Status == Status.PENDING) {
			
		}else {
			j = this.Itinerary.get(this.Localization);
			
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
	
	
	
	
	
	
	
	

}
