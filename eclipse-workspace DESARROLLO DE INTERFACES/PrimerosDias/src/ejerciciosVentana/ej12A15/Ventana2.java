package ejerciciosVentana.ej12A15;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Ventana2 extends View {
	public Ventana2(App appController) {
		super(appController);
		setLayout(null);

		JLabel Pantalla2 = new JLabel("PANTALLA 2");
		Pantalla2.setBounds(97, 79, 106, 14);
		add(Pantalla2);

		JButton btonP3 = new JButton("Pantalla 3");
		btonP3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				appController.irVentana3();

			}
		});
		ActionListener actionP1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				appController.irVentana1();
			}
		};
		btonP3.setBounds(325, 198, 125, 23);
		add(btonP3);

		JButton btnP1 = new JButton("Pantalla 1");
		btnP1.setBounds(0, 198, 125, 23);
		add(btnP1);
		btnP1.addActionListener(actionP1);

		JButton btnP2 = new JButton("Pantalla 2");
		btnP2.setEnabled(false);
		btnP2.setBounds(165, 198, 125, 23);
		add(btnP2);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(218, 120, 183, 20);
		add(textField);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 999403824329946180L;
}
