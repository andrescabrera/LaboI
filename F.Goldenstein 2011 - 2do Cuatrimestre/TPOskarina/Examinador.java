package Lab1TP;

/**
 * @author acabrera
 * @version 1.0
 * @created 11-oct-2011 06:58:11 p.m.
 */
public class Examinador {

	public Examen m_Examen;

	public Examinador(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param pmc
	 */
	public boolean correccion(Pregunta MultipleChoice pmc){
		return false;
	}

	/**
	 * 
	 * @param temasPreguntas
	 */
	public Examen generarExamen(HashMap<Temas,int> temasPreguntas){
		return null;
	}

}