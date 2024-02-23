package app.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.bson.types.ObjectId;


public class Jugador {

	private ObjectId id;
	private String email;
	private String userName;
	private String riotId;
	private String tag;
	private String contraseña;
	private List<Personaje>listaPersonajes;
	private String rango;
	private Boolean disponible;
	private ObjectId idEquipo;
	
	public Jugador() {
		listaPersonajes=new ArrayList<Personaje>();
		setDisponible(false);
		
	}

	public String getRango() {
		return rango;
	}

	public void setRango(String rango) {
		this.rango = rango;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRiotId() {
		return riotId;
	}

	public void setRiotId(String riotId) {
		this.riotId = riotId;
	}

	public String getTag() {
		return tag;
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(userName, other.userName);
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Jugador [email=" + email + ", userName=" + userName + ", riotId=" + riotId + ", tag=" + tag
				+ ", contraseña=" + contraseña + ", personajes=" + listaPersonajes + ", rango=" + rango + "]";
	}

	public List<Personaje> getListaPersonajes() {
		return listaPersonajes;
	}

	public void setListaPersonajes(List<Personaje> listaPersonajes) {
		this.listaPersonajes = listaPersonajes;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public ObjectId getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(ObjectId idEquipo) {
		this.idEquipo = idEquipo;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	
}
