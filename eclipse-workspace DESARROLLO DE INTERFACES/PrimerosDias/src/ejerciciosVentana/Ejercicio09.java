package ejerciciosVentana;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ejercicio09 {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio09 window = new Ejercicio09();
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
	public Ejercicio09() {
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

		textField = new JTextField();
		textField.setBounds(160, 43, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField1 = new JTextField();
		textField1.setBounds(160, 86, 86, 20);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField();
		textField2.setBounds(160, 134, 86, 20);
		frame.getContentPane().add(textField2);
		textField2.setColumns(10);

		textField3 = new JTextField();
		textField3.setBounds(160, 184, 86, 20);
		frame.getContentPane().add(textField3);
		textField3.setColumns(10);

		KeyListener keyListener = new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_ENTER) {
					JTextField tfAbajo = new JTextField();
					tfAbajo = (JTextField) e.getSource();
					tfAbajo.transferFocus();
				} else if (e.getKeyCode() == KeyEvent.VK_UP) {
					JTextField tfArriba = new JTextField();
					tfArriba = (JTextField) e.getSource();
					tfArriba.transferFocusBackward();
				}
			}
		};
		FocusListener focusListener = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				JTextField tfColorOriginal = new JTextField();
				tfColorOriginal = (JTextField) e.getSource();
				tfColorOriginal.setBackground(Color.WHITE);
			}

			@Override
			public void focusGained(FocusEvent e) {
				JTextField tfColorFocus = new JTextField();
				tfColorFocus = (JTextField) e.getSource();
				tfColorFocus.setBackground(Color.GREEN);
			}
		};

		textField.addFocusListener(focusListener);
		textField.addKeyListener(keyListener);
		textField1.addFocusListener(focusListener);
		textField1.addKeyListener(keyListener);
		textField2.addFocusListener(focusListener);
		textField2.addKeyListener(keyListener);
		textField3.addFocusListener(focusListener);
		textField3.addKeyListener(keyListener);

	}
}
