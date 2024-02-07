package app.gui.sliderController;

import app.gui.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;

public class SliderController extends AppController{

	@FXML
	private Slider slider;
	
	@FXML
	private Label sliderLbl;
	
	@FXML
	public void initialize() {
		sliderLbl.setText("");
	}
	
	public void read(ActionEvent event) {
		sliderLbl.setText(String.valueOf(slider.getValue()));
	}
}
