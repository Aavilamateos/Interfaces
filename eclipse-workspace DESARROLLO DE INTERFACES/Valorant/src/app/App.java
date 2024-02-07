package app;

import app.gui.AppController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		AppController controller = new AppController(primaryStage);
		//primaryStage.setResizable(true);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		controller.cambiarVista(AppController.FXML_LOGIN);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}
