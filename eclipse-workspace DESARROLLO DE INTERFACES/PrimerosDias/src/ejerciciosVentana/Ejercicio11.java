package ejerciciosVentana;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ejercicio11 {
	private static final String AZUL = "AZUL";
	private static final String VERDE = "VERDE";
	private static final String ROJO = "ROJO";
	private JFrame frame;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JComboBox<String> combo1;
	private Color color;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio11 window = new Ejercicio11();
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
	public Ejercicio11() {
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
		textField.setBounds(36, 67, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField1 = new JTextField();
		textField1.setBounds(36, 98, 86, 20);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);

		textField2 = new JTextField();
		textField2.setBounds(36, 129, 86, 20);
		frame.getContentPane().add(textField2);
		textField2.setColumns(10);

		textField3 = new JTextField();
		textField3.setBounds(36, 160, 86, 20);
		frame.getContentPane().add(textField3);
		textField3.setColumns(10);

		combo1 = new JComboBox<String>();
		combo1.setBounds(277, 67, 80, 21);
		frame.getContentPane().add(combo1);
		combo1.addItem(ROJO);
		combo1.addItem(VERDE);
		combo1.addItem(AZUL);
		combo1.setFocusable(false);

		JRadioButton radioRojo = new JRadioButton("ROJO");
		radioRojo.setBounds(287, 97, 109, 23);
		frame.getContentPane().add(radioRojo);

		JRadioButton radioVerde = new JRadioButton("VERDE");
		radioVerde.setBounds(287, 128, 109, 23);
		frame.getContentPane().add(radioVerde);

		JRadioButton radioAzul = new JRadioButton("AZUL");
		radioAzul.setBounds(287, 159, 109, 23);
		frame.getContentPane().add(radioAzul);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(radioRojo);
		grupo.add(radioVerde);
		grupo.add(radioAzul);

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
		ItemListener itemListener = new ItemListener() {
			// MANERA BRUTA, MIA (ATRIBUTO COLOR)
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (combo1.getSelectedItem().equals("ROJO")) {
					color = Color.RED;
					radioRojo.setSelected(true);
				} else if (combo1.getSelectedItem().equals("VERDE")) {
					color = Color.GREEN;
					radioVerde.setSelected(true);
				} else if (combo1.getSelectedItem().equals("AZUL")) {
					color = Color.BLUE;
					radioAzul.setSelected(true);
				}
			}
		};
		combo1.addItemListener(itemListener);

		ActionListener actionListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == radioRojo) {
					combo1.setSelectedItem(ROJO);
				} else if (e.getSource() == radioVerde) {
					combo1.setSelectedItem(VERDE);
				} else if (e.getSource() == radioAzul) {
					combo1.setSelectedItem(AZUL);
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
			public void focusGained(FocusEvent e2) {
				JTextField tfColorFocus = new JTextField();
				tfColorFocus = (JTextField) e2.getSource();
				tfColorFocus.setBackground(color);
			}
		};

		radioRojo.addActionListener(actionListener);
		radioVerde.addActionListener(actionListener);
		radioAzul.addActionListener(actionListener);
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
