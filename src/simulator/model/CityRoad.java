package simulator.model;
import simulator.model.Weather;

public class CityRoad extends Road{
	
	private static final int WINDY_STORM_POLLUTION = 10;
	private static final int OTHER_POLLUTION = 2;
	private static final double auxiliar = 11.0;


	protected CityRoad(String id, Junction srcJunc, Junction destJunc, int maxSpeed, int contLimit, int length, Weather weather) throws Exception {
		super(id, srcJunc, destJunc, maxSpeed, contLimit, length, weather);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void reduceTotalContamination() {
		if(this.environmental_conditions == Weather.WINDY || this.environmental_conditions == Weather.STORM ) {
			this.Global_Pollution-= CityRoad.WINDY_STORM_POLLUTION;
		}
		else {
			this.Global_Pollution-= CityRoad.OTHER_POLLUTION;
		}
	}

	@Override
	protected void updateSpeedLimit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected int calculateVehicleSpeed(Vehicle v) {
		
		return (int) (((CityRoad.auxiliar-v.Pollution)/CityRoad.auxiliar)*this.Current_Max_Speed_limit);
		
	}

}
