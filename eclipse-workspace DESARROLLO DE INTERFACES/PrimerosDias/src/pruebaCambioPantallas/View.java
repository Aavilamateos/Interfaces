package pruebaCambioPantallas;

import javax.swing.JPanel;

public abstract class View extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7869461516521885424L;
	
	protected App appController;
	
	public View(App appController) {
		this.appController=appController;
	}
}
