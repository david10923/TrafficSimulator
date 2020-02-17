package simulator.model;

public class NewJunctionEvent extends Event {

	public NewJunctionEvent(int time,String id , LightSwitchingStrategy lsStrategy ,DequeingStrategy dqStrategy, int xCoor , int yCoor) {
		super(time);
		
	}

	@Override
	void execute(RoadMap map) {
		// TODO Auto-generated method stub
		
	}

}
