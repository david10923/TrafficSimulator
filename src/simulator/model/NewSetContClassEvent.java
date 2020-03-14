package simulator.model;

import java.util.List;

import simulator.misc.Pair;

public class NewSetContClassEvent extends Event{
	private int time; 
	private List<Pair<String,Integer>>cs;
	

	

	public NewSetContClassEvent(int time,List<Pair<String,Integer>> cs) throws Exception {
		super(time);
		
		if(cs == null) {
			throw new Exception("List is null");
		}
		else {
			this._time = time; 
			this.cs = cs;
		}
	}

	@Override
	void execute(RoadMap map) {
		String id;
		int j = 0;
		boolean ok = false;
		
		
		for(int i = 0;i< this.cs.size();i++) {
			
			id = this.cs.get(i).getFirst(); 
			
			while(j < map.getVehicleList().size()  && ok) {
				
				if(map.getVehicleList().get(j).getId().equals(id)) {
					ok = true;
					try {
						map.getVehicleList().get(j).setContaminationClass(this.cs.get(i).getSecond());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.getMessage();
					}
				}
			}
			
			
			
		}
		
	}
	
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public List<Pair<String, Integer>> getCs() {
		return cs;
	}

	public void setCs(List<Pair<String, Integer>> cs) {
		this.cs = cs;
	}
}
