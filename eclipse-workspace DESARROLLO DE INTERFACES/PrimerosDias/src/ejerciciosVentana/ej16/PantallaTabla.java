package ejerciciosVentana.ej16;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class PantallaTabla {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaTabla window = new PantallaTabla();
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
	public PantallaTabla() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 613, 322);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(109, 34, 179, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(300, 34, 179, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 65, 464, 195);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		ModeloTabla modelo=new ModeloTabla();
		table.setModel(modelo);
		
		
		
		
		KeyListener keyListenerTf1=new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					if (textField.getText().isEmpty()) {
					}else {
						textField.transferFocus();
					}
				}
			}
		};
		KeyListener keyListenerTf2=new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER&&!textField_1.getText().isEmpty()) {
						Persona p1=new Persona();
						p1.setNombre(textField.getText());
						p1.setApellido(textField_1.getText());
						modelo.getListaPersonas().add(p1);
						modelo.fireTableDataChanged();
						textField.setText("");
						textField_1.setText("");
				}
			}
		};
		
		textField.addKeyListener(keyListenerTf1);
		textField_1.addKeyListener(keyListenerTf2);
		
	}
}
