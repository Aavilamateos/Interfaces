package examen.gui;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import examen.modelo.Coche;
import examen.services.AutenticacionException;
import examen.services.ExamenService;

public class App {

	private LoginView login;
	private ConsultarView consultar;
	private InsertView insert;
	private JFrame frame;
	private ExamenService service;
	private List<Coche> coches;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		login = new LoginView(this);
		consultar = new ConsultarView(this);
		insert = new InsertView(this);
		goLogin();

	}

	public void goLogin() {
		changeView(login);
	}

	public void goConsultar() {
		changeView(consultar);
	}

	public void goInsert() {
		changeView(insert);
	}

	public void changeView(View view) {
		frame.setContentPane(view);
		view.limpiarForm();
		frame.revalidate();
	}

	public void exit() {
		if (JOptionPane.showConfirmDialog(frame, "¿Estás seguro de que quieres salir?", "SALIR",
				JOptionPane.YES_NO_OPTION) == 0) {
			System.exit(0);
		}
	}

	public void login(String clave) {
		if (clave == null) {

		} else {
			try {
				service = new ExamenService();
				service.login(clave);
				goConsultar();
			} catch (AutenticacionException e) {
				login.setErrorText(e.getMessage());

			}
		}

	}

	public void crearCoche(String marca, String modelo, Integer antiguedad) {
		if (marca.equals("") || modelo.equals("") || antiguedad == 1) {

		} else {
			try {
				service = new ExamenService();
				service.crearCoche(marca, modelo, antiguedad);
				goConsultar();
			} catch (NumberFormatException e) {
				e.getMessage();
			}
		}

	}

	public List<Coche> consultarCoches(String marca) {
		coches = new ArrayList<Coche>();
		service = new ExamenService();
		coches = service.consultarCoches(marca);
		consultar.getModelo().setListaCoches(coches);
		consultar.getModelo().fireTableDataChanged();
		if (consultar.getModelo().getListaCoches().isEmpty()) {
			consultar.sinRegistros("No hay registros para la marca indicada.");
		} else {
			consultar.sinRegistros("");
		}
		return coches;
	}

}
