package com.goskarina.examenes.beans;

public class RespuestaMultipleChoice extends Respuesta{
	private int opcion;
	private PreguntaMultipleChoice preguntaMultipleChoice;
	
	public int getOpcion() {
		return opcion;
	}
	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	public PreguntaMultipleChoice getPreguntaMultipleChoice() {
		return preguntaMultipleChoice;
	}
	public void setPreguntaMultipleChoice(
			PreguntaMultipleChoice preguntaMultipleChoice) {
		this.preguntaMultipleChoice = preguntaMultipleChoice;
	}
	
	
	

}
