package com.goskarina.examenes.gui;



import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.goskarina.examenes.clases.Examen;

public class ModeloTablaExamen extends AbstractTableModel {
	private double nota;
	private Vector<Examen> nExamenes;
	
	public ModeloTablaExamen() {
		nExamenes = new Vector<Examen>(0);
		
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		if(nExamenes.size() > 0)
			switch (columna) {
			case 0:
				return nExamenes.get(fila).getAlumno();
			case 1:
				return nExamenes.get(fila).getNota();
			case 2:
				return nExamenes.get(fila).getModeloDeExamen();
			case 3:
				return nExamenes.get(fila).getRespuestasDelAlumno();
			case 4:
				return nExamenes.get(fila).getCorrector();
			}
		return "";
	}
	
	public void agregarExamen(Examen examen) {
		nExamenes.add(examen);
		fireTableStructureChanged();
	}

}
