package app;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import ceufct.modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class AltaUserView extends View {
	private static final long serialVersionUID = 6789025492617963361L;
	private JTextField emailTf;
	private JTextField nameTf;
	private JTextField lastNameTf;
	private JPasswordField passF;
	private JPasswordField repPassF;
	private JComboBox<String> courseCombo;
	private JButton acceptBtn;
	private JButton cancelBtn;

	public AltaUserView(App appController) {
		super(appController);
		setLayout(null);

		JLabel emailLbl = new JLabel("Email:");
		emailLbl.setBounds(195, 80, 238, 14);
		add(emailLbl);

		JLabel passLbl = new JLabel("Contraseña:");
		passLbl.setBounds(195, 140, 238, 14);
		add(passLbl);

		JLabel passRepeatLbl = new JLabel("Repetir contraseña:");
		passRepeatLbl.setBounds(195, 192, 238, 14);
		add(passRepeatLbl);

		JLabel nameLbl = new JLabel("Nombre:");
		nameLbl.setBounds(195, 238, 238, 14);
		add(nameLbl);

		JLabel lastNameLbl = new JLabel("Apellidos:");
		lastNameLbl.setBounds(195, 288, 238, 14);
		add(lastNameLbl);

		JLabel courseLbl = new JLabel("Ciclo formativo:");
		courseLbl.setBounds(195, 331, 238, 14);
		add(courseLbl);

		emailTf = new JTextField();
		emailTf.setBounds(195, 99, 238, 20);
		add(emailTf);
		emailTf.setColumns(10);

		nameTf = new JTextField();
		nameTf.setColumns(10);
		nameTf.setBounds(195, 252, 238, 20);
		add(nameTf);

		lastNameTf = new JTextField();
		lastNameTf.setColumns(10);
		lastNameTf.setBounds(195, 300, 238, 20);
		add(lastNameTf);

		courseCombo = new JComboBox<String>();
		courseCombo.setBounds(195, 349, 238, 22);
		add(courseCombo);
		courseCombo.addItem("DAM");
		courseCombo.addItem("DAW");
		courseCombo.addItem("ASIR");
		courseCombo.setSelectedIndex(-1);

		acceptBtn = new JButton("Aceptar");
		acceptBtn.setBounds(356, 410, 89, 23);
		add(acceptBtn);

		cancelBtn = new JButton("Cancelar");
		cancelBtn.setBounds(484, 410, 89, 23);
		add(cancelBtn);

		passF = new JPasswordField();
		passF.setBounds(195, 165, 238, 20);
		add(passF);

		repPassF = new JPasswordField();
		repPassF.setBounds(195, 207, 238, 20);
		add(repPassF);
		ActionListener actionBtn = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == acceptBtn) {

					if (validar()) {
						Usuario u = new Usuario();
						String curso = String.valueOf(courseCombo.getSelectedItem());
						String pass1 = String.valueOf(passF.getPassword());
						u.setEmail(emailTf.getText());
						u.setApellidos(lastNameTf.getText());
						u.setNombre(nameTf.getText());
						u.setCiclo(curso);
						u.setPassword(pass1);
						appController.altaUser(u);
					}
					appController.goLogin();
				} else {
					appController.goLogin();
				}
			}
		};
		acceptBtn.addActionListener(actionBtn);
		cancelBtn.addActionListener(actionBtn);
	}

	public Boolean validar() {
		String pass1 = String.valueOf(passF.getPassword());
		String pass2 = String.valueOf(repPassF.getPassword());
		if (pass1.equals(pass2) && !pass1.isEmpty() && !pass2.isEmpty() && !emailTf.getText().isEmpty()
				&& !nameTf.getText().isEmpty() && !lastNameTf.getText().isEmpty()
				&& courseCombo.getSelectedItem() != null) {
			return true;
		} else {
			JOptionPane.showMessageDialog(acceptBtn, "Error al registrar usuario");
			return false;
		}
	}

	@Override
	public void limpiarForm() {
		emailTf.setText("");
		lastNameTf.setText("");
		nameTf.setText("");
		courseCombo.setSelectedIndex(-1);
		passF.setText("");
		repPassF.setText("");
	}
}
