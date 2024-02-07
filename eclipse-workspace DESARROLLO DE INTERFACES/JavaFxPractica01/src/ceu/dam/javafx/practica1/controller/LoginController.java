package ceu.dam.javafx.practica1.controller;

import java.text.SimpleDateFormat;

import ceu.dam.javafx.practica1.modelo.Usuario;
import ceu.dam.javafx.practica1.services.LoginDenegadoException;
import ceu.dam.javafx.practica1.services.LoginService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {
	@FXML
	private TextField userTF;
	@FXML
	private PasswordField passF;
	@FXML
	private Label titleLbl;
	@FXML
	private Label accessLbl;
	@FXML
	private Label userLbl;
	@FXML
	private Button botonSalir;
	
	private LoginService service;
	
	
	public void login() {
		try {
			Usuario usu=service.login(userTF.getText(), passF.getText());
			SimpleDateFormat format= new SimpleDateFormat("dd/MM/YYYY");
			userLbl.setText(usu.getNombre()+" "+format.format(usu.getFechaRegistro()));
			accessLbl.setId("USUARIOCORRECTO");
			accessLbl.setText("Acceso permitido");
		} catch (LoginDenegadoException e) {
			accessLbl.setId("USUARIOINCORRECTO");
			accessLbl.setText(e.getMessage());
			userLbl.setText("");
		}
	}
	public void initialize() {
		service=new LoginService();
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				userTF.requestFocus();
			}
		});
	}
	
	public void exit() {
		System.exit(0);
	}
}
