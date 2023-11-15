package examen.gui;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class LoginView extends View {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7157176771691890596L;

	private JTextField hiddenTf;
	private JLabel carCollectionLbl;
	private JLabel tipoAccesoLbl;
	private JRadioButton anonimoRadio;
	private JRadioButton identiRadio;
	private JButton enterBtn;
	private JButton exitBtn;
	private JLabel errorLbl;

	public LoginView(App appController) {
		super(appController);
		setLayout(null);

		carCollectionLbl = new JLabel("Bienvenido a CarCollection");
		carCollectionLbl.setForeground(new Color(128, 0, 255));
		carCollectionLbl.setFont(new Font("Playbill", Font.PLAIN, 70));
		carCollectionLbl.setHorizontalAlignment(SwingConstants.CENTER);
		carCollectionLbl.setBounds(123, 102, 473, 99);

		add(carCollectionLbl);

		tipoAccesoLbl = new JLabel("Elija el tipo de acceso");
		tipoAccesoLbl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tipoAccesoLbl.setBounds(218, 315, 146, 14);
		add(tipoAccesoLbl);

		anonimoRadio = new JRadioButton("Anónimo");
		anonimoRadio.setBounds(218, 347, 109, 23);
		add(anonimoRadio);

		identiRadio = new JRadioButton("Identificación: ");
		identiRadio.setBounds(218, 389, 109, 23);
		add(identiRadio);

		enterBtn = new JButton("Entrar");
		enterBtn.setEnabled(false);
		enterBtn.setBounds(568, 389, 89, 23);
		add(enterBtn);

		exitBtn = new JButton("Salir");
		exitBtn.setBounds(568, 423, 89, 23);
		add(exitBtn);

		hiddenTf = new JTextField();
		hiddenTf.setEnabled(false);
		hiddenTf.setBounds(333, 390, 86, 20);
		add(hiddenTf);
		hiddenTf.setColumns(10);

		errorLbl = new JLabel("");
		errorLbl.setEnabled(false);
		errorLbl.setForeground(new Color(255, 0, 0));
		errorLbl.setBounds(218, 419, 309, 14);
		add(errorLbl);

		ActionListener actionRadios = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == anonimoRadio) {
					identiRadio.setSelected(false);
					enterBtn.setEnabled(true);
				} else if (e.getSource() == identiRadio) {
					if (!identiRadio.isSelected()) {
						hiddenTf.setEnabled(false);
					}
					anonimoRadio.setSelected(false);
					hiddenTf.setEnabled(true);
					enterBtn.setEnabled(true);
				}
			}
		};

		ActionListener actionBtns = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getSource() == exitBtn) {
					appController.exit();
				} else if (e.getSource() == enterBtn) {
					if (anonimoRadio.isSelected()) {
						appController.goConsultar();
					} else {
						appController.login(hiddenTf.getText());
					}
				}

			}
		};
		exitBtn.addActionListener(actionBtns);
		enterBtn.addActionListener(actionBtns);
		anonimoRadio.addActionListener(actionRadios);
		identiRadio.addActionListener(actionRadios);

	}

	public void setErrorText(String mensaje) {
		errorLbl.setText(mensaje);
		errorLbl.setEnabled(true);
	}

	@Override
	public void limpiarForm() {
		errorLbl.setEnabled(false);
		errorLbl.setText("");
		anonimoRadio.setSelected(false);
		identiRadio.setSelected(false);
		enterBtn.setEnabled(false);
		hiddenTf.setEnabled(false);
		hiddenTf.setText("");
	}
}
