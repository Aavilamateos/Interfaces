package app.gui.bienvenidaController;

import app.gui.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class BienvenidaController extends AppController{

	@FXML
	private Label bienvenidaLbl;
	@FXML
	private BorderPane pane;

	
	public BienvenidaController() {
		pane= new BorderPane();
	}
	public void loadCombo(ActionEvent event) {
		pane.setCenter(cargarVista(FXML_COMBO));
	}
	public void loadColor(ActionEvent event) {
		pane.setCenter(cargarVista(FXML_COLORPICKER));
	}
	public void loadDate(ActionEvent event) {
		pane.setCenter(cargarVista(FXML_DATEPICKER));
	}
	public void logOut(ActionEvent event) {
		cambiarVista(FXML_LOGIN);
	}
	public void loadSlider(ActionEvent event) {
		pane.setCenter(cargarVista(FXML_SLIDER));
	}

	public void setNombreBienvenida(String nombre) {
		bienvenidaLbl.setText(nombre);
	}
	public void exit() {
		System.exit(0);
	}
}
