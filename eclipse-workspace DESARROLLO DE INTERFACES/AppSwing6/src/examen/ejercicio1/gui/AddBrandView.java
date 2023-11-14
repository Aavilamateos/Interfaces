package examen.ejercicio1.gui;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

public class AddBrandView extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1649928976592673683L;
	private JTextField newBrandTf;
	private JComboBox<String> brandsCb;
	private JLabel newBrandLbl; 
	private JLabel brandLbl;
	private JButton addBtn;

	public AddBrandView(App appController) {
		super(appController);
		setLayout(null);
		
		newBrandLbl = new JLabel("Nueva marca: ");
		newBrandLbl.setBounds(130, 155, 98, 14);
		add(newBrandLbl);
		
		newBrandTf = new JTextField();
		newBrandTf.setBounds(220, 152, 86, 20);
		add(newBrandTf);
		newBrandTf.setColumns(10);
		
		brandLbl = new JLabel("Marca: ");
		brandLbl.setBounds(148, 219, 46, 14);
		add(brandLbl);
		
		brandsCb = new JComboBox<String>();
		brandsCb.setBounds(220, 215, 86, 22);
		add(brandsCb);

		
		
		addBtn = new JButton("Añadir");
		addBtn.setBounds(471, 151, 89, 23);
		add(addBtn);
		brandsCb.setSelectedIndex(-1);
		
		ActionListener actionBtn=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appController.addBrand(newBrandTf.getText());
			}
		};
		addBtn.addActionListener(actionBtn);
	}
	public void rellenarCombo(List<String>marcas) {
		brandsCb.removeAllItems();
		for (String string : marcas) {
			brandsCb.addItem(string);
		}
	}

	@Override
	public void limpiarForm() {
		newBrandTf.setText("");
		brandsCb.setSelectedIndex(-1);
	}
}
