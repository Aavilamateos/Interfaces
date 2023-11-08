package ejerciciosVentana;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ejercicio02 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ejercicio02() {
		super();
		setTitle("Añadir usuario");

	}

	public void Ejercicio2Texto() {
		setSize(400, 200);
		setLocationRelativeTo(null);

		Container contenedor = getContentPane();
		GridLayout layout1 = new GridLayout(4, 2);
		contenedor.setLayout(layout1);

		JLabel textoN = new JLabel("Nombre: ");
		JLabel textoD = new JLabel("DNI: ");
		JLabel textoF = new JLabel("Fecha de nacimiento: ");
		JLabel barra = new JLabel("/");
		JLabel barra1 = new JLabel("/");
		JTextField cuadroN = new JTextField();
		JTextField cuadroD = new JTextField();
		JTextField cuadroF1 = new JTextField(3);
		JTextField cuadroF2 = new JTextField(3);
		JTextField cuadroF3 = new JTextField(3);
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		contenedor.add(textoN);
		contenedor.add(cuadroN);
		contenedor.add(textoD);
		contenedor.add(cuadroD);
		contenedor.add(textoF);

		JPanel panelBotones = new JPanel();
		FlowLayout layout2 = new FlowLayout();
		panelBotones.setLayout(layout2);
		panelBotones.add(cuadroF1);
		panelBotones.add(barra);
		panelBotones.add(cuadroF2);
		panelBotones.add(barra1);
		panelBotones.add(cuadroF3);
		contenedor.add(panelBotones);

		contenedor.add(aceptar);
		contenedor.add(cancelar);

		setVisible(true);
	}
}
