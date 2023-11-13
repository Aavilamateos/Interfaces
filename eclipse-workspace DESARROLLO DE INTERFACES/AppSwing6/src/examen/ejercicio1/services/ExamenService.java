package examen.ejercicio1.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import examen.ejercicio1.modelo.Coche;

public class ExamenService{


	/** Devuelve la lista de coches completa. 
	 * @return
	 */
	public List<Coche> consultarCoches(){
		List<Coche> coches = new ArrayList<Coche>();
		coches.addAll(bbdd.get(true));
		coches.addAll(bbdd.get(false));
		return coches;
	}
	
	
	
	/** Devuelve la lista de coches filtrando por disponibles sí o no. 
	 * @param disponibles
	 * @return
	 */
	public List<Coche> consultarCochesDisponibles(Boolean disponibles){
		return bbdd.get(disponibles);
	}
	
	

	
	/** Devuelve la lista de marcas. 
	 * @return
	 */
	public List<String> consultarMarcas(){
		return marcas;
	}

	
	/** Añade una marca a la lista. 
	 * @return
	 */
	public void añadirMarca(String marca){
		marcas.add(marca);
	}

	
	
	
	
	// Ignorar este código...
	private static Map<Boolean, List<Coche>> bbdd = new HashMap<Boolean, List<Coche>>();
	private static String[] a = new String[] {"Seat", "Toyota", "Renault"};
	private static List<String> marcas = Arrays.asList(a);
	static {
		List<Coche> cochesNoDisponibles = new ArrayList<Coche>();
		cochesNoDisponibles.add(new Coche("Seat", "Córdoba", "2005", "2521RFD", false));
		cochesNoDisponibles.add(new Coche("Toyota", "Yaris", "2012", "9661JKK", false));
		cochesNoDisponibles.add(new Coche("Toyota", "Auris", "2013", "4862DDD", false));
		cochesNoDisponibles.add(new Coche("Seat", "León", "2011", "0114BRT", false));
		cochesNoDisponibles.add(new Coche("Seat", "León", "2020", "9661JKK", false));
		cochesNoDisponibles.add(new Coche("Seat", "Ibiza", "2019", "4134BBV", false));
		cochesNoDisponibles.add(new Coche("Seat", "Ibiza", "2013", "4862DDD", false));
		cochesNoDisponibles.add(new Coche("Seat", "Ibiza", "2010", "4522RTD", false));
		cochesNoDisponibles.add(new Coche("Seat", "Córdoba", "2019", "8761DQT", false));
		cochesNoDisponibles.add(new Coche("Seat", "Toledo", "2020", "9661JKK", false));
		cochesNoDisponibles.add(new Coche("Seat", "Córdoba", "2011", "1521FFD", false));
		cochesNoDisponibles.add(new Coche("Seat", "Ibiza", "2013", "4862DDD", false));
		cochesNoDisponibles.add(new Coche("Renault", "Laguna", "2017", "5562CRT", false));
		cochesNoDisponibles.add(new Coche("Renault", "Megane", "2008", "1555FPD", false));
		cochesNoDisponibles.add(new Coche("Renault", "Megane", "2010", "9001VVF", false));
		
		List<Coche> cochesDisponibles = new ArrayList<Coche>();
		cochesDisponibles.add(new Coche("Toyota", "Auris", "2010", "1521FFD", true));
		cochesDisponibles.add(new Coche("Toyota", "Rav4", "2016", "4862BRT", true));
		cochesDisponibles.add(new Coche("Toyota", "Corolla", "2020", "8761DQT", true));
		cochesDisponibles.add(new Coche("Toyota", "Rav4", "2019", "4134NBV", true));
		cochesDisponibles.add(new Coche("Seat", "Ibiza", "2010", "4522RTD", true));
		cochesDisponibles.add(new Coche("Seat", "Clío", "2019", "8761DQT", true));
		cochesDisponibles.add(new Coche("Seat", "Córdoba", "2011", "1521FFD", true));
		cochesDisponibles.add(new Coche("Seat", "León", "2016", "4862BRT", true));
		cochesDisponibles.add(new Coche("Seat", "Toledo", "2005", "2521RFD", true));
		cochesDisponibles.add(new Coche("Seat", "Toledo", "2011", "0114BRT", true));
		cochesDisponibles.add(new Coche("Seat", "Ibiza", "2019", "4134BBV", true));
		cochesDisponibles.add(new Coche("Seat", "León", "2016", "4862BRT", true));
		cochesDisponibles.add(new Coche("Renault", "Clío", "2020", "8551CQC", true));
		cochesDisponibles.add(new Coche("Renault", "Megane", "2003", "4662RWD", true));
		cochesDisponibles.add(new Coche("Renault", "Clío", "2009", "0034BWW", true));
		
		bbdd.put(true, cochesDisponibles);
		bbdd.put(false, cochesNoDisponibles);
		
	}
	
	

	
}
