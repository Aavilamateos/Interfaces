package app.gui.datePickerController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import app.gui.AppController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.util.converter.LocalDateStringConverter;

public class DatePickerController extends AppController{

	@FXML
	private DatePicker date;
	@FXML
	private Label dateLbl;
	private DateTimeFormatter formatter;
	
	
	@FXML
	public void initialize() {
		formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		date.setConverter(new LocalDateStringConverter(formatter,formatter));
		LocalDate fecha=LocalDate.now();
		date.setValue(fecha);
		
	}
	public void read(ActionEvent event) {
		LocalDate fecha=date.getValue();
		dateLbl.setText(fecha.format(formatter));
	}
	
}
