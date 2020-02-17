package simulator.model;

public class CityRoad extends Road{

	protected CityRoad(String id, Junction srcJunc, Junction destJunc, int maxSpeed, int contLimit, int length) {
		super(id, srcJunc, destJunc, maxSpeed, contLimit, length);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void reduceTotalContamination() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateSpeedLimit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected int calculateVehicleSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

}
