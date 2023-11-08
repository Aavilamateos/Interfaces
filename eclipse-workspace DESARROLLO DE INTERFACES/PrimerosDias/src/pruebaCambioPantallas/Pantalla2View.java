package pruebaCambioPantallas;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla2View extends View{
	public Pantalla2View(App appController) {
		super(appController);
		setLayout(null);
		
		JLabel Pantalla2 = new JLabel("Pantalla 2");
		Pantalla2.setBounds(97, 79, 106, 14);
		add(Pantalla2);
		
		JButton btonP3 = new JButton("Pantalla 3");
		btonP3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appController.irAPantalla3();
			}
		});
		btonP3.setBounds(325, 198, 125, 23);
		add(btonP3);
		
		JButton btnP1 = new JButton("Pantalla 1");
		btnP1.setBounds(0, 198, 125, 23);
		add(btnP1);
		
		JButton btnP2 = new JButton("Pantalla 2");
		btnP2.setBounds(165, 198, 125, 23);
		add(btnP2);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 999403824329946180L;
}
