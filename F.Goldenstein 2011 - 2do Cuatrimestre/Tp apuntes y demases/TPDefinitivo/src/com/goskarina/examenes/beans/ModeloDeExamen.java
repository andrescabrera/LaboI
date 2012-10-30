package com.goskarina.examenes.beans;
import java.util.ArrayList;
import java.util.Date;


public class ModeloDeExamen {
	private Date fechaDeCreacion;
	private ArrayList<Pregunta> nPreguntas = new ArrayList<Pregunta>();
	private ArrayList<Examen> nExamenes = new ArrayList<Examen>();
	private Creador creador;
	
	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}
	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}
	public ArrayList<Pregunta> getnPreguntas() {
		return nPreguntas;
	}
	public void setnPreguntas(ArrayList<Pregunta> nPreguntas) {
		this.nPreguntas = nPreguntas;
	}
	public ArrayList<Examen> getnExamenes() {
		return nExamenes;
	}
	public void setnExamenes(ArrayList<Examen> nExamenes) {
		this.nExamenes = nExamenes;
	}
	
	public Creador getCreador() {
		return creador;
	}
	public void setCreador(Creador creador) {
		this.creador = creador;
	}
	
	
	
	
	
	

}
