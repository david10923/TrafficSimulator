package simulator.model;
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
		//if(this.Max_Speed > this.Global_Pollution) {
			
		//}
		
	}
	
	public int calculateVehicleSpeed(Vehicle v) {
		
		if(this.environmental_conditions== Weather.STORM ) {
			return (int)((int)this.Max_Speed*0.8);
		}else {
			return v.Current_Speed = this.Max_Speed;
		}	
		
	}
	
	
	

}
