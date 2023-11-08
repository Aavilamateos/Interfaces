package ejerciciosVentana.ej12A15;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Ventana1 extends View {

	public Ventana1(App appController) {
		super(appController);
		setLayout(null);

		JLabel ventana1 = new JLabel("PANTALLA 1");
		ventana1.setBounds(97, 79, 106, 14);
		add(ventana1);

		JButton btnP2 = new JButton("Pantalla2");
		btnP2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				appController.irVentana2();
			}
		});
		btnP2.setBounds(163, 199, 124, 23);
		add(btnP2);

		JButton btnP1 = new JButton("Pantalla1");
		btnP1.setEnabled(false);
		btnP1.setBounds(0, 199, 124, 23);
		add(btnP1);
		ActionListener actionP3 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appController.irVentana3();
			}
		};

		JButton btnP3 = new JButton("Pantalla3");
		btnP3.setBounds(316, 199, 124, 23);
		add(btnP3);

		textField = new JTextField();
		textField.setBounds(201, 104, 183, 20);
		add(textField);
		textField.setColumns(10);
		btnP3.addActionListener(actionP3);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 999403824329946180L;
}
