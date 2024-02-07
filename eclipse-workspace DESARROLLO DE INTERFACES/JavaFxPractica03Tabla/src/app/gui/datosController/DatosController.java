package app.gui.datosController;

import app.gui.appController.AppController;
import app.gui.mainController.MainController;
import app.modelo.Animal;
import app.service.AnimalService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DatosController extends AppController {

	@FXML
	private TextField nameTf;
	@FXML
	private TextField ageTf;

	private Animal a;
	private AnimalService service;

	public DatosController() {
		a = new Animal();
	}
	
	@FXML
	public void initialize() {
		
	}

	public void goMain() {


		if (nameTf.getText().isBlank()) {
			mostrarAlert("El campo nombre no puede estar vacío");
		}else if(ageTf.getText().isBlank()||checkInteger()==false) {
			mostrarAlert("El campo edad no puede estar vacío y tiene que ser un número");
		}
		else {
			a.setNombre(nameTf.getText());
			a.setEdad(Integer.parseInt(ageTf.getText()));
			service=new AnimalService();
			service.addAnimal(a);
			MainController controller=(MainController) cambiarVista(FXML_MAIN);
			controller.crearTipo(a.getTipo());
			controller.consultarAnimales();
		}
	}

	public boolean checkInteger() {
		 try { 
		    Integer.parseInt(ageTf.getText()); 
		 } catch(NumberFormatException e) { 
		    return false; 
		 }
		 return true;
		}
	public void setTipo(String tipo) {
		a.setTipo(tipo);
	}
	public String getTipo() {
		return a.getTipo();
	}
}
