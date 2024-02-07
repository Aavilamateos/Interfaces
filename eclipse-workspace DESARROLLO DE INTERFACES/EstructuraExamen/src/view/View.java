package view;

import javax.swing.JPanel;

public abstract class View extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2118299654730994785L;
	protected App appController;
	public View(App appController) {
		this.appController=appController;
	}
	public abstract void limpiarForm();
}
