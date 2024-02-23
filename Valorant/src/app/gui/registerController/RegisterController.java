package app.gui.registerController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;

import app.exception.JugadorException;
import app.gui.AppController;
import app.modelo.Jugador;
import app.service.JugadorEquipoService;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController extends AppController {

	private Jugador jugador;

	private JugadorEquipoService service;

	@FXML
	private TextField emailTf;
	@FXML
	private TextField userNameTf;
	@FXML
	private TextField riotidTf;
	@FXML
	private TextField tagTf;
	@FXML
	private PasswordField passTf;
	@FXML
	private PasswordField repeatPass;

	public void initialize() {
		jugador = new Jugador();
		service = new JugadorEquipoService();
	}

	public void volver() {
		cambiarVista(FXML_LOGIN);
	}

	public static Boolean validarCorreoElectronico(String correo) {
		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(correo);
		return matcher.matches();
	}

	public static boolean validarTag(String texto) {
		String regexTexto = "^#.{0,5}$";
		Pattern pattern = Pattern.compile(regexTexto);
		Matcher matcher = pattern.matcher(texto);
		return matcher.matches();
	}

	public void guardarJugador() throws JugadorException {
		if (emailTf.getText().isEmpty() || userNameTf.getText().isEmpty() || passTf.getText().isEmpty()
				|| repeatPass.getText().isEmpty() || riotidTf.getText().isEmpty() || tagTf.getText().isEmpty()) {
			mostrarAlert("Ningún campo puede estar vacío");
		} else {
			if (!validarCorreoElectronico(emailTf.getText())) {
				mostrarAlert("El formato de correo no es válido");
			} else if (!validarTag(tagTf.getText())) {
				mostrarAlert("El máximo de caracteres para el tag son 5 y tiene que empezar por un #");
			} else if (!(passTf.getText().equals(repeatPass.getText()))) {
				mostrarAlert("Las contraseñas no coinciden");
			} else {
				jugador.setEmail(emailTf.getText());
				jugador.setUserName(userNameTf.getText());
				jugador.setTag(tagTf.getText());
				String encriptada=DigestUtils.sha256Hex(passTf.getText());
				jugador.setContraseña(encriptada);
				jugador.setRiotId(riotidTf.getText());
				service.insertarJugador(jugador);
				volver();
				mostrarAlertSuccess("Usuario creado correctamente!");
			}
		}
	}

}
