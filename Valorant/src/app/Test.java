package app;

import java.util.ArrayList;
import java.util.List;

import app.exception.EquipoException;
import app.exception.EquipoNotFoundException;
import app.modelo.Equipo;
import app.modelo.Jugador;
import app.service.JugadorEquipoService;

public class Test {

	public static void main(String[] args) {
		JugadorEquipoService service = new JugadorEquipoService();

		
		try {
			Equipo e= new Equipo();
			e.setEquipoTag("#e");
			e.setNombre("e");
			List<Jugador>lista=new ArrayList<Jugador>();
			Jugador j= service.consultarJugador("a");
			Jugador j1=service.consultarJugador("carlitos");
			lista.add(j);
			lista.add(j1);
			e.setListaJugadores(lista);
			service.insertarEquipo(e);
			System.out.println(service.consultarJugadoresEquipo(e));
		} catch (EquipoNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EquipoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

}
