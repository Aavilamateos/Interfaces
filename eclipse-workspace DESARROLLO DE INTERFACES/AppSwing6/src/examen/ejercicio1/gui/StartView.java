package examen.ejercicio1.gui;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class StartView extends View{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7147693080050417852L;

	public StartView(App appController) {
		super(appController);
		setLayout(null);
		
		JLabel CarShopLbl = new JLabel("Bienvenido a CarShop");
		CarShopLbl.setHorizontalAlignment(SwingConstants.CENTER);
		CarShopLbl.setForeground(new Color(193, 0, 193));
		CarShopLbl.setFont(new Font("Freestyle Script", Font.PLAIN, 80));
		
		CarShopLbl.setBounds(115, 61, 491, 108);
		add(CarShopLbl);
		
		JLabel termsAndConditionsLbl = new JLabel("Acepta los términos y condiciones ");
		termsAndConditionsLbl.setBounds(234, 250, 219, 14);
		add(termsAndConditionsLbl);
		
		JCheckBox termsAndConditionsCheck = new JCheckBox("");
		termsAndConditionsCheck.setBounds(400, 246, 97, 23);
		add(termsAndConditionsCheck);
		
		JButton enterBtn = new JButton("Entrar");
		enterBtn.setEnabled(false);
		enterBtn.setBounds(285, 296, 108, 31);
		add(enterBtn);
		
		JButton exitBtn = new JButton("Salir");
		exitBtn.setBounds(598, 392, 108, 31);
		add(exitBtn);
		
	}

	@Override
	public void limpiarForm() {
	}
}
