package app;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ConsultaRegistroView extends View {
	private static final long serialVersionUID = 2112169948762193517L;
	private JTable table;
	private TableModel modelo;

	public TableModel getModelo() {
		return modelo;
	}

	public void setModelo(TableModel modelo) {
		this.modelo = modelo;
	}

	public ConsultaRegistroView(App appController) {
		super(appController);
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(65, 72, 512, 324);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton searchBtn = new JButton("Refrescar");
		searchBtn.setBounds(447, 406, 130, 23);
		add(searchBtn);
		modelo = new TableModel();
		table.setModel(modelo);

		ActionListener actionBtn = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appController.refreshRegis();
			}
		};
		searchBtn.addActionListener(actionBtn);
	}

	@Override
	public void limpiarForm() {

	}
}
