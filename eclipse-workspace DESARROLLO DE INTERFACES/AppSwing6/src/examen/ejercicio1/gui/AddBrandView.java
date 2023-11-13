package examen.ejercicio1.gui;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AddBrandView extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1649928976592673683L;
	private static final String SEAT = "Seat";
	private static final String TOYOTA = "Toyota";
	private static final String RENAULT = "Renault";
	
	private JTextField newBrandTf;
	private JComboBox<String> brandsCb;
	private JLabel newBrandLbl; 
	private JLabel brandLbl;
	private JButton addBtn;

	public AddBrandView(App appController) {
		super(appController);
		setLayout(null);
		
		newBrandLbl = new JLabel("Nueva marca: ");
		newBrandLbl.setBounds(148, 155, 98, 14);
		add(newBrandLbl);
		
		newBrandTf = new JTextField();
		newBrandTf.setBounds(220, 152, 86, 20);
		add(newBrandTf);
		newBrandTf.setColumns(10);
		
		brandLbl = new JLabel("Marca: ");
		brandLbl.setBounds(148, 219, 46, 14);
		add(brandLbl);
		
		brandsCb = new JComboBox<String>();
		brandsCb.setBounds(276, 215, 30, 22);
		add(brandsCb);
		brandsCb.addItem(SEAT);
		brandsCb.addItem(TOYOTA);
		brandsCb.addItem(RENAULT);
		
		addBtn = new JButton("Añadir");
		addBtn.setBounds(471, 151, 89, 23);
		add(addBtn);
		
	}

	@Override
	public void limpiarForm() {
	}
}
