package ejerciciosRepasoListener;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class EjercicioRepaso03Y04 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjercicioRepaso03Y04 window = new EjercicioRepaso03Y04();
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
	public EjercicioRepaso03Y04() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Introduce tu edad: ");
		lblNewLabel.setBounds(62, 107, 107, 14);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JTextField tFOrigen = new JTextField();
		tFOrigen.setBounds(200, 104, 86, 20);
		frame.getContentPane().add(tFOrigen);
		tFOrigen.setColumns(10);
		
		JCheckBox checkBox = new JCheckBox("Acepto la politica de privacidad");
		checkBox.setSelected(true);
		checkBox.setBounds(62, 161, 190, 23);
		frame.getContentPane().add(checkBox);
		
		JButton botonClean = new JButton("");
		botonClean.setIcon(new ImageIcon("C:\\Users\\aavila3794\\Pictures\\Screenpresso\\2023-10-03_18h49_36.png"));
		botonClean.setBounds(296, 77, 48, 64);
		frame.getContentPane().add(botonClean);
		

		KeyListener keyL = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				Character c = e.getKeyChar();// obtengo el caracter
				if (!Character.isDigit(c) || (c.equals('0') && tFOrigen.getText().isEmpty())) {// para saber si el
																								// caracter es un numero
					e.consume();// evito que un caracter se imprima
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (e.getKeyCode() == KeyEvent.VK_UP) {
					if (tFOrigen.getText().isEmpty()) {
						tFOrigen.setText("1");
					} else {
						tFOrigen.setText(Integer.parseInt(tFOrigen.getText()) + 1 + "");
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					if (tFOrigen.getText().isEmpty()) {
						tFOrigen.setText("1");
					} else if (!tFOrigen.getText().equals("1")) {
						tFOrigen.setText(Integer.parseInt(tFOrigen.getText()) - 1 + "");
						{

						}
					}
				}
			}
		};
		ActionListener actionLClean=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tFOrigen.setText("");
			}
		};
		
		ActionListener actionL=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBox.isSelected()!=true) {
					tFOrigen.setEnabled(false);
				}else {
					tFOrigen.setEnabled(true);
				}
			}
		};
		botonClean.addActionListener(actionLClean);
		checkBox.addActionListener(actionL);
		tFOrigen.addKeyListener(keyL);
	}
}
