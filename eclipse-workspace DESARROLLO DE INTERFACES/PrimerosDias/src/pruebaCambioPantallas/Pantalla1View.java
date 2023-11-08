package pruebaCambioPantallas;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla1View extends View{
	public Pantalla1View(App appController) {
		super(appController);
		setLayout(null);
		
		JLabel Pantalla1 = new JLabel("Pantalla 1");
		Pantalla1.setBounds(97, 79, 100, 14);
		add(Pantalla1);
		
		JButton btnNewButton = new JButton("Ir a pantalla 2");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				appController.isAPantalla2();
				
			}
		});
		btnNewButton.setBounds(194, 198, 160, 23);
		add(btnNewButton);
	}
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 999403824329946180L;
}
