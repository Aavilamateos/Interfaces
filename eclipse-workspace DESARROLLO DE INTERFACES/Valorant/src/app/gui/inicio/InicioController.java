package app.gui.inicio;

import app.gui.AppController;
import app.gui.loginController.LoginController;

public class InicioController extends AppController{

	
	public void cerrarSesion() {
		LoginController controller=(LoginController) cambiarVista(FXML_LOGIN);
	}
	
	
	public void exit() {
		System.exit(0);
	}

}
