package com.goskarina.examenes.clases;

public class RespuestaMultipleChoice extends Respuesta {
	private int opcionElegida;
	private PreguntaMultipleChoice preguntaDeLaRespuesta;

	public int getOpcionElegida() {
		return opcionElegida;
	}

	public void setOpcionElegida(int opcionElegida) {
		this.opcionElegida = opcionElegida;
	}

	public PreguntaMultipleChoice getPreguntaDeLaRespuesta() {
		return preguntaDeLaRespuesta;
	}

	public void setPreguntaDeLaRespuesta(
			PreguntaMultipleChoice preguntaDeLaRespuesta) {
		this.preguntaDeLaRespuesta = preguntaDeLaRespuesta;
	}

}
