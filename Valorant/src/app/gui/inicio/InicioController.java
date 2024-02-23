package app.gui.inicio;

import app.gui.AppController;
import app.modelo.Equipo;
import app.modelo.Jugador;
import app.service.JugadorEquipoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class InicioController extends AppController{

	@FXML
	private BorderPane pane;
    @FXML
    private Label userLbl;
    @FXML
    private Label equipoLbl;
    @FXML
    private Label equipoTagLbl;
    @FXML
    private Label jugadorTagLbl;
    @FXML
    private ImageView imageEquipo;
    @FXML
    private MenuItem inicioItem;
    @FXML
    private MenuItem crearItem;
    @FXML
    private MenuItem editarEquipoItem;
    @FXML
    private MenuItem editarPerfil;
    @FXML
    private MenuItem buscarItem;
    
    
	private JugadorEquipoService service;
	private Jugador j;
	
	public InicioController() {
		pane=new BorderPane();
		
	}
	
	public void initialize() {
		Node inicioPane=pane.getCenter();
		service=new JugadorEquipoService();
		j=(Jugador) getUserDataObject("user");
	}
	
	public void cerrarSesion() {
		cambiarVista(FXML_LOGIN);
		putUserDataObject("user", null);
	}
//	public void cargarDatosJugador(String userName) {
//        try {
//            // Obtener la información del jugador y su equipo
//            jugadorInfo = service.obtenerInformacionJugador(userName);
//            Jugador jugador = jugadorInfo.getJugador();
//            Equipo equipo = jugadorInfo.getEquipo();
//
//            // Mostrar los datos del jugador
//            userLbl.setText(jugador.getUserName());
//
//            // Mostrar el nombre del equipo si está asignado
//            if (equipo != null) {
//                equipoLbl.setText(equipo.getNombre());
//            }
//
//            // Mostrar la foto del equipo si está asignada
//            if (equipo != null && equipo.getFoto() != null) {
//            	ByteArrayInputStream inputStream = new ByteArrayInputStream(equipo.getFoto());
//            	Image imagenEquipo = new Image(inputStream);
//                imageEquipo.setImage(imagenEquipo);
//            }
//        } catch (JugadorNotFoundException | EquipoNotFoundException e) {
//            // Manejar la excepción en caso de que ocurra
//            e.printStackTrace();
//        }
//    }
	@FXML
	public void loadPerfil(ActionEvent event) {
		pane.setCenter(cargarVista(FXML_PERFIL));
		editarPerfil.setVisible(false);
		inicioItem.setVisible(true);
		editarEquipoItem.setVisible(true);
		crearItem.setVisible(true);
		buscarItem.setVisible(true);
	}
	public void loadEquipo(ActionEvent event) {
		pane.setCenter(cargarVista(FXML_EQUIPO));
		editarEquipoItem.setVisible(false);
		inicioItem.setVisible(true);
		editarPerfil.setVisible(true);
		crearItem.setVisible(true);
		buscarItem.setVisible(true);
	}
	public void loadCrear(ActionEvent event) {
		pane.setCenter(cargarVista(FXML_CREAR));
		crearItem.setVisible(false);
		editarEquipoItem.setVisible(true);
		inicioItem.setVisible(true);
		editarPerfil.setVisible(true);
		buscarItem.setVisible(true);
	}
	public void loadBuscar(ActionEvent event) {
		pane.setCenter(cargarVista(FXML_BUSCAREQUIPO));
		buscarItem.setVisible(false);
		inicioItem.setVisible(true);
		editarPerfil.setVisible(true);
		editarEquipoItem.setVisible(true);
		crearItem.setVisible(true);
	}
	public void loadInicio(ActionEvent event) {
		pane.setCenter(cargarVista(FXML_INICIO));
		pane.setTop(null);
		editarPerfil.setVisible(true);
		editarEquipoItem.setVisible(true);
		crearItem.setVisible(true);
		buscarItem.setVisible(true);
	}
	
	public void exit() {
		System.exit(0);
	}
	//ESTA MAL
	public void datos() {
		service=new JugadorEquipoService();
		
		Equipo e=service.consultarEquipo(j.getIdEquipo());
		userLbl.setText(j.getUserName());
		equipoLbl.setText(e.getNombre());
		
		
	}
	//ESTA MAL
	public void borrarPerfil() {
		service.borrarJugador((String) getUserDataObject("user"));
		mostrarAlert("Usuario borrado correctamente");
	}

}
