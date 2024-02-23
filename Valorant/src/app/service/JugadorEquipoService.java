package app.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;

import app.exception.EquipoException;
import app.exception.EquipoNotFoundException;
import app.exception.JugadorException;
import app.exception.JugadorNotFoundException;
import app.exception.PersonajeNotFoundException;
import app.modelo.Equipo;
import app.modelo.Jugador;
import app.modelo.Personaje;
import app.mongoDB.MongoSession;

public class JugadorEquipoService {

	
	//LOGIN
	//USO
	public Boolean login(String userName, String pass) throws JugadorNotFoundException {
		String encriptada=DigestUtils.sha256Hex(pass);
			MongoDatabase db=MongoSession.getDatabase();
			MongoCollection<Jugador>c=db.getCollection("jugadores", Jugador.class);
			Bson filter=Filters.or(Filters.eq("userName",userName),Filters.eq("contraseña", pass));
			FindIterable<Jugador>result=c.find(filter);
			MongoCursor<Jugador>cursor=result.cursor();
			while (cursor.hasNext()) {
				Jugador j=cursor.next();
				if (j.getUserName().equals(userName) && j.getContraseña().equals(encriptada)) {
					return true;
				}
			}
			throw new JugadorNotFoundException("Usuario y/o contraseña incorrectos");
		
	}
	//USO
	public List<Equipo> consultarTodosEquipos(String nombre) throws EquipoNotFoundException {
		try {
			List<Equipo>equipos=new ArrayList<Equipo>();
			MongoDatabase db=MongoSession.getDatabase();
			MongoCollection<Equipo>c=db.getCollection("equipos", Equipo.class);
			FindIterable<Equipo>result=c.find();
			if (nombre==null||nombre.isBlank()) {
				result=c.find();
			}else {
				Bson filter=Filters.eq("nombre", nombre);
				result=c.find(filter);
			}
			MongoCursor<Equipo>cursor=result.cursor();
			while(cursor.hasNext()) {
				Equipo e=cursor.next();
				equipos.add(e);
			}
			return equipos;
		} catch (Exception e) {
			throw new EquipoNotFoundException(e);
		}
	}
	
	//USO REGULAR LA COMPROBACION
	public String insertarEquipo(Equipo equipo) throws EquipoNotFoundException, EquipoException {
		MongoDatabase db=MongoSession.getDatabase();
		MongoCollection<Equipo>c=db.getCollection("equipos", Equipo.class);
		List<Equipo>listaEquipos=consultarTodosEquipos("");
		for (Equipo equipo2 : listaEquipos) {
			if (equipo2.getNombre().equals(equipo.getNombre())) {
				throw new EquipoException("Ya hay un equipo con ese nombre");
			}
		}
		InsertOneResult result=c.insertOne(equipo);
		return result.getInsertedId().toString();
	}
	//USO FUNCIONA
	public List<Personaje> consultarPersonajesJugador(String userName) throws PersonajeNotFoundException {
		Jugador j=consultarJugador(userName);
		return j.getListaPersonajes();
	}
	//USO FUNCIONA
	public void actualizarPersonajes(String userName, List<Personaje>listaPersonaje) throws JugadorException {
		MongoDatabase db=MongoSession.getDatabase();
		MongoCollection<Jugador>c=db.getCollection("jugadores", Jugador.class);
		Bson filter=Filters.eq("userName", userName);
		Bson update=Updates.set("listaPersonajes", listaPersonaje);
		c.updateOne(filter, update);
	}
	
	//JUGADORES
	//USO FUNCIONA
	public String insertarJugador(Jugador jugador) throws JugadorException {
		try {
			MongoDatabase db=MongoSession.getDatabase();
			MongoCollection<Jugador>c=db.getCollection("jugadores", Jugador.class);
			InsertOneResult result=c.insertOne(jugador);
			return result.getInsertedId().toString();
		} catch (Exception e) {
			throw new JugadorException("Ha habido un problema al crear el usuario");
		}
	}
	//USO FUNCIONA
	public Jugador consultarJugador(String userName) {
		MongoDatabase db=MongoSession.getDatabase();
		MongoCollection<Jugador>c=db.getCollection("jugadores", Jugador.class);
		Bson filter=Filters.eq("userName",userName);
		FindIterable<Jugador>result=c.find(filter);
		return result.first();
	}
	//USO FUNCIONA
	public List<Jugador> consultarTodosJugadores() {
		List<Jugador>jugadores=new ArrayList<Jugador>();
		MongoDatabase db=MongoSession.getDatabase();
		MongoCollection<Jugador>c=db.getCollection("jugadores", Jugador.class);
		FindIterable<Jugador>result=c.find();
		MongoCursor<Jugador>cursor=result.cursor();
		while(cursor.hasNext()) {
			jugadores.add(cursor.next());
		}
		return jugadores;
	}
	//PANTALLA EDITAREQUIPO
	//USO FUNCIONA
	public List<Jugador> consultarJugadoresEquipo(Equipo equipo) throws EquipoNotFoundException {
		return consultarTodosEquipos(equipo.getNombre()).get(0).getListaJugadores();
	}
	
	
	public Equipo consultarEquipo(ObjectId id) {
		MongoDatabase db=MongoSession.getDatabase();
		MongoCollection<Equipo>c=db.getCollection("equipos", Equipo.class);
		Bson filter=Filters.eq("_id",id);
		FindIterable<Equipo>result=c.find(filter);
		return result.first();
	}
	//USO
	public void quitarJugadorEquipo(String userName, ObjectId idEquipo) throws EquipoNotFoundException {
		Equipo e=consultarEquipo(idEquipo);
		List<Jugador>listaJugadores=e.getListaJugadores();
		if (userName!=null || idEquipo!=null) {
			for (Jugador jugador : listaJugadores) {
				jugador.getUserName().equals(userName);
				listaJugadores.remove(jugador);
			}
		}
	}
	
	//USO
	public void borrarJugador(String userName) {
		MongoDatabase db=MongoSession.getDatabase();
		MongoCollection<Jugador>c=db.getCollection("jugadores", Jugador.class);
		Bson filter=Filters.eq("userName",userName);
		c.deleteOne(filter);
	}
	
	
	public void borrarEquipo(String nombre) {
		MongoDatabase db=MongoSession.getDatabase();
		MongoCollection<Equipo>c=db.getCollection("equipos", Equipo.class);
		Bson filter=Filters.eq("nombre",nombre);
		c.deleteOne(filter);
	}
}
