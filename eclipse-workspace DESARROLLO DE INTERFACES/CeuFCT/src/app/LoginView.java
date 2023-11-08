package app;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginView extends View{
	/**
	 * 
	 */
	private static final long serialVersionUID = 812910255060932419L;
	private JTextField emailTf;
	private JLabel usuarioLbl;
	private JLabel passlbl;
	private JPasswordField passwordField;
	private JButton loginBtn;
	private JButton accesoBtn;
	private JButton salirBtn;
	public LoginView(App appController) {
		super(appController);
		setLayout(null);
		
		usuarioLbl = new JLabel("Email:");
		usuarioLbl.setBounds(247, 102, 95, 26);
		add(usuarioLbl);
		
		emailTf = new JTextField();
		emailTf.setBounds(186, 139, 197, 20);
		add(emailTf);
		emailTf.setColumns(10);
		
		passlbl = new JLabel("Contraseña: ");
		passlbl.setBounds(247, 185, 95, 14);
		add(passlbl);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(247, 286, 95, 23);
		add(loginBtn);
		
		accesoBtn = new JButton("Solicitar Acceso");
		accesoBtn.setBounds(262, 388, 156, 23);
		add(accesoBtn);
		
		salirBtn = new JButton("Salir");
		salirBtn.setBounds(471, 388, 89, 23);
		add(salirBtn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 230, 197, 20);
		add(passwordField);
		ActionListener actionButtons=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==loginBtn) {
					String pass1=String.valueOf(passwordField.getPassword());
					//validarUsuarioLogin();
					if (validarUsuarioLogin()) {
						appController.consultarUser(emailTf.getText(), pass1);
					}
					
						
					
					appController.goBienvenida();
				}else if (e.getSource()==accesoBtn) {
					appController.goAltaUser();
				}else {
					if (JOptionPane.showConfirmDialog(salirBtn, "¿Estás seguro de que quieres salir?", "SALIR",
							JOptionPane.YES_NO_OPTION) == 0) {
						appController.exit();
					}
				}
			}
		};
		KeyListener keyListener=new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		};
		accesoBtn.addActionListener(actionButtons);
		loginBtn.addActionListener(actionButtons);
		salirBtn.addActionListener(actionButtons);
	}
	
			public Boolean validarUsuarioLogin() {
				String pass1=String.valueOf(passwordField.getPassword());
				if (emailTf.getText().isEmpty() && pass1.isEmpty()) {
					return false;
				}else {
					return true;
				}
			}

			@Override
			public void limpiarForm() {
				emailTf.setText("");
				passwordField.setText("");
			}
			
	

}
