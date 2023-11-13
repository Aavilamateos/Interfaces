package examen.ejercicio1.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class App {

	private JFrame frame;
	private BrandsTableView brandsView;
	private StartView startView;
	private AddBrandView addView;
	

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
	}
	public void goStart() {
		changeView(startView);
	}
	public void goBrandTable() {
		changeView(brandsView);
	}
	public void goAddBrand() {
		changeView(addView);
	}
	

	
	
	public void changeView(View view) {
		frame.setContentPane(view);
		view.limpiarForm();
		frame.revalidate();
	}
}
