
package clasex;

//para las clases puedo utilizar los modificadores public o package (default, no tiene keyword)
public class Direccion {
	
	public String toString(){
		if(piso!=null)
			return calle + " " + nro + " Piso: " + piso + ", " + localidad;
		
		return calle + " " + nro + ", " + localidad;
	}
	//a las variables locales no se les pone modificador de acceso
	String calle;
	String localidad;
	int nro;
	String piso;
}
