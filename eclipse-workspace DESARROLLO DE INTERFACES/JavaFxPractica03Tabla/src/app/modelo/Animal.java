package app.modelo;

public class Animal {

	private String tipo;
	private String nombre;
	private Integer edad;
	
	public Animal() {
	}

	public Animal(String tipo, String nombre, Integer edad) {
		super();
		this.tipo = tipo;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	
	@Override
	public String toString() {
		return "Animal [tipo=" + tipo + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	
}
