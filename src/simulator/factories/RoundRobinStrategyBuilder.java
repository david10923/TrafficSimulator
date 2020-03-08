
package simulator.factories;

import org.json.JSONObject;

import simulator.model.LightSwitchingStrategy;
import simulator.model.RoundRobinStrategy;

public class RoundRobinStrategyBuilder extends Builder<LightSwitchingStrategy> {

	private static String type;
	private final int ONE = 1;

	RoundRobinStrategyBuilder() {
		super(type);
		this.type = "round_robin_lss";
	}

	@Override
	protected LightSwitchingStrategy createTheInstance(JSONObject data) {
		
	
		if(data.has("timeslot")) 
			data.put("timeslot", data.getInt("timeslot"));		
		else 
			data.put("timeslot",ONE);
		
		
		LightSwitchingStrategy rr = new RoundRobinStrategy(data.getInt("timeslot"));
		
		
		return rr;
	}

}
