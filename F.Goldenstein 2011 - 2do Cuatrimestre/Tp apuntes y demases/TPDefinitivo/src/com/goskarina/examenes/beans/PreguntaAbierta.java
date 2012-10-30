package com.goskarina.examenes.beans;

import java.util.ArrayList;

public class PreguntaAbierta extends Pregunta {
	private ArrayList<RespuestaAbierta> nRespuestasAbiertas = new ArrayList<RespuestaAbierta>();

	public ArrayList<RespuestaAbierta> getnRespuestasAbiertas() {
		return nRespuestasAbiertas;
	}

	public void setnRespuestasAbiertas(
			ArrayList<RespuestaAbierta> nRespuestasAbiertas) {
		this.nRespuestasAbiertas = nRespuestasAbiertas;
	}
	
	

}
