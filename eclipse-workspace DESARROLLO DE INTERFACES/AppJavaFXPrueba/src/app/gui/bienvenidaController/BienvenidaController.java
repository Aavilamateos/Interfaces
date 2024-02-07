package app.gui.bienvenidaController;

import app.gui.appController.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

public class BienvenidaController extends AppController {
	@FXML
	private Label lbBienvenida;
	@FXML
	private BorderPane borderPane;

	@FXML
	private Menu menuBar;

	@FXML
	private MenuItem p1Item;

	@FXML
	private MenuItem p2Item;

	@FXML
	public void salir(ActionEvent event) {
		System.out.println("salir");
		cambiarVista(FXML_LOGIN);
	}

	public void setNombreBienvenida(String nombre) {
		lbBienvenida.setText("Bienvenido/a " + nombre);
	}

	@FXML
	void irPantalla1(ActionEvent event) {
		borderPane.setCenter(cargarVista(FXML_P1));
	}

	@FXML
	void irPantalla2(ActionEvent event) {
		borderPane.setCenter(cargarVista(FXML_P2));
	}
}
