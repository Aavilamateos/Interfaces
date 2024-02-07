package app.gui;

import app.gui.appController.AppController;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AppController controller = new AppController(primaryStage);
		controller.cambiarVista(AppController.FXML_MAIN);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
