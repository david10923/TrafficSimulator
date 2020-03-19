package simulator.model;
import java.util.ArrayList;

import simulator.model.Weather;

public class InterCityRoad extends Road{
	
	private final static int  SUNNY_TIME =2; 
	private final static int  CLOUDY_TIME =3;
	private final static int  RAINY_TIME=10;
	private final static int  WINDY_TIME =15;
	private final static int  STORM_TIME =20;
	private final static int OPERATION = 1000;
	
	private int contamination_limit;
	
	
	protected InterCityRoad(String id ,Junction srcJunc ,Junction destJunc ,int maxSpeed,int contLimit ,int length,Weather weather) throws Exception {
		super(id,srcJunc,destJunc,maxSpeed,contLimit,length,weather);
		
		this.Vehicles = new ArrayList<Vehicle>();
		this.Max_Speed = maxSpeed; 
		this.Length = length; 
		this.environmental_conditions = weather;
		this.Destination = destJunc; 
		this.Source= srcJunc; 
		this.Current_Max_Speed_limit = this.Max_Speed;
					
	}

	public void reduceTotalContamination() {
		
		switch(this.environmental_conditions) {
		case SUNNY: {
				this.Global_Pollution = ((InterCityRoad.OPERATION-InterCityRoad.SUNNY_TIME)/ InterCityRoad.OPERATION)*this.Global_Pollution;
			break; 
		}
		case CLOUDY:{
				this.Global_Pollution = ((InterCityRoad.OPERATION-InterCityRoad.CLOUDY_TIME)/ InterCityRoad.OPERATION)*this.Global_Pollution;
			break;
		}
		case RAINY:{
				this.Global_Pollution = ((InterCityRoad.OPERATION-InterCityRoad.RAINY_TIME)/ InterCityRoad.OPERATION)*this.Global_Pollution;
			break;
			
		}
		case WINDY :{
			this.Global_Pollution = ((InterCityRoad.OPERATION-InterCityRoad.WINDY_TIME)/ InterCityRoad.OPERATION)*this.Global_Pollution;
			break; 
			
		}
		case STORM:{
			this.Global_Pollution = ((InterCityRoad.OPERATION-InterCityRoad.STORM_TIME)/ InterCityRoad.OPERATION)*this.Global_Pollution;
			break;
		}
		
		}
	
		
	}
	
	public void updateSpeedLimit() {
		
		if(this.contamination_limit < this.Masive_Pollution) {
			this.Current_Max_Speed_limit = (int)(this.Max_Speed *0.5);
		}else
			this.Current_Max_Speed_limit = this.Max_Speed;
		
	}
	
	public int calculateVehicleSpeed(Vehicle v) {
		
		if(this.environmental_conditions== Weather.STORM ) {
			return (int)(this.Current_Max_Speed_limit*0.8);
		}else {
			return this.Current_Max_Speed_limit;
		}	
		
	}
	
	
	

}
