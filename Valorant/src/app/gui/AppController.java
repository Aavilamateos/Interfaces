package app.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import app.App;
import app.exception.ImageNotFoundException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AppController {

	public static Stage stage;
	public static final String FXML_LOGIN="/app/gui/login/login.fxml";
	public static final String FXML_REGISTER="/app/gui/register/register.fxml";
	public static final String FXML_INICIO="/app/gui/inicio/inicio.fxml";
	public static final String FXML_PERFIL="/app/gui/editarPerfil/perfil.fxml";
	public static final String FXML_EQUIPO="/app/gui/editarEquipo/equipo.fxml";
	public static final String FXML_BUSCAREQUIPO="/app/gui/buscarEquipo/buscarEquipo.fxml";
	public static final String FXML_CREAR="/app/gui/crearEquipo/crearEquipo.fxml";
	public static final String SESSION_USER="usuario";
	
	public AppController() {

	}
	public AppController(Stage primaryStage) {
		stage = primaryStage;
		stage.setUserData(new HashMap<String, Object>());
	}
	
	public Object getUserDataObject(String key) {
		@SuppressWarnings("unchecked")
		Map<String,Object>userData=(Map<String, Object>) stage.getUserData();
		return userData.get(key);
	}
	public void putUserDataObject(String key, Object data) {
		@SuppressWarnings("unchecked")
		Map<String,Object>userData=(Map<String, Object>) stage.getUserData();
		userData.put(key, data);
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
			FXMLLoader loader=new FXMLLoader(url);
			return loader.load();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("No se ha podido cargar fxml con ruta " + fxml, e);
		}
		
	}
	public void colorEquipo(Label label, ColorPicker color ) {
		label.setTextFill(color.getValue());
	}
	public void mostrarAlert(String texto) {
		Alert alert=new Alert(AlertType.ERROR);
		alert.setHeaderText(null);
		alert.setContentText(texto);
		alert.setTitle("Error");
		alert.show();
	}
	public void mostrarAlertSuccess(String texto) {
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setHeaderText(null);
		alert.setContentText(texto);
		alert.setTitle("Success!");
		alert.show();
	}
	public File insertarImagen(ImageView imageView) throws ImageNotFoundException {
		// Crear un objeto FileChooser
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Seleccionar Imagen");

		// Filtrar solo archivos de imagen
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"Archivos de imagen (*.png, *.jpg, *.gif)", "*.png", "*.jpg", "*.gif");
		fileChooser.getExtensionFilters().add(extFilter);

		// Mostrar el diálogo de selección de archivo
		File file = fileChooser.showOpenDialog(stage);
		if (file != null) {
			// Cargar la imagen seleccionada en el ImageView
			Image image = new Image(file.toURI().toString());
			imageView.setImage(image);
			return file;
		}
		throw new ImageNotFoundException();
	}


}
