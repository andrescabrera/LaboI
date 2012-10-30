package general;

import personas.Estudiante;
import personas.Materia;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Estudiante E=new Estudiante();
		E.setNombre("Juan");
		
		Materia M=new Materia();
		M.setNombre("Jaua");
		E.Estudiar(M);
	}

}
