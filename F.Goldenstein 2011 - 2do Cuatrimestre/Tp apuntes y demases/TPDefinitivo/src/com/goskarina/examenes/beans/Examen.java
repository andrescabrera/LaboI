package com.goskarina.examenes.beans;

import java.util.ArrayList;

public class Examen {
	private double nota;
	private ModeloDeExamen modeloDeExamen;
	private ArrayList<Respuesta> nRespuestas = new ArrayList<Respuesta>();
	private Alumno alumno;
	private Examinador examinador;
	
	
	
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public ModeloDeExamen getModeloDeExamen() {
		return modeloDeExamen;
	}
	public void setModeloDeExamen(ModeloDeExamen modeloDeExamen) {
		this.modeloDeExamen = modeloDeExamen;
	}
	public ArrayList<Respuesta> getnRespuestas() {
		return nRespuestas;
	}
	public void setnRespuestas(ArrayList<Respuesta> nRespuestas) {
		this.nRespuestas = nRespuestas;
	}
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Examinador getExaminador() {
		return examinador;
	}
	public void setExaminador(Examinador examinador) {
		this.examinador = examinador;
	}
	
	
	
	

}
