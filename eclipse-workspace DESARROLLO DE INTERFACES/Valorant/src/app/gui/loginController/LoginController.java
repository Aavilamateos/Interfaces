package app.gui.loginController;

import app.gui.AppController;
import app.gui.inicio.InicioController;
import app.gui.registerController.RegisterController;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends AppController{
	
	
	@FXML
	public TextField user;
	@FXML
	public PasswordField pass;

	public LoginController() {
		
	}
	
	public void aceptar() {
		InicioController controller=(InicioController) cambiarVista(FXML_INICIO);
	}
	
	public void registro() {
		RegisterController controller=(RegisterController) cambiarVista(FXML_REGISTER);
	}

	public void exit() {
		System.exit(0);
	}
}
