package app.gui.registerController;

import app.gui.AppController;
import app.gui.loginController.LoginController;

public class RegisterController extends AppController{

	
	
	public void volver() {
		LoginController controller=(LoginController) cambiarVista(FXML_LOGIN);
	}
	

}
