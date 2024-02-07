package app.gui.colorPickerController;

import app.gui.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

public class ColorPickerController extends AppController{

	@FXML
	private ColorPicker color;
	@FXML
	private Label colorLbl;
	
	public void change(ActionEvent event) {
		colorLbl.setTextFill(color.getValue());
	}
	@FXML
	public void initialize() {
		
	}
}
