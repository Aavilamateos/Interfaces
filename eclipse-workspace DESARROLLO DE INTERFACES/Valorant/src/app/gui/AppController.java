package app.gui;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import app.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppController {

	public static Stage stage;
	public static final String FXML_LOGIN="/app/gui/login/login.fxml";
	public static final String FXML_REGISTER="/app/gui/register/register.fxml";
	public static final String FXML_INICIO="/app/gui/inicio/inicio.fxml";
	
	public AppController() {

	}
	public AppController(Stage primaryStage) {
		stage = primaryStage;
		stage.setUserData(new HashMap<String, Object>());

	}
	public AppController cambiarVista(String fxml) {
		try {
			URL url = App.class.getResource(fxml);
			FXMLLoader loader = new FXMLLoader(url);
			Scene scene = new Scene(loader.load());
			stage.setScene(scene);
			return loader.getController();
		} catch (IOException e) {
			throw new RuntimeException("No se ha podido cargar fxml con ruta " + fxml, e);
		}
	}

}
