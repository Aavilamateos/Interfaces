package examen.ejercicio1.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import examen.ejercicio1.modelo.Coche;
import examen.ejercicio1.services.ExamenService;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class App {

	private JFrame frame;
	private BrandsTableView brandsView;
	private StartView startView;
	private AddBrandView addView;
	private JMenuBar menuBar;
	private JMenu barMenu;
	private JMenuItem altaItem;
	private JMenuItem consultarItem;
	private JMenuItem logOutItem;
	private JMenuItem exitItem;
	private List<Coche> listaCoches;
	private ExamenService service;

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
		frame.setBounds(100, 100, 750, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		startView = new StartView(this);
		brandsView = new BrandsTableView(this);
		addView = new AddBrandView(this);
		menu();
		goStart();
	}

	public void goStart() {
		changeView(startView);
		menuBar.setVisible(false);
	}

	public void goBrandTable() {
		consultarItem.setVisible(false);
		altaItem.setVisible(true);
		changeView(brandsView);
	}

	public void goAddBrand() {
		addView.rellenarCombo(consultarMarcas());
		changeView(addView);
		altaItem.setVisible(false);
		consultarItem.setVisible(true);
	}

	public void changeView(View view) {
		menuBar.setVisible(true);
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

	public void menu() {

		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		barMenu = new JMenu("Menú");
		menuBar.add(barMenu);

		altaItem = new JMenuItem("Alta");
		barMenu.add(altaItem);

		consultarItem = new JMenuItem("Consultar");
		barMenu.add(consultarItem);

		logOutItem = new JMenuItem("Cerrar sesión");
		barMenu.add(logOutItem);

		exitItem = new JMenuItem("Salir");
		barMenu.add(exitItem);
		ActionListener actionItems = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == altaItem) {
					goAddBrand();
				} else if (e.getSource() == consultarItem) {
					goBrandTable();
				} else if (e.getSource() == logOutItem) {
					goStart();
				} else if (e.getSource() == exitItem) {
					exit();
				}
			}
		};

		logOutItem.addActionListener(actionItems);
		consultarItem.addActionListener(actionItems);
		altaItem.addActionListener(actionItems);
		exitItem.addActionListener(actionItems);
	}

	public void cargarListaCoches(List<Coche> listaCoches) {
		brandsView.getModelo().setListaCoches(listaCoches);
		brandsView.getModelo().fireTableDataChanged();
	}

	public void consultarCoches() {
		listaCoches = new ArrayList<Coche>();
		service = new ExamenService();
		listaCoches = service.consultarCoches();
		cargarListaCoches(listaCoches);
	}

	public void consultarCochesNo() {
		listaCoches = new ArrayList<Coche>();
		service = new ExamenService();
		listaCoches = service.consultarCochesDisponibles(false);
		cargarListaCoches(listaCoches);
	}

	public void consultarCochesSi() {
		listaCoches = new ArrayList<Coche>();
		service = new ExamenService();
		listaCoches = service.consultarCochesDisponibles(true);
		cargarListaCoches(listaCoches);
	}

	public List<String> consultarMarcas() {
		List<String> listaMarcas = new ArrayList<String>();
		service = new ExamenService();
		listaMarcas = service.consultarMarcas();
		return listaMarcas;
	}

	public void addBrand(String marca) {
		service = new ExamenService();
		service.añadirMarca(marca);
		addView.rellenarCombo(consultarMarcas());
	}

}
