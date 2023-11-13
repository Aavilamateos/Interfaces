package examen.ejercicio1.modelo;

public class Coche {

	private String marca;
	private String modelo;
	private String año;
	private String matricula;
	private Boolean disponible;
	
	public Coche(String marca, String modelo, String año, String matricula, Boolean disponible) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.matricula = matricula;
		this.disponible = disponible;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}
	
	

}
