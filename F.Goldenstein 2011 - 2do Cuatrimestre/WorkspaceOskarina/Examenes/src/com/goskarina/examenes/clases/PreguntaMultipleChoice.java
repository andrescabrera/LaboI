package com.goskarina.examenes.clases;

public class PreguntaMultipleChoice extends Pregunta {
	private String opciones[];
	private String opcionCorrecta;
	
	public String[] getOpciones() {
		return opciones;
	}

	public void setOpciones(String[] opciones) {
		this.opciones = opciones;
	}

	public String getOpcionCorrecta() {
		return opcionCorrecta;
	}

	public void setOpcionCorrecta(String opcionCorrecta) {
		this.opcionCorrecta = opcionCorrecta;
	}
}
