package simulator.model;

public abstract class NewRoadEvent extends Event {
	
	NewRoadEvent(int time) {
		super(time);
		// TODO Auto-generated constructor stub
	}
	

	
	
	
	public abstract Road createRoadObject();

}
