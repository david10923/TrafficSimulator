package simulator.model;

public class InterCityRoad extends Road{
	
	
	protected InterCityRoad(String id ,Junction srcJunc ,Junction destJunc ,int maxSpeed,int contLimit ,int length,Weather weather) {
		super(id,srcJunc,destJunc,maxSpeed,contLimit,length);
	}

	protected void reduceTotalContamination() {
		
	}
	
	protected void updateSpeedLimit() {
		
	}
	
	protected int calculateVehicleSpeed() {
		return 0;
	}
	
	
	

}
