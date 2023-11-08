package app;

import javax.swing.JPanel;

public abstract class View extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5072079924861147311L;
	protected App appController;
	public View(App appController) {
		this.appController=appController;
	}
	public abstract void limpiarForm();
}
