package ceu.dam.javafx.practica1.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		//1. Cargar el FXML que quiero mostar
		FXMLLoader loader= new FXMLLoader(App.class.getResource("/app/gui/login/login.fxml"));
		//2. Creamos la escena
		Scene scene=new Scene(loader.load(),856,552);
		//3. Cargar la escena en el escenario
		primaryStage.setScene(scene);
		//4. Mostrar escenario
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch();
	}

}
