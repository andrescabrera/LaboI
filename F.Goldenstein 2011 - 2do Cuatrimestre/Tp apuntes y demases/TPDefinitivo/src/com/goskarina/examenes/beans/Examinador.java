package com.goskarina.examenes.beans;

import java.util.ArrayList;
import java.util.List;

public interface Examinador {
	
	List<Examen> nExamenes = new ArrayList<Examen>(); 
	public Boolean correcion(PreguntaMultipleChoice p);

}
