package app.gui.mainController;

import java.util.List;

import app.gui.appController.AppController;
import app.modelo.Animal;
import app.service.AnimalService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;

public class MainController extends AppController {
	private AnimalService service;
	private String tipo;

	@FXML
	private ProgressBar progressBar;

	@FXML
	private TableView<Animal> table;
	@FXML
	private TableColumn<Animal, Integer> edadCol;

	@FXML
	private TableColumn<Animal, String> nombreCol;

	@FXML
	private TableColumn<Animal, String> tipoCol;

	@FXML
	private TextField consultarTf;

	private ObservableList<Animal> animales;

	@FXML
	public void initialize() {
		tipoCol.setCellValueFactory(new PropertyValueFactory<Animal, String>("tipo"));
		nombreCol.setCellValueFactory(new PropertyValueFactory<Animal, String>("nombre"));
		edadCol.setCellValueFactory(new PropertyValueFactory<Animal, Integer>("edad"));

		animales = FXCollections.observableArrayList();
		table.setItems(animales);

	}

	public void goNuevo(ActionEvent event) {
		cambiarVista(FXML_NUEVO);
	}

	public void crearTipo(String tipo) {
		consultarTf.setText(tipo);
	}

	public void consultarAnimales() {
		service = new AnimalService();
		
		tipo = consultarTf.getText();
		table.setEffect(new BoxBlur());
		Task<Void> task = new Task<Void>() {
			List<Animal> resultados;

			@Override
			protected Void call() throws Exception {
				animales.clear();
				resultados = service.consultarAnimales(tipo);
				return null;
			}

			@Override
			protected void succeeded() {
				super.succeeded();
				animales.addAll(resultados);
				updateProgress(100, 100);
				table.setEffect(null);
			}

			@Override
			protected void failed() {
				super.failed();
				mostrarAlert("Ha habido un error al consultar");
				updateProgress(100, 100);
				table.setEffect(null);
			}

		};
		progressBar.progressProperty().bind(task.progressProperty());
		new Thread(task).start();

	}

}
