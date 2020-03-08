package simulator.factories;

import simulator.model.Event;

public class NewCityRoadEventBuilder  extends NewRoadEventBuilder{

	private static String type;

	NewCityRoadEventBuilder() {
		super(type);
		this._type = "new_city_road";
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Event createTheRoad() {
		Event e = new CityRoadEvent();
	}

}
