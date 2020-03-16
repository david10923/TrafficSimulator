package simulator.model;

public enum Weather {
	SUNNY, CLOUDY, RAINY, WINDY, STORM;



	public static Weather getWeather(String weather) {
		
		if(weather == "SUNNY") {
			return SUNNY;
		}
		else if (weather == "CLOUDY") {
			return CLOUDY;
		}else if (weather == "RAINY") {
			return RAINY;
		}else if (weather == "WINDY") {
			return WINDY;
		}else {
			return STORM; 
		}
	}
}