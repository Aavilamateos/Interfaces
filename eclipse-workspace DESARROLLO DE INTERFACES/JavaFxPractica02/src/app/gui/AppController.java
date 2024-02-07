package app.gui;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppController {
	public static Stage stage;
	public static final String FXML_LOGIN ="/app/gui/login/login.fxml";
	public static final String FXML_BIENVENIDA ="/app/gui/bienvenida/bienvenida.fxml";
	public static final String FXML_COLORPICKER ="/app/gui/colorpicker/colorpicker.fxml";
	public static final String FXML_DATEPICKER ="/app/gui/datepicker/datepicker.fxml";
	public static final String FXML_SLIDER ="/app/gui/slider/slider.fxml";
	public static final String FXML_COMBO="/app/gui/combobox/combobox.fxml";
	
	public AppController() {
		
	}
	public AppController(Stage primaryStage) {
		stage=primaryStage;
	}
	public AppController cambiarVista(String fxml) {
		try {
			URL url = App.class.getResource(fxml);
			FXMLLoader loader=new FXMLLoader(url);
			Scene scene = new Scene(loader.load());
			stage.setScene(scene);
			return loader.getController();
		} catch (IOException e) {
			throw new RuntimeException("No se h apodido cargar fxml con ruta " + fxml, e);
		}
	}
	public Parent cargarVista(String fxml) {
		try {
			URL url = App.class.getResource(fxml);
			FXMLLoader loader=new FXMLLoader(url);
			return loader.load();
		} catch (IOException e) {
			throw new RuntimeException("No se h apodido cargar fxml con ruta " + fxml, e);
		}
		
	}
}
