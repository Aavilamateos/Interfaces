package ejerciciosRepasoListener;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EjercicioRepaso01 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjercicioRepaso01 window = new EjercicioRepaso01();
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
	public EjercicioRepaso01() {
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
		lblNewLabel.setBounds(62, 107, 94, 14);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JTextField tFOrigen = new JTextField();
		tFOrigen.setBounds(166, 104, 86, 20);
		frame.getContentPane().add(tFOrigen);
		tFOrigen.setColumns(10);

		KeyListener keyL = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				Character c = e.getKeyChar();// obtengo el caracter
				if (!Character.isDigit(c) || (c.equals('0') && tFOrigen.getText().isEmpty())) {// para saber si el caracter es un numero
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
		tFOrigen.addKeyListener(keyL);
	}
}
