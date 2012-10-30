package com.goskarina.examenes.gui;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.goskarina.examenes.clases.Alumno;

public class ModeloTablaAlumno extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private Vector<Alumno> datos;
	private String nombres[];

	public ModeloTablaAlumno() {
		nombres = new String[] { "Nombre", "Apellido", "Domicilio",
				"Fecha de Nacimiento" };
		datos = new Vector<Alumno>(0);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class getColumnClass(int columna) {
		Object value = getValueAt(0, columna);
		if(value != null) 
			return value.getClass();
		else
			return null;
	}

	@Override
	public String getColumnName(int columna) {
		return nombres[columna];
	}

	@Override
	public int getRowCount() {
		return datos.size();
	}

	@Override
	public int getColumnCount() {
		return nombres.length;
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		if (datos.size() > 0)
			switch (columna) {
			case 0:
				return datos.get(fila).getNombre();
			case 1:
				return datos.get(fila).getApellido();
			case 2:
				return datos.get(fila).getDomicilio();
			case 3:
				return datos.get(fila).getFechaDeNacimiento();
			}
		return "";
	}

	public void agregarAlumno(Alumno alumno) {
		datos.add(alumno);
		fireTableStructureChanged();
	}
}