package examen.ejercicio1.gui;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BrandsTableView extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5220249364301352014L;
	private JTable table;
	private TableModel modelo;

	private JLabel availableBtn;
	private JRadioButton yesRadio;
	private JRadioButton noRadio;
	private JRadioButton allRadio;
	private JButton lookUpBtn;
	private JScrollPane scrollPane;

	public BrandsTableView(App appController) {
		super(appController);
		setLayout(null);

		availableBtn = new JLabel("Sólo disponibles: ");
		availableBtn.setBounds(123, 159, 105, 14);
		add(availableBtn);

		yesRadio = new JRadioButton("Si");
		yesRadio.setBounds(252, 155, 41, 23);
		add(yesRadio);

		noRadio = new JRadioButton("No");
		noRadio.setBounds(295, 155, 41, 23);
		add(noRadio);

		allRadio = new JRadioButton("Todos");
		allRadio.setBounds(338, 155, 63, 23);
		add(allRadio);

		lookUpBtn = new JButton("Consultar");
		lookUpBtn.setBounds(441, 155, 89, 23);
		add(lookUpBtn);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 187, 492, 230);
		add(scrollPane);

		table = new JTable();
		modelo = new TableModel();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		allRadio.setSelected(true);

		ActionListener actionRefresh = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (allRadio.isSelected()) {
					appController.consultarCoches();
				} else if (yesRadio.isSelected()) {
					appController.consultarCochesSi();
				} else if (noRadio.isSelected()) {
					appController.consultarCochesNo();
				}
			}
		};
		ActionListener actionRadio = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == allRadio) {
					yesRadio.setSelected(false);
					noRadio.setSelected(false);
				} else if (e.getSource() == noRadio) {
					allRadio.setSelected(false);
					yesRadio.setSelected(false);
				} else if (e.getSource() == yesRadio) {
					allRadio.setSelected(false);
					noRadio.setSelected(false);
				}
			}
		};
		allRadio.addActionListener(actionRadio);
		yesRadio.addActionListener(actionRadio);
		noRadio.addActionListener(actionRadio);
		lookUpBtn.addActionListener(actionRefresh);
	}

	public TableModel getModelo() {
		return modelo;
	}

	public void setModelo(TableModel modelo) {
		this.modelo = modelo;
	}

	@Override
	public void limpiarForm() {
		modelo.getListaCoches().clear();
		modelo.fireTableDataChanged();
		allRadio.setSelected(true);
	}
}
