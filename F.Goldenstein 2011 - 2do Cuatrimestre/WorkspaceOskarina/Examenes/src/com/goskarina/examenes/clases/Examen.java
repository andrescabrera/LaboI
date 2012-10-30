package com.goskarina.examenes.clases;

import java.util.ArrayList;
import java.util.List;

public class Examen {

	private Double nota;
	private ModeloDeExamen modeloDeExamen;
	private List<Respuesta> respuestasDelAlumno = new ArrayList<Respuesta>();
	private Alumno alumno;
	private Examinador corrector;
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ModeloDeExamen getModeloDeExamen() {
		return modeloDeExamen;
	}

	public void setModeloDeExamen(ModeloDeExamen modeloDeExamen) {
		this.modeloDeExamen = modeloDeExamen;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public List<Respuesta> getRespuestasDelAlumno() {
		return respuestasDelAlumno;
	}

	public void agregarRespuestaDelAlumno(Respuesta respuesta) {
		respuestasDelAlumno.add(respuesta);
	}

	public Examinador getCorrector() {
		return corrector;
	}

	public void setCorrector(Examinador corrector) {
		this.corrector = corrector;
	}

}
