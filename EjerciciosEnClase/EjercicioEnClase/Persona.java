import java.util.ArrayList;

public class Persona {

	private String nombre;

	private int edad;

	ArrayList<Auto> nAutos = new ArrayList<Auto>();
	
	//constructores
	public Persona() {
	}

	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;	
	}
	
	public void listarAutos() {
		System.out.println("******* Autos de " + nombre);
		for(Auto a : nAutos){
			System.out.println(a.getModelo() + " " + a.getPrecio());
		}
	}
	
	public double autosEnPlata(){
		double cont = 0;
		
		for(Auto x : nAutos)
			cont += x.getPrecio();
		
		return cont;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public ArrayList<Auto> getNAutos() {
		return nAutos;
	}

	public void setNAutos(ArrayList<Auto> autos) {
		nAutos = autos;
	}

}
