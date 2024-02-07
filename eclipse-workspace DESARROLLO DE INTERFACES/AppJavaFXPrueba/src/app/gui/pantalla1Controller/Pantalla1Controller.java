package app.gui.pantalla1Controller;

import app.gui.appController.AppController;
import app.gui.modelo.Persona;
import app.gui.service.PersonasService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Pantalla1Controller extends AppController{

	@FXML
	private TableView<Persona> tablaPersonas;
    @FXML
    private TableColumn<Persona, String	> columnDni;

    @FXML
    private TableColumn<Persona, Integer> columnEdad;

    @FXML
    private TableColumn<Persona, String> columnNombre;
    
    private ObservableList<Persona>listaPersonas;
    
    @FXML
    public void initialize() {
    	
    	columnDni.setCellValueFactory(new PropertyValueFactory<Persona, String>("dni"));
    	columnEdad.setCellValueFactory(new PropertyValueFactory<Persona, Integer>("edad"));
    	columnNombre.setCellValueFactory(new PropertyValueFactory<Persona, String>("nombre"));
    	listaPersonas=FXCollections.observableArrayList();
    	tablaPersonas.setItems(listaPersonas);
    }
    
    public void añadirPersona() {
 
    	PersonasService service=new PersonasService();
    	listaPersonas=(ObservableList<Persona>) service.getPersonas();
    }

}
