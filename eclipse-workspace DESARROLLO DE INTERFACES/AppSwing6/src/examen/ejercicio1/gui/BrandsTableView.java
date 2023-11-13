package examen.ejercicio1.gui;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class BrandsTableView extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5220249364301352014L;
	private JTable table;
	private TableModel modelo;
	
	

	public BrandsTableView(App appController) {
		super(appController);
		setLayout(null);
		
		
		JLabel availableBtn = new JLabel("Sólo disponibles: ");
		availableBtn.setBounds(141, 159, 105, 14);
		add(availableBtn);
		
		JRadioButton yesRadio = new JRadioButton("Si");
		yesRadio.setBounds(252, 155, 41, 23);
		add(yesRadio);
		
		JRadioButton noRadio = new JRadioButton("No");
		noRadio.setBounds(295, 155, 41, 23);
		add(noRadio);
		
		JRadioButton allRadio = new JRadioButton("Todos");
		allRadio.setBounds(338, 155, 63, 23);
		add(allRadio);
		
		JButton lookUpBtn = new JButton("Consultar");
		lookUpBtn.setBounds(441, 155, 89, 23);
		add(lookUpBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 187, 491, 269);
		add(scrollPane);
		
		table = new JTable();
		modelo=new TableModel();
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
	}
	public void setModelo(TableModel modelo) {
		this.modelo = modelo;
	}

	@Override
	public void limpiarForm() {
	}
}
