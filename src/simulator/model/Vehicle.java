package simulator.model;


import java.util.ArrayList;
import java.util.Collections;
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
	private Junction junction;// no hace falta ya que la carretera tiene de donde viene 
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
			this.Itinerary = Collections.unmodifiableList(new ArrayList<>(itinerary));
			
		
			
			setContaminationClass(contClass);
			this.Last_Junction_index=0;
			this.Status= this.Status.PENDING;
			
		}
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
				// entrar en la cola del metodo correspodiente del cruce
				
			junction.getOutgoingRoadList();
				
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
		Junction actualJunc , nextJunc;
		
		// en principio empiezas en un cruce 
		
		this.Road.exit(this);
		
		if(this.Status == Status.PENDING) {
			
		}else {
			
			actualJunc =this.Road.getDestination();// cruce destino de la carretera
			
			this.Last_Junction_index++;
			nextJunc=this.Itinerary.get(this.Last_Junction_index); //el siguiente cruce
			
			
			
			//carretera que une los dos cruces
			
		
		
		
		//this.Road.enter(this);
		
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

	public Junction getJunction() {
		return junction;
	}

	public void setJunction(Junction junction) {
		this.junction = junction;
	}
	
	
	
	
	
	
	
	

}
