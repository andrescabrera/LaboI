package com.goskarina.examenes.beans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface Creador  {
	public List<ModeloDeExamen> nModelosDeExamenes = new ArrayList<ModeloDeExamen>();
	public ModeloDeExamen generarExamen(Map<Tema, Integer> m);
}
