package app;

import java.io.File;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PRUEBASDECODIGO {

	public PRUEBASDECODIGO() {
		
	}
	public void start(Stage primaryStage) {
        // Crear un ImageView para mostrar la foto de perfil
        ImageView imageView = new ImageView();
        imageView.setFitWidth(200);
        imageView.setFitHeight(200);

        // Botón para abrir el FileChooser
        Button button = new Button("Seleccionar foto de perfil");
        button.setOnAction(e -> {
            // Crear un FileChooser
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Seleccionar foto de perfil");

            // Filtro para mostrar solo archivos de imagen
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.jpeg", "*.gif");
            fileChooser.getExtensionFilters().add(extFilter);

            // Mostrar el diálogo para seleccionar un archivo
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                // Cargar la imagen seleccionada en el ImageView
                Image image = new Image(file.toURI().toString());
                imageView.setImage(image);
            }
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(imageView, button);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Cargar foto de perfil");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



}
