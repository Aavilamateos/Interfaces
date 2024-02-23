package app.gui.editarEquipo;

import java.util.List;

import app.gui.AppController;
import app.modelo.Jugador;
import app.service.JugadorEquipoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditarEquipoController extends AppController {
	private JugadorEquipoService service;
	@FXML
	private TableColumn<Jugador, String> nombreCol;

	@FXML
	private TableColumn<Jugador, String> nombreCol1;

	@FXML
	private TableColumn<Jugador, String> rangoCol;

//	@FXML
//	private TableColumn<Jugador, String> rangoCol1;

	@FXML
	private TableView<Jugador> table;

	@FXML
	private TableView<Jugador> table1;

	private ObservableList<Jugador> jugadoresEquipo;
	private ObservableList<Jugador> jugadoresDisponibles;

	@FXML
	public void initialize() {
		service = new JugadorEquipoService();

		//nombreCol.setCellValueFactory(new PropertyValueFactory<Jugador, String>("Jugador"));
		nombreCol1.setCellValueFactory(new PropertyValueFactory<Jugador, String>("userName"));
		//rangoCol.setCellValueFactory(new PropertyValueFactory<Jugador, String>("Jugador"));
		//rangoCol1.setCellValueFactory(new PropertyValueFactory<Jugador, String>("rango"));

//		jugadoresEquipo = FXCollections.observableArrayList();
//		table.setItems(jugadoresEquipo);
		jugadoresDisponibles = FXCollections.observableArrayList();
		table1.setItems(jugadoresDisponibles);
		
		consultarTablaDisponible();
	}

//	public void consultarTablaEquipo() {
//		Task<Void> task = new Task<Void>() {
//			List<Jugador> resultados;
//
//			@Override
//			protected Void call() throws Exception {
//				jugadoresEquipo.clear();
//				//service.consultarJugadoresEquipo(null);
//				return null;
//			}
//
//			@Override
//			protected void succeeded() {
//				super.succeeded();
//
//				updateProgress(100, 100);
//				table.setEffect(null);
//			}
//
//			@Override
//			protected void failed() {
//				super.failed();
//
//				updateProgress(100, 100);
//				table.setEffect(null);
//			}
//			
//		};
//	}
	
	public void consultarTablaDisponible() {
		Task<Void> task = new Task<Void>() {
			List<Jugador> resultados;

			@Override
			protected Void call() throws Exception {
				//jugadoresDisponibles.clear();
				resultados=service.consultarTodosJugadores();
				return null;
			}

			@Override
			protected void succeeded() {
				super.succeeded();
				jugadoresDisponibles.addAll(resultados);
			}

			@Override
			protected void failed() {
				super.failed();
				jugadoresDisponibles.clear();
			}

		};
		new Thread(task).start();
	}

	public void borrarEquipo() {
		
	}

}
