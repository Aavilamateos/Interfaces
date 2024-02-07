package app.gui.nuevoController;

import app.gui.appController.AppController;
import app.gui.datosController.DatosController;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NuevoController extends AppController {

	@FXML
	private TextField tipoTf;

	public void initialize() {

	}

	public void goDatos() {
		String tipo = tipoTf.getText();
		if (!(tipo.equals(""))) {
			DatosController controller = (DatosController) cambiarVista(FXML_DATOS);
			controller.setTipo(tipo);
		} else {
			mostrarAlert("El campo nombre no puede estar vacío");

		}
	}

}
