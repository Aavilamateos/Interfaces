package app.gui.login;

import app.gui.appController.AppController;
import app.gui.bienvenidaController.BienvenidaController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController extends AppController{
	@FXML
	private TextField nameTF;

	public void escribirTexto() {
		System.out.println(nameTF.getText());
		
		BienvenidaController controller= (BienvenidaController) cambiarVista(BIENVENIDA);
		controller.setNombreBienvenida(nameTF.getText());
	}

	@FXML
	public void initialize() {
		
	}
}
