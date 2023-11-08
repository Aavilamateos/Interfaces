package app;
import javax.swing.JLabel;


import java.awt.Font;

public class BienvenidaView extends View{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2025399528135445700L;
	private JLabel holaLbl;
	public BienvenidaView(App appController) {
		super(appController);
		setLayout(null);
		holaLbl = new JLabel();
		holaLbl.setFont(new Font("Tahoma", Font.PLAIN, 27));
		holaLbl.setBounds(218, 178, 146, 61);
		add(holaLbl);
	}
	@Override
	public void limpiarForm() {
	}
	public void nombreUsuarioLogged() {
		holaLbl.setText("Hola, "+ appController.getUsuarioLogged().getNombre());
	}

	

}
