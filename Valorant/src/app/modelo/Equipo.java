package app.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.bson.types.ObjectId;

public class Equipo {

	
	private String nombre;
	private List<Jugador> listaJugadores;
	private Double mediaRango;
	private String equipoTag;
	private byte[] foto;

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipo other = (Equipo) obj;
		return Objects.equals(nombre, other.nombre);
	}
	public Equipo() {
		listaJugadores=new ArrayList<Jugador>();
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Jugador> getListaJugadores() {
		return listaJugadores;
	}

	public void setListaJugadores(List<Jugador> listaJugadores) {
		this.listaJugadores = listaJugadores;
	}

	public Double getMediaRango() {
		return mediaRango;
	}

	public void setMediaRango(Double mediaRango) {
		this.mediaRango = mediaRango;
	}

	public String getEquipoTag() {
		return equipoTag;
	}

	public void setEquipoTag(String equipoTag) {
		this.equipoTag = equipoTag;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", listaJugadores=" + listaJugadores + ", mediaRango=" + mediaRango
				+ ", equipoTag=" + equipoTag + "]";
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

}
