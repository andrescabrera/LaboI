package com.goskarina.examenes.beans;

public class Pregunta {
	private String texto;
	private Tema tema;
	private ModeloDeExamen modeloDeExamen;
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Tema getTema() {
		return tema;
	}
	public void setTema(Tema tema) {
		this.tema = tema;
	}
	public ModeloDeExamen getModeloDeExamen() {
		return modeloDeExamen;
	}
	public void setModeloDeExamen(ModeloDeExamen modeloDeExamen) {
		this.modeloDeExamen = modeloDeExamen;
	}
	
	
	

}
