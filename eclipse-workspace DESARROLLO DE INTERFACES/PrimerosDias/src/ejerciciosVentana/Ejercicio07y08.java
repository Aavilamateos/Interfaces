package ejerciciosVentana;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Ejercicio07y08 {

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
					Ejercicio07y08 window = new Ejercicio07y08();
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
	public Ejercicio07y08() {
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
		
		KeyListener keyListener=new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_DOWN||e.getKeyCode()==KeyEvent.VK_ENTER) {
					JTextField tfAbajo=new JTextField();
					tfAbajo=(JTextField) e.getSource();
					tfAbajo.transferFocus();	
				}
				else if (e.getKeyCode()==KeyEvent.VK_UP) {
					JTextField tfArriba=new JTextField();
					tfArriba=(JTextField) e.getSource();
					tfArriba.transferFocusBackward();
				}
			}
		};
		
		
		textField.addKeyListener(keyListener);
		textField1.addKeyListener(keyListener);
		textField2.addKeyListener(keyListener);
		textField3.addKeyListener(keyListener);
		
	}
}
