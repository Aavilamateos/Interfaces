package app;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSlider;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ceufct.modelo.Registro;

public class NuevoRegistroView extends View{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1498073277708989299L;
	private JSlider hoursSlider;
	private JComboBox<String> dateCombo;
	private JTextArea textAreaTasks;
	private JLabel sliderLbl;
	public NuevoRegistroView(App appController) {
		super(appController);
		setLayout(null);
		
		JLabel dateLbl = new JLabel("Fecha:");
		dateLbl.setBounds(136, 97, 46, 14);
		add(dateLbl);
		
		dateCombo = new JComboBox<String>();
		dateCombo.setBounds(136, 122, 160, 22);
		add(dateCombo);
		
		JLabel hoursLbl = new JLabel("Horas:");
		hoursLbl.setBounds(136, 155, 46, 14);
		add(hoursLbl);
		
		hoursSlider = new JSlider();
		hoursSlider.setMaximum(16);
		hoursSlider.setMajorTickSpacing(5);
		hoursSlider.setMinorTickSpacing(1);
		hoursSlider.setPaintTicks(true);
		hoursSlider.setValue(0);
		hoursSlider.setBounds(136, 180, 219, 26);
		add(hoursSlider);
		
		JLabel tasksLbl = new JLabel("Tareas Realizadas:");
		tasksLbl.setBounds(136, 230, 160, 14);
		add(tasksLbl);
		
		JButton acceptBtn = new JButton("Aceptar");
		acceptBtn.setBounds(378, 399, 89, 23);
		add(acceptBtn);
		
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.setBounds(494, 399, 89, 23);
		add(cancelBtn);
		
		
		sliderLbl = new JLabel();
		sliderLbl.setBounds(378, 180, 46, 14);
		add(sliderLbl);
		ChangeListener changeSlider=new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				BigDecimal valor= new BigDecimal(hoursSlider.getValue()).divide(new BigDecimal(2),1,RoundingMode.HALF_DOWN);
				sliderLbl.setText(valor.toString());
			}
		};
		hoursSlider.addChangeListener(changeSlider);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(136, 255, 321, 110);
		add(scrollPane);
		
		textAreaTasks = new JTextArea();
		textAreaTasks.setLineWrap(true);
		scrollPane.setViewportView(textAreaTasks);
		ActionListener actionBtn=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource()==acceptBtn) {
					Registro regis=new Registro();
					DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate fechaFormateada=LocalDate.parse((String) dateCombo.getSelectedItem(), formato);
					regis.setFecha(fechaFormateada);
					regis.setId_usuario(appController.getUsuarioLogged().getId_usuario());
					regis.setNum_horas(new BigDecimal(hoursSlider.getValue()));
					regis.setDescripcion(textAreaTasks.getText());
					appController.insertarRegistros(regis);
					appController.goNuevoRegistro();
				}else if (e.getSource()==cancelBtn) {
					appController.goBienvenida();
				}
			}
		};
		acceptBtn.addActionListener(actionBtn);
		cancelBtn.addActionListener(actionBtn);
	}
	public JComboBox<String> getDateCombo() {
		return dateCombo;
	}
	public void setDateCombo(JComboBox<String> dateCombo) {
		this.dateCombo = dateCombo;
	}
	@Override
	public void limpiarForm() {
		hoursSlider.setValue(0);
		dateCombo.setSelectedIndex(-1);
		sliderLbl.setText("");
		textAreaTasks.setText("");
	}
}
