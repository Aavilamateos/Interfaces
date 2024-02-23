package app.gui.editarPerfil;

import java.util.ArrayList;
import java.util.List;

import app.exception.JugadorException;
import app.gui.AppController;
import app.modelo.Equipo;
import app.modelo.Jugador;
import app.modelo.Personaje;
import app.service.JugadorEquipoService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditarPerfilController extends AppController {

	@FXML
	private ComboBox<Personaje> comboDuelistas;
	@FXML
	private ComboBox<Personaje> comboCentinelas;
	@FXML
	private ComboBox<Personaje> comboControladores;
	@FXML
	private ComboBox<Personaje> comboIniciadores;
	@FXML
	private Slider slider;
	@FXML
    private TableColumn<Personaje, String> personajeCol;

    @FXML
    private TableColumn<Personaje, String> rolCol;
    @FXML
    private TableView<Personaje> table;
    
    private ObservableList<Personaje> personajes;
    
    
	private List<Personaje>listaPersonajes;
	private String userName;
	private JugadorEquipoService service;
	private Jugador j;

	@FXML
	public void initialize() {
		service=new JugadorEquipoService();
		listaPersonajes=new ArrayList<Personaje>();
		personajeCol.setCellValueFactory(new PropertyValueFactory<Personaje, String>("Personaje"));
		rolCol.setCellValueFactory(new PropertyValueFactory<Personaje, String>("Rol"));
		personajes=FXCollections.observableArrayList();
		table.setItems(personajes);
		getTask();
		
		comboDuelistas.getItems().add(new Personaje("Jett", "Duelista"));
		comboDuelistas.getItems().add(new Personaje("Phoenix", "Duelista"));
		comboDuelistas.getItems().add(new Personaje("Raze", "Duelista"));
		comboDuelistas.getItems().add(new Personaje("Iso", "Duelista"));		
		comboDuelistas.getItems().add(new Personaje("Reyna", "Duelista"));
		comboDuelistas.getItems().add(new Personaje("Neon", "Duelista"));
		comboDuelistas.getItems().add(new Personaje("Yoru", "Duelista"));
		
		
		comboIniciadores.getItems().add(new Personaje("Breach", "Iniciador"));
		comboIniciadores.getItems().add(new Personaje("KAY/O", "Iniciador"));
		comboIniciadores.getItems().add(new Personaje("Skye", "Iniciador"));
		comboIniciadores.getItems().add(new Personaje("Sova", "Iniciador"));
		comboIniciadores.getItems().add(new Personaje("Fade", "Iniciador"));
		comboIniciadores.getItems().add(new Personaje("Gekko", "Iniciador"));
		
		
		comboCentinelas.getItems().add(new Personaje("Sage", "Centinela"));
		comboCentinelas.getItems().add(new Personaje("Cypher", "Centinela"));
		comboCentinelas.getItems().add(new Personaje("Deadlock", "Centinela"));
		comboCentinelas.getItems().add(new Personaje("Killjoy", "Centinela"));
		comboCentinelas.getItems().add(new Personaje("Chamber", "Centinela"));
		
		comboControladores.getItems().add(new Personaje("Viper", "Controlador"));
		comboControladores.getItems().add(new Personaje("Brimstone", "Controlador"));
		comboControladores.getItems().add(new Personaje("Harbor", "Controlador"));
		comboControladores.getItems().add(new Personaje("Omen", "Controlador"));
		comboControladores.getItems().add(new Personaje("Astra", "Controlador"));
	}
	public void getTask() {
		Task<Void>task=new Task<Void>() {

			List<Personaje> resultados;
			@Override
			protected Void call() throws Exception {
				personajes.clear();
				resultados=service.consultarPersonajesJugador(userName);
				return null;
			}
			@Override
			protected void succeeded() {
				super.succeeded();
				personajes.addAll(resultados);
			}
			@Override
			protected void failed() {
				super.failed();
				personajes.clear();
			}
		};
		new Thread(task).start();
	}

	public void guardarPersonajes() throws JugadorException {
		
		if (comboDuelistas.getValue()!=null) {
			listaPersonajes.add(comboDuelistas.getValue());
		}
		if (comboControladores.getValue()!=null) {
			listaPersonajes.add(comboControladores.getValue());
		}
		if (comboIniciadores.getValue()!=null) {
			listaPersonajes.add(comboIniciadores.getValue());
		}
		if (comboCentinelas.getValue()!=null) {
			listaPersonajes.add(comboCentinelas.getValue());
		}
		getTask();
		
	}
	public void getDatos(String userName) {
		this.userName=userName;
	}

	public void guardarRango() {
		j=new Jugador();
		String[] rangos = { "Hierro 1", "Hierro 2", "Hierro 3", "Bronce 1", "Bronce 2", "Bronce 3", "Plata 1",
				"Plata 2", "Plata 3", "Oro 1", "Oro 2", "Oro 3", "Platino 1", "Platino 2", "Platino 3", "Diamante 1",
				"Diamante 2", "Diamante 3", "Ascendente 1", "Ascendente 2", "Ascendente 3", "Inmortal 1", "Inmortal 2",
				"Inmortal 3", "Radiante" };
		j.setRango(rangos[(int) slider.getValue()]);
		System.out.println(j);
	}

}
