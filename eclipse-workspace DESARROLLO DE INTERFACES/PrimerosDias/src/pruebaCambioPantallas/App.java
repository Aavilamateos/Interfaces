package pruebaCambioPantallas;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class App {

	private JFrame frame;
	private Pantalla1View p1;
	private Pantalla2View p2;
	private Pantalla3View p3;
	

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p1=new Pantalla1View(this);
		p2=new Pantalla2View(this);
		p3=new Pantalla3View(this);
		
		irAPantalla1();
	}
	public void irAPantalla1() {
		frame.setContentPane(p1);
		frame.revalidate();
		
	}
	public void isAPantalla2() {
		frame.setContentPane(p2);
		frame.revalidate();
	}
	public void irAPantalla3() {
		frame.setContentPane(p3);
		frame.revalidate();
	}

}
