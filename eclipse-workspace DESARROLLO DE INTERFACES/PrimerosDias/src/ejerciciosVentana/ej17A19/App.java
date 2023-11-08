package ejerciciosVentana.ej17A19;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import ejercicio01.modelo.Pelicula;
import ejercicio01.service.PeliculasServiceException;
import ejercicio01.service.PeliculasServices;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JCheckBox;

public class App {

	private JFrame frame;
	private JTable table;
	private List<Pelicula> listaPelis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 565, 318);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(182, 47, 357, 221);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		ModeloTabla modelo = new ModeloTabla();
		table.setModel(modelo);

		JButton btnConsultarPelis = new JButton("Consultar Pelis");
		btnConsultarPelis.setBounds(45, 115, 127, 56);
		frame.getContentPane().add(btnConsultarPelis);

		JCheckBox checkId = new JCheckBox("Mostrar id");
		checkId.setSelected(true);
		checkId.setBounds(187, 17, 97, 23);
		frame.getContentPane().add(checkId);

		JCheckBox checkTitulo = new JCheckBox("Mostrar Titulo");
		checkTitulo.setSelected(true);
		checkTitulo.setBounds(301, 17, 97, 23);
		frame.getContentPane().add(checkTitulo);

		JCheckBox checkLongitud = new JCheckBox("Mostrar Longitud");
		checkLongitud.setSelected(true);
		checkLongitud.setBounds(423, 17, 97, 23);
		frame.getContentPane().add(checkLongitud);
		
		
		
		PeliculasServices pelisService = new PeliculasServices();
		ActionListener actionBtnConsultar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					listaPelis = pelisService.consultarPeliculas();
					List<String>listaColumn=new ArrayList<String>();
					modelo.setListaPelis(listaPelis);
					if (checkId.isSelected()) {
						listaColumn.add("Id");
					} if (checkTitulo.isSelected()) {
						listaColumn.add("Titulo");
					}if (checkLongitud.isSelected()) {
						listaColumn.add("Longitud");
					}
					modelo.setColumnas(listaColumn);
					modelo.fireTableStructureChanged();

				} catch (PeliculasServiceException e1) {
					JOptionPane.showMessageDialog(frame, e1.getMessage(), "Error DDBB", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		};
		MouseListener mouseListener = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Integer column=table.columnAtPoint(e.getPoint());
				modelo.ordenar(column);
			}
		};
//		ActionListener actionCheckBox = new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				Integer tamaño = 120;
//				JCheckBox checked = (JCheckBox) e.getSource();
//				if (!checked.isSelected()) {
//					tamaño = 0;
//				}
//
//				if (e.getSource() == checkId) {
//					table.getColumnModel().getColumn(0).setMinWidth(tamaño);
//					table.getColumnModel().getColumn(0).setMaxWidth(tamaño);
//					table.getColumnModel().getColumn(0).setPreferredWidth(tamaño);
//				} else if (e.getSource() == checkTitulo) {
//					table.getColumnModel().getColumn(1).setMinWidth(tamaño);
//					table.getColumnModel().getColumn(1).setMaxWidth(tamaño);
//					table.getColumnModel().getColumn(1).setPreferredWidth(tamaño);
//				} else if (e.getSource() == checkLongitud) {
//					table.getColumnModel().getColumn(2).setMinWidth(tamaño);
//					table.getColumnModel().getColumn(2).setMaxWidth(tamaño);
//					table.getColumnModel().getColumn(2).setPreferredWidth(tamaño);
//				}
//				frame.revalidate();
//			}
//		};
		table.getTableHeader().addMouseListener(mouseListener);
		btnConsultarPelis.addActionListener(actionBtnConsultar);

	}
}
