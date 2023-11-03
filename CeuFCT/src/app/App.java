package app;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import ceufct.exception.AutenticarException;
import ceufct.exception.FechaException;
import ceufct.exception.FechasServices;
import ceufct.exception.IncompletoException;
import ceufct.exception.RegistrosServiceException;
import ceufct.exception.UsuariosServiceException;
import ceufct.modelo.Fecha;
import ceufct.modelo.Registro;
import ceufct.modelo.Usuario;
import ceufct.service.FechasService;
import ceufct.service.RegistrosService;
import ceufct.service.UsuariosService;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class App {

	private JFrame frame;
	private LoginView login;
	private BienvenidaView bienvenida;
	private AltaUserView altaUser;
	private NuevoRegistroView nuevoRegistro;
	private ConsultaRegistroView consultaRegistro;
	private JMenuBar menuBar;
	private JMenu appMenu;
	private JMenu regisMenu;
	private JMenuItem logOutItem;
	private JMenuItem exitItem;
	private JMenuItem insertItem;
	private JMenuItem selectItem;
	private Usuario usuarioLogged;
	private UsuariosService usuService;
	private RegistrosService regisService;
	private FechasService fechaService;
	private List<Fecha>listaFechas;
	

	public Usuario getUsuarioLogged() {
		return usuarioLogged;
	}

	public void setUsuarioLogged(Usuario usuarioLogged) {
		this.usuarioLogged = usuarioLogged;
	}

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
		frame.setBounds(100, 100, 750, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login=new LoginView(this);
		bienvenida=new BienvenidaView(this);
		altaUser=new AltaUserView(this);
		nuevoRegistro=new NuevoRegistroView(this);
		consultaRegistro=new ConsultaRegistroView(this);
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		appMenu = new JMenu("App");
		menuBar.add(appMenu);
		
		logOutItem = new JMenuItem("Cerrar sesión");
		appMenu.add(logOutItem);
		
		exitItem = new JMenuItem("Salir");
		appMenu.add(exitItem);
		
		regisMenu = new JMenu("Registros");
		menuBar.add(regisMenu);
		
		insertItem = new JMenuItem("Crear nuevo registro");
		regisMenu.add(insertItem);
		
		selectItem = new JMenuItem("Consultar un registro");
		regisMenu.add(selectItem);
		
		ActionListener actionMenu=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==logOutItem) {
					goLogin();
				}else if (e.getSource()==exitItem) {
					if (JOptionPane.showConfirmDialog(exitItem, "¿Estás seguro de que quieres salir?", "SALIR",
							JOptionPane.YES_NO_OPTION) == 0) {
						System.exit(0);
					}
				}else if (e.getSource()==insertItem) {
					goNuevoRegistro();
				}else if(e.getSource()==selectItem){
					goConsultarRegistro();
				}
			}
		};
		menuBar.setVisible(false);
		exitItem.addActionListener(actionMenu);
		insertItem.addActionListener(actionMenu);
		selectItem.addActionListener(actionMenu);
		logOutItem.addActionListener(actionMenu);
		
		goLogin();
		
	}
	public void goLogin() {
		cambiarPantalla(login);
	}
	public void goBienvenida() {
		bienvenida.nombreUsuarioLogged();
		cambiarPantalla(bienvenida);
		menuBar.setVisible(true);
	}
	public void goAltaUser() {
		cambiarPantalla(altaUser);
	}
	public void goNuevoRegistro() {
		consultarFechas();
		cambiarPantalla(nuevoRegistro);
		menuBar.setVisible(true);
	}
	public void goConsultarRegistro() {
		refreshRegis();
		cambiarPantalla(consultaRegistro);
		menuBar.setVisible(true);
	}
	public void cambiarPantalla(View view) {
		frame.setContentPane(view);
		view.limpiarForm();
		frame.revalidate();
	}
	public void exit() {
		System.exit(0);
	}
	
	
	public void altaUser(Usuario u) {
		try {
			usuService=new UsuariosService();
			usuService.altaUsuario(u);
			
			JOptionPane.showMessageDialog(altaUser, "Usuario creado correctamente");
		} catch (UsuariosServiceException e) {
			JOptionPane.showMessageDialog(altaUser, e.getMessage());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	public void refreshRegis() {
		regisService=new RegistrosService();
		List<Registro> listaRegistro=new ArrayList<Registro>();
			try {
				listaRegistro = regisService.consultarRegistros(usuarioLogged.getId_usuario());
				
			} catch (RegistrosServiceException | IncompletoException e) {
				JOptionPane.showMessageDialog(consultaRegistro, e.getMessage());
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			consultaRegistro.getModelo().setListaRegistro(listaRegistro);
			consultaRegistro.getModelo().fireTableDataChanged();
	}
	public void insertarRegistros(Registro regis) {
		regisService=new RegistrosService();
		try {
			regisService.insertarRegistro(regis);
			JOptionPane.showMessageDialog(nuevoRegistro, "Registro insertado con éxito");
		} catch (RegistrosServiceException e) {
			JOptionPane.showMessageDialog(consultaRegistro, e.getMessage());
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	public void consultarFechas() {
		listaFechas=new ArrayList<Fecha>();
		JComboBox<String>comboDates=nuevoRegistro.getDateCombo();;
		fechaService=new FechasService();
		try {
			DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy");
			listaFechas=fechaService.consultarFecha();
			for (Fecha fecha : listaFechas) {
				comboDates.addItem(fecha.getFecha().format(formato));
			}
		} catch (FechasServices | FechaException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void consultarUser(String email, String pass) {
		try {
			usuService=new UsuariosService();
			
			usuarioLogged=usuService.login(email, pass);
			JOptionPane.showMessageDialog(login, "Usuario correcto");
		} catch (UsuariosServiceException | AutenticarException e) {
			JOptionPane.showMessageDialog(login, "Usuario o contraseña incorrectos");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}
