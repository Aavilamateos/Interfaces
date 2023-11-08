package ejerciciosVentana.ej17A19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import ejercicio01.modelo.Pelicula;

public class ModeloTabla extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2573805561492114383L;
	private List<Pelicula>listaPelis;
	private List<String>columnas;
	private Comparator<Pelicula> compTitulo = new Comparator<Pelicula>() {

		@Override
		public int compare(Pelicula o1, Pelicula o2) {
			return o1.getTitulo().compareTo(o2.getTitulo());
		}
	};
	private Comparator<Pelicula> compId = new Comparator<Pelicula>() {

		@Override
		public int compare(Pelicula o1, Pelicula o2) {
			return o1.getId().compareTo(o2.getId());
		}
	};
	private Comparator<Pelicula> compLongitud = new Comparator<Pelicula>() {

		@Override
		public int compare(Pelicula o1, Pelicula o2) {
			return o1.getLongitud().compareTo(o2.getLongitud());
		}
	};
	public ModeloTabla() {
		listaPelis=new ArrayList<Pelicula>();
		columnas=new ArrayList<String>();
		columnas.add("Id");
		columnas.add("Titulo");
		columnas.add("Longitud");
	}
	public List<String> getColumnas() {
		return columnas;
	}
	public void setColumnas(List<String> columnas) {
		this.columnas = columnas;
	}
	@Override
	public int getRowCount() {
		return listaPelis.size();
	}

	@Override
	public int getColumnCount() {
		return columnas.size();
	}
	@Override
	public String getColumnName(int column) {
		return columnas.get(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pelicula peli=listaPelis.get(rowIndex);
		String nombreColumn=columnas.get(columnIndex);
		if (nombreColumn.equals("Id")) {
			return peli.getId();
		}if (nombreColumn.equals("Titulo")) {
			return peli.getTitulo();
		}return peli.getLongitud();
	}
	public void ordenar(Integer column) {
		String nombreColumn=columnas.get(column);
		if (nombreColumn.equals("Id")) {
			listaPelis.sort(compId);
		}
		if (nombreColumn.equals("Titulo")) {
			listaPelis.sort(compTitulo);
		}if (nombreColumn.equals("Longitud")) {
			listaPelis.sort(compLongitud);
		}
	}
	public List<Pelicula> getListaPelis() {
		return listaPelis;
	}
	public void setListaPelis(List<Pelicula> listaPelis) {
		this.listaPelis = listaPelis;
	}

}
