package app.gui.buscarEquipo;

import java.util.List;

import app.gui.AppController;
import app.modelo.Equipo;
import app.service.JugadorEquipoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BuscarEquipoController extends AppController{

	private JugadorEquipoService service;
	@FXML
	private TextField buscarTf;
	@FXML
	private Label equipoLbl;
	@FXML
	private TableColumn<Equipo, String> nombreCol;
	@FXML
	private TableView<Equipo> table;
	private ObservableList<Equipo> equipos;

	public void initialize() {
		service = new JugadorEquipoService();
		nombreCol.setCellValueFactory(new PropertyValueFactory<Equipo, String>("nombre"));
		equipos=FXCollections.observableArrayList();
		table.setItems(equipos);
		getTask();
	}

	public void getTask() {
		Task<Void>task=new Task<Void>() {

			List<Equipo> resultados;
			@Override
			protected Void call() throws Exception {
				equipos.clear();
				resultados=service.consultarTodosEquipos(buscarTf.getText());
				return null;
			}
			@Override
			protected void succeeded() {
				super.succeeded();
				equipos.addAll(resultados);
			}
			@Override
			protected void failed() {
				super.failed();
				equipos.clear();
			}
		};
		new Thread(task).start();
	}
	public void getEquipos() {
		getTask();
	}
}
