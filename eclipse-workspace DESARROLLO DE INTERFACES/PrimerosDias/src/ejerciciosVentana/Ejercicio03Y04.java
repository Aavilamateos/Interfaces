package ejerciciosVentana;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ejercicio03Y04 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ejercicio03Y04() {
		super();
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ejercicios 3 y 4");
	}

	public void Ejercicio3Texto() {
		Container contenedor = getContentPane();
		GridLayout layout1 = new GridLayout(4, 1);
		contenedor.setLayout(layout1);
		JLabel jlClick = new JLabel("Pulsa un boton");
		
		//FORMAS de hacer listener
		ActionListener listenerBotones=new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				//PRIMERA---->	JButton botonOrigen=(JButton) e.getSource();
				//SEGUNDA:
				String actionComandOrigen=e.getActionCommand();
				jlClick.setText("Has hecho click en el boton " + actionComandOrigen);
			}
		};
		MouseListener listenerMouse=new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				JButton botonOrigen=(JButton) e.getSource();
				botonOrigen.setBackground(null);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				JButton botonOrigen=(JButton) e.getSource();
				botonOrigen.setBackground(Color.GREEN);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton botonOrigen=(JButton) e.getSource();
				botonOrigen.setText(botonOrigen.getText()+"!");
			}
		};
		for (int i = 1; i <= 3; i++) {
			JButton boton1 = new JButton();
			boton1.addActionListener(listenerBotones);
			boton1.setText(String.valueOf(i));
			//SEGUNDA forma
			boton1.setActionCommand("Boton "+i);
			boton1.addMouseListener(listenerMouse);
			contenedor.add(boton1);
		}
		contenedor.add(jlClick);
		
		
		
		
		setVisible(true);
	}
}
