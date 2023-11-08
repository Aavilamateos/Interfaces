package ejerciciosVentana;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiVentana extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MiVentana() {
		super();
		setTitle("Ejemplo MiVentana");

	}

	public void inicializar() {
		setSize(900, 900);
		setLocationRelativeTo(null);

//BASIC------------------------------------------------
//		** creo LAYOUT y se lo cambio a la ventana
//		FlowLayout layout = new FlowLayout();
//		setLayout(layout);

//		** creo y añado BOTON
//		JButton boton = new JButton();
//		boton.setText("Boton");
//
//		** prueba
//		JButton boton2 = new JButton();
//		boton2.setText("Segundo Boton");
//		Integer contador = 0;

//		** crear 10 botones
//		do {
//			contador++;
//			JButton botonBucle = new JButton();
//			botonBucle.setText("Boton" + contador);
//			Container contenedor = getContentPane();
//			contenedor.add(botonBucle);
//		} while (contador != 10);
//		
//		
//		Container contenedor = getContentPane();
//		for (int i = 1; i <= 10; i++) {
//			JButton botonBucle = new JButton();
//			botonBucle.setText("Boton" + i);
//			contenedor.add(botonBucle);
//		}
//
//		** llamo al contenedor CONTENEDOR
//		Container contenedor1 = getContentPane();
//		contenedor1.add(boton);
//		contenedor1.add(boton2);
		
//MENOS BASIC----------------------------------------------------------------------------------

//		**GRIDLAYOUT (tabla, le ponemos cuantas filas y columnas cuando creamos el layout)
		Container contenedor = getContentPane();
		GridLayout layout1 = new GridLayout(4, 2);
		setLayout(layout1);
		
		//creamos un nuevo panel con su layout para dividir la primera celda en una fila y dos columnas
		JPanel nuevoContenedor=new JPanel();
		GridLayout gridPrimeraCelda=new GridLayout(1,2);
		nuevoContenedor.setLayout(gridPrimeraCelda);
		
		contenedor.add(nuevoContenedor);
		
		//añado los dos botones al nuevo contenedor que ocupa la primera posicion
//		for (int i = 1; i <= 2; i++) {
//			JButton botonBucle = new JButton();
//			botonBucle.setText("Boton" + i);
//			nuevoContenedor.add(botonBucle);
//		}
//		for (int i = 1; i <= 7; i++) {
//			JButton botonBucle = new JButton();
//			botonBucle.setText("Boton" + i);
//			contenedor.add(botonBucle);
//		}

		for (int i = 1; i <= 8; i++) {
			if (i!=2) {
				JButton botonBucle = new JButton();
				botonBucle.setText("Boton" + i);
				contenedor.add(botonBucle);
				
			}else {
				for (int j = 1; j <= 2; j++) {
					JButton botonBucle1 = new JButton();
					botonBucle1.setText("Boton" + i);
					nuevoContenedor.add(botonBucle1);
				}
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
//		**crep y añado checkbox
//		JCheckBox checkbox=new JCheckBox();
//		checkbox.setText("Marca aquí");
//		contenedor.add(checkbox);
//		JComboBox<String> combo1=new JComboBox<String>();
//		combo1.setBounds(10,10,80,20);
//		add(combo1);
//		combo1.addItem("rojo");
//		combo1.addItem("verde");
//		combo1.addItem("negro");

		setVisible(true);
	}
}
