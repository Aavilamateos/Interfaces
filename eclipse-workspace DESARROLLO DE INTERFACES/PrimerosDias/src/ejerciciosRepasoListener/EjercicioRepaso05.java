package ejerciciosRepasoListener;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class EjercicioRepaso05 {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjercicioRepaso05 window = new EjercicioRepaso05();
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
	public EjercicioRepaso05() {
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
		textField.setBounds(43, 92, 130, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel labelCiudad = new JLabel("Nueva ciudad: ");
		labelCiudad.setBounds(43, 50, 130, 14);
		frame.getContentPane().add(labelCiudad);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(271, 75, 120, 22);
		frame.getContentPane().add(comboBox);
		
		lblNewLabel_1 = new JLabel("Destinos disponibles");
		lblNewLabel_1.setBounds(271, 50, 120, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		KeyListener keyL =new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					comboBox.addItem(textField.getText());
					textField.setText("");
					if (comboBox.getSelectedItem()!=null) {
						comboBox.setSelectedItem(null);
					}
				}
				
			}
		};
		
		textField.addKeyListener(keyL);
		
	}
}
