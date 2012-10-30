
package clase3;

import clasex.Direccion;
//import clasex.x; -> importo todas
//private, package, protected (paquete + hijos de otros paquetes), public
public class Persona {

	public String toString() {
		return nombre + " documento: " + documento + " dir "  + direccion.toString();
	}

	String nombre; // -> null

	int documento; // -> 0

	Direccion direccion; // -> null

}
