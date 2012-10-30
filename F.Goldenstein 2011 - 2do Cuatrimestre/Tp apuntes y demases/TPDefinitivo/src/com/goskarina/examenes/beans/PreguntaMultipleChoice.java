package com.goskarina.examenes.beans;

import java.util.ArrayList;

public class PreguntaMultipleChoice extends Pregunta {
	private String opciones[];
	private ArrayList<RespuestaMultipleChoice> nRespuestasMultiplesChoicesAlumnos = new ArrayList<RespuestaMultipleChoice>();
	private RespuestaMultipleChoice respuestaMultipleChoiceCorrectas;

	public String[] getOpciones() {
		return opciones;
	}

	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}

	public ArrayList<RespuestaMultipleChoice> getnRespuestasMultiplesChoicesAlumnos() {
		return nRespuestasMultiplesChoicesAlumnos;
	}

	public void setnRespuestasMultiplesChoices(
			ArrayList<RespuestaMultipleChoice> nRespuestasMultiplesChoices) {
		this.nRespuestasMultiplesChoicesAlumnos = nRespuestasMultiplesChoices;
	}

	public RespuestaMultipleChoice getRespuestaMultipleChoiceCorrecta() {
		return respuestaMultipleChoiceCorrectas;
	}

	public void setRespuestaMultipleChoice(
			RespuestaMultipleChoice respuestaMultipleChoice) {
		this.respuestaMultipleChoiceCorrectas = respuestaMultipleChoice;
	}
	
	
	
	
	
	

}
