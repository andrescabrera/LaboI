
public class Alumno {
	//
	static int cantidadDeAlumnos;
	
	//Creo el constructor para cargar directamente
	//Alumno(){} si comento esto no puedo no cargar parametros
	Alumno(){
		cantidadDeAlumnos++;
	}
	
	Alumno(String n, int nro) {
		nombre=n;
		legajo=nro;
		
		cantidadDeAlumnos++;
	}
	
	//variables de estado
	String nombre;
	int legajo;
	
	void asistir()
	{
		System.out.println("Asistio " + nombre);
	}
	//sobrecarga de metodos
	void asistir(boolean puntual)
	{
		if(puntual==true)
			System.out.println("Asistió puntual: " + nombre);
		else
			System.out.println("Asistió impuntual: " + nombre);
	}
	
	
}