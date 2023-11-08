package ejerciciosVentana.ej16;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4537574371695715880L;

	private List<Persona>listaPersonas;
	
	public ModeloTabla(){
		listaPersonas=new ArrayList<Persona>();
	}
	@Override
	public int getRowCount() {
		return listaPersonas.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}
	@Override
	public String getColumnName(int column) {
		if (column==0) {
			return "Nombre";
		}
			return "Apellido";
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Persona personaFila= listaPersonas.get(rowIndex);
		if (columnIndex==0) {
			return personaFila.getNombre();
		}
			return personaFila.getApellido();
	}
	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}
	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

}
