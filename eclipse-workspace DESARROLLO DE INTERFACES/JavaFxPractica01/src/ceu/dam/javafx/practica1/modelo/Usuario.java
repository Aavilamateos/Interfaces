package ceu.dam.javafx.practica1.modelo;

import java.util.Date;

public class Usuario {
	private String nombre;
	private String origen;
	private Date fechaRegistro;
	
	public Usuario(String nombre, String origen, Date fechaRegistro) {
		super();
		this.nombre = nombre;
		this.origen = origen;
		this.fechaRegistro = fechaRegistro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
}
