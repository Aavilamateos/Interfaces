package examen.ejercicio1.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import examen.ejercicio1.modelo.Coche;


public class TableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3961149565771427964L;

	private List<String>columnas;
	private List<Coche>listaCoches;
	
	public TableModel() {
		columnas=new ArrayList<String>();
		columnas.add("Marca");
		columnas.add("Modelo");
		columnas.add("Matrícula");
		columnas.add("Año");
		columnas.add("Disponible");
		listaCoches=new ArrayList<Coche>();
	}
	public List<String> getColumnas() {
		return columnas;
	}
	public void setColumnas(List<String> columnas) {
		this.columnas = columnas;
	}
	public List<Coche> getListaCoches() {
		return listaCoches;
	}
	public void setListaCoches(List<Coche> listaCoches) {
		this.listaCoches = listaCoches;
	}
	@Override
	public int getRowCount() {
		return listaCoches.size();
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
		Coche coche=listaCoches.get(rowIndex);
		String nombreColumn=columnas.get(columnIndex);
		if (nombreColumn.equals("Marca")) {
			return coche.getMarca();
		}if (nombreColumn.equals("Modelo")) {
			return coche.getModelo();
		}if (nombreColumn.equals("Matrícula")) {
			return coche.getMatricula();
		}if (nombreColumn.equals("Año")) {
			return coche.getAño();
		}return coche.getDisponible();
	}

}
