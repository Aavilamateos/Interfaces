package app.gui.combobox;

import app.gui.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ComboBoxController extends AppController{
	
	@FXML
	private ComboBox<String> combo;
	
	@FXML
	private Label comboLbl;
	
	@FXML
	public void initialize() {
		combo.getItems().add("Blas");
		combo.getItems().add("Pabs");
		combo.getItems().add("Albs");
		combo.getItems().add("Lals");
	}
	
	public void clear(ActionEvent event) {
		comboLbl.setText("");
		combo.getSelectionModel().clearSelection();
	}
	public void print(ActionEvent event) {
		comboLbl.setText(combo.getSelectionModel().getSelectedItem().toString());
	}
}
