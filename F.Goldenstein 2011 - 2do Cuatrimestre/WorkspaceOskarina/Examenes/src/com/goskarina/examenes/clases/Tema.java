package com.goskarina.examenes.clases;

import java.util.ArrayList;
import java.util.List;

public class Tema {
	private int codigoTema;
	private String descripcion;
	private List<Pregunta> preguntasDelTema = new ArrayList<Pregunta>();
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public int getCodigoTema() {
		return codigoTema;
	}

	public void setCodigoTema(int codigoTema) {
		this.codigoTema = codigoTema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void agregarPregunta(Pregunta pregunta) {
		preguntasDelTema.add(pregunta);
	}

	public List<Pregunta> getPreguntasDelTema() {
		return preguntasDelTema;
	}

}
