package simulator.model;

import Exceptions.InvalidArgumentException;

public class NewInterCityRoadEvent extends NewRoadEvent {

	
	private int time; 
	private String id; 
	private String srcJunc; 
	private String destJunc; 
	private int length; 
	private int co2Limit;
	private int maxSpeed; 
	private Weather weather ;
	
	
	
	
	NewInterCityRoadEvent(int time ,String id,String srcJun ,String destJunc,int length,int co2Limit , int maxSpeed , Weather weather ) {
		super(time);
		this._time = time; 
		this.id = id; 
		this.srcJunc = srcJun; 
		this.destJunc = destJunc; 
		this.length = length; 
		this.co2Limit = co2Limit; 
		this.maxSpeed = maxSpeed; 
		this.weather = weather; 
		
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Road createRoadObject() {
		Road r;
		
		try {		 
			
			r = new InterCityRoad(this.id,this.srcJunc,this.destJunc,this.maxSpeed,this.co2Limit,this.length,this.weather);
		}
		 
		
	}

	@Override
	void execute(RoadMap map) {
		
		
	}
	

	
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSrcJunc() {
		return srcJunc;
	}

	public void setSrcJunc(String srcJunc) {
		this.srcJunc = srcJunc;
	}

	public String getDestJunc() {
		return destJunc;
	}

	public void setDestJunc(String destJunc) {
		this.destJunc = destJunc;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getCo2Limit() {
		return co2Limit;
	}

	public void setCo2Limit(int co2Limit) {
		this.co2Limit = co2Limit;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public Weather getWeather() {
		return weather;
	}

	public void setWeather(Weather weather) {
		this.weather = weather;
	}


}
