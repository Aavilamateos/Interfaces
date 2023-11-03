package app;

import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ceufct.modelo.Registro;

public class TableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8030253471978295450L;
	private List<Registro>listaRegistro;
	private List<String>columnas;
	
	public TableModel() {
		listaRegistro=new ArrayList<Registro>();
		columnas=new ArrayList<String>();
		columnas.add("Fecha");
		columnas.add("Horas");
		columnas.add("Descripción");
	}

	public List<Registro> getListaRegistro() {
		return listaRegistro;
	}

	public void setListaRegistro(List<Registro> listaRegistro) {
		this.listaRegistro = listaRegistro;
	}

	public List<String> getColumnas() {
		return columnas;
	}

	public void setColumnas(List<String> columnas) {
		this.columnas = columnas;
	}

	@Override
	public int getRowCount() {
		return listaRegistro.size();
	}

	@Override
	public int getColumnCount() {
		return columnas.size();
	}
	public String getColumnName(int column) {
		return columnas.get(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Registro regis=listaRegistro.get(rowIndex);
		String nombreColumn=columnas.get(columnIndex);
		if (nombreColumn.equals("Fecha")) {
			return regis.getFecha().format(formato);
		}if (nombreColumn.equals("Horas")) {
			return regis.getNum_horas().setScale(1, RoundingMode.HALF_DOWN);
		}return regis.getDescripcion();
	}

}
