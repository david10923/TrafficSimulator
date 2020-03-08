package simulator.factories;

import org.json.JSONObject;

import simulator.model.DequeingStrategy;
import simulator.model.MoveAllStrategy;
import simulator.model.MoveFirstStrategy;

public class MoveAllStrategyBuilder extends Builder{	

	private static String type;

	MoveAllStrategyBuilder() {
		super(type);
		this._type ="most_all_dqs";
		// TODO Auto-generated constructor stub
	}

	@Override
	protected DequeingStrategy createTheInstance(JSONObject data) {
		
		DequeingStrategy mv = new MoveAllStrategy();
		
		return mv;
	}

}
