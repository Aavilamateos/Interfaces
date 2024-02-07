package app.gui.appController;

import java.io.IOException;
import java.net.URL;

import app.gui.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppController {
	public static Stage stage;
	public static final String FXML_LOGIN ="/app/gui/login/login.fxml";
	public static final String BIENVENIDA ="/app/gui/bienvenida/Bienvenida.fxml";
	public static final String FXML_P1="/app/gui/pantalla1/pantalla1.fxml";
	public static final String FXML_P2="/app/gui/pantalla2/pantalla2.fxml";
	
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
