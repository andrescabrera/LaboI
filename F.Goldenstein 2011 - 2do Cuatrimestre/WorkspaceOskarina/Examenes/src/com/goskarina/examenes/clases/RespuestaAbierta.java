package com.goskarina.examenes.clases;

public class RespuestaAbierta extends Respuesta {
	private String texto;
	private PreguntaAbierta preguntaDeLaRespuesta;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public PreguntaAbierta getPreguntaDeLaRespuesta() {
		return preguntaDeLaRespuesta;
	}

	public void setPreguntaDeLaRespuesta(PreguntaAbierta preguntaDeLaRespuesta) {
		this.preguntaDeLaRespuesta = preguntaDeLaRespuesta;
	}
}
