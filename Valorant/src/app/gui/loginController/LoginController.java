package app.gui.loginController;

import app.exception.JugadorNotFoundException;
import app.gui.AppController;
import app.gui.editarPerfil.EditarPerfilController;
import app.gui.inicio.InicioController;
import app.service.JugadorEquipoService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController extends AppController {

	@FXML
	public TextField user;
	@FXML
	public PasswordField pass;
	private JugadorEquipoService service;

	public void initialize() {
		service = new JugadorEquipoService();
	}

	public void aceptar() throws JugadorNotFoundException {

		if (service.login(user.getText(), pass.getText())) {
			putUserDataObject("user", service.consultarJugador(user.getText()));
			cambiarVista(FXML_INICIO);
			
		}
	}

	public void registro() {
		cambiarVista(FXML_REGISTER);
	}

	public void exit() {
		System.exit(0);
	}
}
