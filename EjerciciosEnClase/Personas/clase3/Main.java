
package clase3;

import clasex.Direccion;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			Persona p = new Persona();
			p.nombre="Alberto";
			p.documento=20554556;
			
			Direccion dir = new Direccion();
			dir.calle="Mario Bravo";
			dir.nro=1050;
			dir.localidad="Palermo";
			dir.piso="X";
			
			p.direccion=dir;
			
			//System.out.println(dir);
			System.out.println(p);
}

}
