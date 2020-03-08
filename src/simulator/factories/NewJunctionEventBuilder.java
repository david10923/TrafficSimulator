package simulator.factories;

import org.json.JSONObject;

import simulator.model.DequeingStrategy;
import simulator.model.Event;
import simulator.model.LightSwitchingStrategy;
import simulator.model.NewJunctionEvent;

public class NewJunctionEventBuilder extends Builder<Event>{
	private static String type;
	private final int CERO = 1; 
	private final int ONE = 1;
	private Factory<LightSwitchingStrategy> lssFactory; 
	private Factory<DequeingStrategy> dqsFactory;
	

	NewJunctionEventBuilder(Factory<LightSwitchingStrategy> lssFactory ,Factory<DequeingStrategy> dqsFactory) {
		super(type);
		this._type = "new_junction";
		this.lssFactory = lssFactory; 
		this.dqsFactory = dqsFactory;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Event createTheInstance(JSONObject data) {
			
		Event e = new NewJunctionEvent(data.getInt("time"),data.getString("id"),
			this.lssFactory.createInstance(data.getJSONObject("ls_strategy")), this.dqsFactory.createInstance(data.getJSONObject("dq_strategy")),
				data.getJSONArray("coor").getInt(CERO), data.getJSONArray("coor").getInt(ONE));
		
		
		return e;
	}

}
