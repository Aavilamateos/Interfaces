package examen.gui;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;

public class ConsultarView extends View {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6797061972846103286L;

	private JTable table;
	private JComboBox<String> marcasCb;
	private JButton newBtn;
	private JButton singOutBtn;
	private TableModel modelo;
	private JLabel sinRegistrosLbl;

	public ConsultarView(App appController) {
		super(appController);
		setLayout(null);
		modelo = new TableModel();

		JLabel marcaLbl = new JLabel("Indique la marca que está buscando: ");
		marcaLbl.setBounds(130, 118, 195, 14);
		add(marcaLbl);

		marcasCb = new JComboBox<String>();
		marcasCb.setBounds(376, 114, 89, 22);
		add(marcasCb);
		marcasCb.addItem("Peugeot");
		marcasCb.addItem("Renault");
		marcasCb.addItem("Seat");
		marcasCb.addItem("Toyota");
		marcasCb.setSelectedIndex(-1);

		newBtn = new JButton("Nuevo");
		newBtn.setBounds(508, 114, 89, 23);
		add(newBtn);

		singOutBtn = new JButton("Cerrar sesión");
		singOutBtn.setBounds(488, 422, 109, 23);
		add(singOutBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 158, 469, 253);
		add(scrollPane);

		table = new JTable();
		table.setModel(modelo);

		scrollPane.setViewportView(table);
		
		sinRegistrosLbl = new JLabel("");
		sinRegistrosLbl.setForeground(new Color(255, 0, 0));
		sinRegistrosLbl.setEnabled(true);
		sinRegistrosLbl.setBounds(130, 143, 249, 14);
		add(sinRegistrosLbl);
		ActionListener actionBtns = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == newBtn) {
					appController.goInsert();
				} else if (e.getSource() == singOutBtn) {
					appController.goLogin();
				}
			}
		};
		ActionListener actionCb = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String item=(String) marcasCb.getSelectedItem();
				appController.consultarCoches(item);
			}
		};
		marcasCb.addActionListener(actionCb);
		singOutBtn.addActionListener(actionBtns);
		newBtn.addActionListener(actionBtns);

	}

	public TableModel getModelo() {
		return modelo;
	}

	public void setModelo(TableModel modelo) {
		this.modelo = modelo;
	}
	public void sinRegistros(String mensaje) {
		sinRegistrosLbl.setText(mensaje);
		sinRegistrosLbl.setVisible(true);
	}
	

	@Override
	public void limpiarForm() {
		marcasCb.setSelectedIndex(-1);
		sinRegistrosLbl.setVisible(false);
		
	}
}
