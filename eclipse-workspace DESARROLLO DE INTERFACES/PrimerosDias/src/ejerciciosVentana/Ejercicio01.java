package ejerciciosVentana;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ejercicio01 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ejercicio01() {
		super();
		setTitle("Ejercicios layout");

	}

	public void Ejercicio1Texto() {
		setSize(900, 900);
		setLocationRelativeTo(null);

		Container contenedor = getContentPane();

		GridLayout layout1 = new GridLayout(3, 2);
		contenedor.setLayout(layout1);
		GridLayout layout2 = new GridLayout(2, 2);
		JPanel nuevoContenedor = new JPanel();
		nuevoContenedor.setLayout(layout2);

		for (int i = 1; i <= 5; i++) {
			JLabel texto = new JLabel();
			texto.setText("Texto" + i);
			contenedor.add(texto);
		}
		contenedor.add(nuevoContenedor);
		for (int j = 61; j <= 64; j++) {
			JLabel texto1 = new JLabel();
			texto1.setText("Texto" + j);
			nuevoContenedor.add(texto1);
		}

		setVisible(true);
	}

}
