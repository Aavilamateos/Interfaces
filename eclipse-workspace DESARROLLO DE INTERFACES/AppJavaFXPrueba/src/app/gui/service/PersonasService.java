package app.gui.service;

import java.util.ArrayList;
import java.util.List;

import app.gui.modelo.Persona;

public class PersonasService {

	public List<Persona>getPersonas(){
		List<Persona>personas=new ArrayList<Persona>();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 5; i++) {
			Persona p=new Persona();
			p.setDni("10000000"+i);
			p.setNombre("Persona"+i);
			p.setEdad(20+i);
			personas.add(p);
		}
		return personas;
	}
}
