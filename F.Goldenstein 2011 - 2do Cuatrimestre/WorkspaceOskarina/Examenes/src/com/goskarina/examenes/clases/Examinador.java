package com.goskarina.examenes.clases;

import java.util.Map;

public interface Examinador {
	 
	public void corregirExamen(Examen examen);
	public ModeloDeExamen generarExamen(Map<Tema, Integer> cantidadDePreguntasPorTema);

}
