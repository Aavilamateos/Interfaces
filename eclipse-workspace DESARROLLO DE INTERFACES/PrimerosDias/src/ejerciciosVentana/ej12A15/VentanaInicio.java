package ejerciciosVentana.ej12A15;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInicio extends View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4682610986012566311L;

	/**
	 * Create the application.
	 */
	public VentanaInicio(App appController) {
		super(appController);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Bienvenido a mi app");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(108, 63, 190, 40);
		add(lblNewLabel);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appController.irVentana1();
			}
		});
		btnEntrar.setBounds(156, 168, 89, 23);
		add(btnEntrar);
	}

}
