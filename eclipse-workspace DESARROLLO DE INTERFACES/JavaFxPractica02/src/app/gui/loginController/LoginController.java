package app.gui.loginController;


import app.gui.AppController;
import app.gui.bienvenidaController.BienvenidaController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController extends AppController{
	
	@FXML
	private TextField userTf;
	
	
	public void goBienvenida() {
		BienvenidaController controller= (BienvenidaController) cambiarVista(FXML_BIENVENIDA);	
		controller.setNombreBienvenida("Bienvenido/a "+userTf.getText());
	}
	public void exit() {
		System.exit(0);
	}
}
