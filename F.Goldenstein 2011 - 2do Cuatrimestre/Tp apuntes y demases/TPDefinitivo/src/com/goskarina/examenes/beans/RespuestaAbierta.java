package com.goskarina.examenes.beans;

public class RespuestaAbierta extends Respuesta{
	private String texto;
	private PreguntaAbierta preguntaAbierta;
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public PreguntaAbierta getPreguntaAbierta() {
		return preguntaAbierta;
	}
	public void setPreguntaAbierta(PreguntaAbierta preguntaAbierta) {
		this.preguntaAbierta = preguntaAbierta;
	}
	
	

}
