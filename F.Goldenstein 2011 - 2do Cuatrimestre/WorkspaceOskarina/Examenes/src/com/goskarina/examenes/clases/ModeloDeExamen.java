package com.goskarina.examenes.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModeloDeExamen {

	private Date fechaDeCreacion;
	private List<Pregunta> preguntasDelExamen = new ArrayList<Pregunta>();
	private List<Examen> examenesRendidos = new ArrayList<Examen>();
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public Date getFechaDeCreacion() {
		return fechaDeCreacion;
	}

	public void setFechaDeCreacion(Date fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public List<Pregunta> getPreguntasDelExamen() {
		return preguntasDelExamen;
	}

	public List<Examen> getExamenesRendidos() {
		return examenesRendidos;
	}

	public void agregarExamenRendido(Examen examen) {
		examenesRendidos.add(examen);
	}

	public void agregarPregunta(Pregunta pregunta) {
		preguntasDelExamen.add(pregunta);
	}
}
