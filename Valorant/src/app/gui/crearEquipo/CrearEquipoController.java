package app.gui.crearEquipo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.exception.EquipoException;
import app.exception.EquipoNotFoundException;
import app.exception.ImageNotFoundException;
import app.gui.AppController;
import app.modelo.Equipo;
import app.service.JugadorEquipoService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class CrearEquipoController extends AppController {

	private JugadorEquipoService service;

	@FXML
	private Label equipoLbl;

	@FXML
	private ImageView imageEquipo;

	@FXML
	private TextField nombreEquipoTf;

	@FXML
	private TextField tagEquipoTf;

	public void initialize() {
		service = new JugadorEquipoService();
	}

	public byte[] mostrarImagen() throws ImageNotFoundException, IOException {
		File file = insertarImagen(imageEquipo);
		byte[] bytesArray = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(bytesArray); // Leer el archivo en el arreglo de bytes
		fis.close();
		return bytesArray;
	}

	public void crearEquipo() throws ImageNotFoundException, IOException, EquipoNotFoundException, EquipoException {
		Equipo e = new Equipo();
		if (nombreEquipoTf.getText().isEmpty() || tagEquipoTf.getText().isEmpty() || imageEquipo == null) {
			mostrarAlert("Ningún campo puede estar vacío y tienes que añadir una foto");
		} else {
			if (!validarTag(tagEquipoTf.getText())) {
				mostrarAlert("El máximo de caracteres para el tag son 5 y tiene que empezar por un #");
			} else {
				e.setNombre(nombreEquipoTf.getText());
				e.setEquipoTag(tagEquipoTf.getText());
				byte[] bytesArray = mostrarImagen();
				e.setFoto(bytesArray);
				service.insertarEquipo(e);
				mostrarAlertSuccess("Equipo creado con éxito, volverás al inicio");
				cambiarVista(FXML_INICIO);
			}
		}
	}

	public static boolean validarTag(String texto) {
		String regexTexto = "^#.{0,5}$";
		Pattern pattern = Pattern.compile(regexTexto);
		Matcher matcher = pattern.matcher(texto);
		return matcher.matches();
	}

}
