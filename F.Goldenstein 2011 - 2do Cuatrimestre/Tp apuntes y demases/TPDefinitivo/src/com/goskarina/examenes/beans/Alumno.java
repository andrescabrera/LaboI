package com.goskarina.examenes.beans;

import java.util.ArrayList;

public class Alumno extends Persona {
	private ArrayList<Examen> nExamenes = new ArrayList<Examen>();

	public ArrayList<Examen> getnExamenes() {
		return nExamenes;
	}

	public void setnExamenes(ArrayList<Examen> nExamenes) {
		this.nExamenes = nExamenes;
	}
	
	
	
	

}
