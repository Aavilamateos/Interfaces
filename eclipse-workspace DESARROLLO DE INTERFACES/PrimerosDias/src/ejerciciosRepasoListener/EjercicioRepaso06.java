package ejerciciosRepasoListener;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EjercicioRepaso06 {

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
					EjercicioRepaso06 window = new EjercicioRepaso06();
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
	public EjercicioRepaso06() {
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
		
		JButton botonLimpiar = new JButton("Borrar opciones");
		botonLimpiar.setBounds(271, 108, 89, 23);
		frame.getContentPane().add(botonLimpiar);
		
		JButton botonSelec = new JButton("Seleccionar");
		botonSelec.setEnabled(false);
		botonSelec.setBounds(271, 142, 89, 23);
		frame.getContentPane().add(botonSelec);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(201, 191, 190, 14);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setVisible(false);
		
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
		ActionListener actionLRemove=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				comboBox.removeAllItems();
				botonSelec.setEnabled(false);
				textField.setText("");
				lblNewLabel.setVisible(false);
			}
		};
		ActionListener actionLCombo=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex()!=-1) {
					botonSelec.setEnabled(true);
				}else {
					botonSelec.setEnabled(false);
				}
			}
		};
		ActionListener actionLSelec=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				lblNewLabel.setVisible(true);
				lblNewLabel.setText("Ciudad seleccionada: "+comboBox.getSelectedItem());
			}
		};
		comboBox.addActionListener(actionLCombo);
		botonSelec.addActionListener(actionLSelec);
		botonLimpiar.addActionListener(actionLRemove);
		textField.addKeyListener(keyL);
	}
}
