package ejerciciosVentana;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ejercicio06 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio06 window = new Ejercicio06();
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
	public Ejercicio06() {
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
		
		JButton botonOrigen = new JButton("Sumar");
		JTextField tFOrigen = new JTextField("");
		tFOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		botonOrigen.setBounds(0, 0, 434, 149);
		tFOrigen.setBounds(0, 149, 434, 112);
		frame.getContentPane().add(botonOrigen);
		frame.getContentPane().add(tFOrigen);
		
		ActionListener listenerClick=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (tFOrigen.getText().isEmpty()) {
						tFOrigen.setText("1");
					}else {
						tFOrigen.setText(Integer.parseInt(tFOrigen.getText())+1+"");
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(frame, "NO SE ADMITEN LETRAS", "ERROR", JOptionPane.ERROR_MESSAGE);
					tFOrigen.setText("");
				}
				
			}
		};

		botonOrigen.addActionListener(listenerClick);
	}

}
