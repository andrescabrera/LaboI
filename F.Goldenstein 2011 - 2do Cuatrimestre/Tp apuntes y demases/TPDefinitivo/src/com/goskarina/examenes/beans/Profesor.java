package com.goskarina.examenes.beans;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Profesor extends Persona implements Examinador, Creador {

	@Override
	public Boolean correcion(PreguntaMultipleChoice p) {
		
		return null;
	}

	@Override
	public ModeloDeExamen generarExamen(Map<Tema, Integer> m) {
		ModeloDeExamen modelo = new ModeloDeExamen();
		Iterator itr = m.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry e = (Map.Entry)itr.next();
			Tema tema = (Tema) e.getKey();
			Integer cantidadPreguntas = (Integer) e.getValue();
			//TODO exception: ver si se le pasa mayor cantidad de preguntas que se disponga en el tema
			for(int i = 0; i < cantidadPreguntas; i++){
				modelo.getnPreguntas().add(tema.getnPreguntas().get(i));
			}
		}
		return modelo;
	}
}
	


