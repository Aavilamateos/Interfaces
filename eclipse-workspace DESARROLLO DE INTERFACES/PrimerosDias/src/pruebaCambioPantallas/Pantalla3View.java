package pruebaCambioPantallas;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla3View extends View{
	public Pantalla3View(App appController) {
		super(appController);
		setLayout(null);
		
		JLabel Pantalla3 = new JLabel("Pantalla 3");
		Pantalla3.setBounds(97, 79, 112, 14);
		add(Pantalla3);
		
		JButton btnNewButton = new JButton("Ir a pantalla 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appController.irAPantalla1();
			}
		});
		btnNewButton.setBounds(171, 198, 183, 23);
		add(btnNewButton);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 999403824329946180L;
}
