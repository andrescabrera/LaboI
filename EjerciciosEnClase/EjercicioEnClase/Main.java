import java.util.ArrayList;
//import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
/*
		//Probando HashSet y ArrayList
		//ArrayList<Integer> numeros1 = new ArrayList<Integer>();
		//HashSet<Integer> numeros2 = new HashSet<Integer>();
	
 		// Probando HashSet y ArrayList
		numeros1.add(123);
		numeros1.add(124);
		numeros1.add(123);

		for (Integer x : numeros1) {
			System.out.println(x);
		}

		numeros2.add(123);
		numeros2.add(124);
		numeros2.add(123);

		for (Integer x : numeros2) {
			System.out.println(x);
		}
*/
		
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		personas.add(new Persona("Pepe", 23));
		personas.add(new Persona("Raul", 24));
		
		//creo 3 autos
		Auto auto1 = new Auto("Ford", 500);
		Auto auto2 = new Auto("BMW", 1000);
		Auto auto3 = new Auto("Volkswagen", 300);
				
		personas.get(0).getNAutos().add(auto1);
		personas.get(1).getNAutos().add(auto2);
		personas.get(1).getNAutos().add(auto3);
		
		auto1.setPersona(personas.get(0));
		auto2.setPersona(personas.get(1));
		auto3.setPersona(personas.get(1));
		
		personas.get(0).listarAutos();
		
		for (Persona x : personas) {
			System.out.println(x.getNombre() + " tiene " + x.getEdad() 
					+ " años.");
		}
		
		System.out.println(personas.get(0).getNombre() + " tiene " + personas.get(1).autosEnPlata() + "$ en autos.");

	}

}
