package ejerciciosVentana.ej12A15;

import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class View extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8934267781477346233L;
	protected JTextField textField;
	protected App appController;

	public View(App appController) {
		this.appController = appController;

	}

	public String getTexto() {
		return textField.getText();
	}

	public void setTexto(String msj) {
		textField.setText(msj);
	}
}
