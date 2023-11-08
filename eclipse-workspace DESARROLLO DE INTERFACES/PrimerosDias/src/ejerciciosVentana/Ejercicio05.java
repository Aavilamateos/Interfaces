package ejerciciosVentana;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Ejercicio05 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicio05 window = new Ejercicio05();
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
	public Ejercicio05() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton botonOrigen = new JButton("Sumar");
		JLabel labelOrigen = new JLabel("");
		labelOrigen.setHorizontalAlignment(SwingConstants.CENTER);
		botonOrigen.setBounds(0, 0, 484, 149);
		labelOrigen.setBounds(0, 149, 484, 112);
		frame.getContentPane().add(botonOrigen);
		frame.getContentPane().add(labelOrigen);
		
		ActionListener listenerClick=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (labelOrigen.getText().isEmpty()) {
					labelOrigen.setText("1");
				}else {
					labelOrigen.setText(Integer.parseInt(labelOrigen.getText())+1+"");
				}
			}
		};

		botonOrigen.addActionListener(listenerClick);

		
	}
}
