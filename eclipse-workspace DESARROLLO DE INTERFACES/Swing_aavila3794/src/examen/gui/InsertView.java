package examen.gui;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class InsertView extends View {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4908752632291826576L;
	private JTextField modeloTf;
	private JComboBox<String> marcasCb;
	private JButton minusBtn;
	private JButton plusBtn;
	private JButton okayBtn;
	private JButton cancelbtn;
	private JTextField yearsTf;

	public InsertView(App appController) {
		super(appController);
		setLayout(null);

		JLabel marcaLbl = new JLabel("Marca:");
		marcaLbl.setBounds(176, 148, 46, 14);
		add(marcaLbl);

		JLabel modeloLbl = new JLabel("Modelo:");
		modeloLbl.setBounds(176, 200, 64, 14);
		add(modeloLbl);

		JLabel oldLbl = new JLabel("Antigüedad:");
		oldLbl.setBounds(176, 248, 77, 14);
		add(oldLbl);

		minusBtn = new JButton("-");
		minusBtn.setBounds(279, 243, 46, 18);
		add(minusBtn);

		plusBtn = new JButton("+");
		plusBtn.setBounds(433, 244, 46, 18);
		add(plusBtn);

		marcasCb = new JComboBox<String>();
		marcasCb.setBounds(279, 144, 86, 22);
		add(marcasCb);
		marcasCb.addItem("Peugeot");
		marcasCb.addItem("Renault");
		marcasCb.addItem("Seat");
		marcasCb.addItem("Toyota");
		marcasCb.setSelectedIndex(-1);

		modeloTf = new JTextField();
		modeloTf.setBounds(279, 197, 86, 20);
		add(modeloTf);
		modeloTf.setColumns(10);

		okayBtn = new JButton("Aceptar");
		okayBtn.setBounds(236, 313, 89, 23);
		add(okayBtn);

		cancelbtn = new JButton("Cancelar");
		cancelbtn.setBounds(372, 313, 89, 23);
		add(cancelbtn);

		yearsTf = new JTextField();
		yearsTf.setEditable(false);
		yearsTf.setText("1");
		yearsTf.setHorizontalAlignment(SwingConstants.CENTER);
		yearsTf.setBounds(335, 245, 86, 20);
		add(yearsTf);

		ActionListener actionBtns = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String marca = (String) marcasCb.getSelectedItem();
				if (e.getSource() == okayBtn) {
					appController.crearCoche(marca, modeloTf.getText(), Integer.valueOf(yearsTf.getText()));
				} else if (e.getSource() == cancelbtn) {
					appController.goConsultar();
				}

			}
		};
		ActionListener actionSumarRestar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == plusBtn) {
					if (yearsTf.getText().isEmpty() || yearsTf.getText().isBlank()) {
						yearsTf.setText("1");
					} else {
						yearsTf.setText(Integer.parseInt(yearsTf.getText()) + 1 + "");
					}
				} else if (e.getSource() == minusBtn) {
					if (Integer.parseInt(yearsTf.getText()) > 1) {

						if (yearsTf.getText().isEmpty() || yearsTf.getText().isBlank()) {
							yearsTf.setText("1");
						} else {
							yearsTf.setText(Integer.parseInt(yearsTf.getText()) - 1 + "");
						}
					} else {
						yearsTf.setText("1");
					}
				}
			}
		};

		// Esto es una idea distinta que tenia para que no me petase al restar antes que
		// sumar en los años de antigüedad pero no me ha dado tiempo a implementarla.
//		Integer suma=Integer.valueOf(yearsTf.getText())+1;
//		Integer resta=Integer.valueOf(yearsTf.getText())-1;
//		ActionListener actionWeno=new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				if (e.getSource()==plusBtn) {
//					yearsTf.setText(suma.toString());
//				}else if (e.getSource()==minusBtn) {
//					if (Integer.parseInt(yearsTf.getText()) >= 1) {
//						yearsTf.setText(resta.toString());
//					}
//				}
//			}
//		};
//		minusBtn.addActionListener(actionWeno);
//		plusBtn.addActionListener(actionWeno);
		plusBtn.addActionListener(actionSumarRestar);
		minusBtn.addActionListener(actionSumarRestar);
		okayBtn.addActionListener(actionBtns);
		cancelbtn.addActionListener(actionBtns);

	}

	@Override
	public void limpiarForm() {
		marcasCb.setSelectedIndex(-1);
		modeloTf.setText("");
		yearsTf.setText("");
	}

}
