package simulator.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import Exceptions.InvalidArgumentException;

public class test {
	
	private static void prueba1() throws Exception {
		// Mis pruebas
			
		// Creo cruces
		MostCrowdedStrategy estrategiaSem = new MostCrowdedStrategy(5);
		MoveAllStrategy     estrategiaDequeue = new MoveAllStrategy();
		
		
			Junction j1 = new Junction("j1", estrategiaSem, estrategiaDequeue, 20, 50);
			Junction j2 = new Junction("j2", estrategiaSem, estrategiaDequeue, 20, 50);
			Junction j3 = new Junction("j3", estrategiaSem, estrategiaDequeue, 20, 50);
			Junction j4 = new Junction("j4", estrategiaSem, estrategiaDequeue, 20, 50);
			Junction j5 = new Junction("j5", estrategiaSem, estrategiaDequeue, 20, 50);
		
		
			Road r1 = new CityRoad("r1", j1, j4, 120, 500, 10000, Weather.SUNNY);
			Road r2 = new CityRoad("r2", j2, j4, 120, 500, 10000, Weather.SUNNY);
			Road r3 = new CityRoad("r3", j3, j4, 120, 500, 10000, Weather.SUNNY);
			Road r4 = new CityRoad("r4", j4, j5, 120, 500, 10000, Weather.SUNNY);
		
			
		// Establezco conexiones
		j1.addOutgoingRoad(r1);
		j2.addOutgoingRoad(r2);
		j3.addOutgoingRoad(r3);
		j4.addOutgoingRoad(r4);
		j4.addIncomingRoad(r1); j4.addIncomingRoad(r2); j4.addIncomingRoad(r3);
		j5.addIncomingRoad(r4);
		System.out.println(j1.report());
			
		// Establezco itinerarios
		List<Junction> itinerario = new ArrayList<Junction>();
		itinerario.add(j1); itinerario.add(j4); itinerario.add(j5);
		Vehicle v1 = new Vehicle("v1",  80, 3, itinerario);
		Vehicle v2 = new Vehicle("v2", 100, 5, itinerario);
		System.out.println(v1.report());
		System.out.println(v2.report());
		
		itinerario.clear(); itinerario.add(j2); itinerario.add(j4); itinerario.add(j5);
		Vehicle v3 = new Vehicle("v3",  80, 3, itinerario);
		Vehicle v4 = new Vehicle("v4", 100, 5, itinerario);
		Vehicle v5 = new Vehicle("v5",  80, 3, itinerario);
		
		System.out.println(v3.report());
		System.out.println(v4.report());
		System.out.println(v5.report());
		
		itinerario.clear(); itinerario.add(j3); itinerario.add(j4); itinerario.add(j5);
		Vehicle v6 = new Vehicle("v6", 100, 5, itinerario);
		System.out.println(v6.report());
		
		System.out.println("HE ESTABLECIDO BIEN LOS ITTINERARIOS");
					
		// Meto a los vehiculos en sus carreteras
		v1.moveToNextRoad(); System.out.println(v1.report());
		v2.moveToNextRoad(); System.out.println(v2.report());
		v3.moveToNextRoad(); System.out.println(v3.report());
		v4.moveToNextRoad(); System.out.println(v4.report());
		v5.moveToNextRoad(); System.out.println(v5.report());
		v6.moveToNextRoad(); System.out.println(v6.report());
		
		// Les actualizo la velocidad => Hay que ver d�nde se hace �sto
		v1.setSpeed(80); v2.setSpeed(100);
		v3.setSpeed(80); v4.setSpeed(90); v5.setSpeed(100);
		v6.setSpeed(120);
		System.out.println(r1.report());
		System.out.println(r2.report());
		System.out.println(r3.report());
		
		System.out.println("LAS CARRETERAS ESTAN CORRECTAS");
		
		// Hago avanzar en r1 y veo que v2 adelanta a v1
		r1.advance(0);
		System.out.println(v1.report());
		System.out.println(v2.report());
		System.out.println(r1.report());
					
		// Pruebo MostCrowdedStrategy
		List<Vehicle> qr1 = new ArrayList<Vehicle>();
		List<Vehicle> qr2 = new ArrayList<Vehicle>();
		List<Vehicle> qr3 = new ArrayList<Vehicle>();
		List<List<Vehicle>> qs = new ArrayList<List<Vehicle>>();
		List<Road> listRoads = new ArrayList<Road>();
		
		qr1.add(v1); qr1.add(v2);
		qr2.add(v3); qr2.add(v4); qr2.add(v5);
		qr3.add(v6);
		
		qs.add(qr1); qs.add(qr2); qs.add(qr3);
		
		System.out.println("HE AÑADIDO BIEN LAS COLAS");
		
		listRoads.add(r1); listRoads.add(r2); listRoads.add(r3);
		
		System.out.println("Cola mayor caso 1 = "
		                    + estrategiaSem.chooseNextGreen(listRoads, qs, -1, 100, 101));
		
	
		System.out.println("Cola mayor caso 2 = "
		           			+ estrategiaSem.chooseNextGreen(listRoads, qs, -1, 100, 101));
		System.out.println("Cola mayor caso 3 = "
							+ estrategiaSem.chooseNextGreen(listRoads, qs,  2, 100, 101));
		System.out.println("Cola mayor caso 4 = "
		          			+ estrategiaSem.chooseNextGreen(listRoads, qs,  2, 100, 110));
		
		
		System.out.println(r1.report());
		System.out.println(r2.report());
		System.out.println(r3.report());
		System.out.println(r4.report());
		System.out.println(v1.report());
		System.out.println(v2.report());
		System.out.println(v3.report());
		System.out.println(v4.report());
		System.out.println(v5.report());
		System.out.println(v6.report());
		
		
		v1.setSpeed(0);
		v1.setLocalization(0);
	
		v2.setLocalization(0);
		v2.setSpeed(0);
		v3.setLocalization(0);
		v3.setSpeed(0);
		v4.setLocalization(0);
		v4.setSpeed(0);
		v5.setLocalization(0);
		v5.setSpeed(0);
		v6.setLocalization(0);
		v6.setSpeed(0);
	
		
		System.out.println(j4.report());
		// Pruebo a meter en cruce y ver si imprime bien las colas
		
	System.out.println("report hecho ");
		j4.enter(v1);
		
		System.out.println(j4.report());
		
		j4.enter(v2);
		
		System.out.println(j4.report());
		j4.enter(v6);
		System.out.println(j4.report());
		
		j4.enter(v4); j4.enter(v5); j4.enter(v3);
		System.out.println(j4.report());
		
		System.out.println("HE AÑADIDO TODOS LOS VEHICULOS AL J4");
		
		System.out.println(j4.report());
		
		
		// Prueba a construir e imprimir el mapa de carreteras
		RoadMap miMapa = new RoadMap();
		miMapa.addJunction(j1); miMapa.addJunction(j2); miMapa.addJunction(j3);
		miMapa.addJunction(j4); miMapa.addJunction(j5);
		
		miMapa.addRoad(r1);     miMapa.addRoad(r2);
		miMapa.addRoad(r3);     miMapa.addRoad(r4);
		
		//System.out.println(r1.report());
		
		miMapa.addVehicle(v1);  miMapa.addVehicle(v2);  miMapa.addVehicle(v3);
		miMapa.addVehicle(v4);  miMapa.addVehicle(v5);  miMapa.addVehicle(v6);
		
		System.out.println(miMapa.report());
	}

	private static void start(String[] args) throws Exception {
		
		prueba1();
	}

	public static void main(String[] args) {
		try {
			start(args);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

}
