package app.gui.appController;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import app.gui.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AppController {
	public static Stage stage;
	public static final String FXML_MAIN = "/app/gui/main/main.fxml";
	public static final String FXML_DATOS = "/app/gui/datos/datos.fxml";
	public static final String FXML_NUEVO = "/app/gui/nuevo/nuevo.fxml";

	public static final String SESSION_TIPO = "tipo";

	public AppController() {

	}
	public void mostrarAlert(String texto) {
		Alert alert=new Alert(AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setContentText(texto);
		alert.setTitle("Error");
		alert.show();
	}
	public AppController(Stage primaryStage) {
		stage = primaryStage;
		stage.setUserData(new HashMap<String, Object>());

	}

	public Object getUserDataObject(String key) {
		Map<String, Object> map = (Map<String, Object>) stage.getUserData();
		return map.get(key);
	}

	public void putUserDataObject(String key, Object data) {
		Map<String, Object> map = (Map<String, Object>) stage.getUserData();
		map.put(key, data);
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

	public Parent cargarVista(String fxml) {
		try {
			URL url = App.class.getResource(fxml);
			FXMLLoader loader = new FXMLLoader(url);
			return loader.load();
		} catch (IOException e) {
			throw new RuntimeException("No se h apodido cargar fxml con ruta " + fxml, e);
		}

	}
}
