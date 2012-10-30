public class Main {

	public static void main(String[] args) {
		
		//imprimo la cantidad de alumnos, aunque no haya ninguna instancia
		System.out.println(Alumno.cantidadDeAlumnos);

		Alumno a1 = new Alumno("Jose Ramirez", 25);
		/*
		 * a1.nombre="Jose Ramirez"; a1.legajo=25;
		 */
		System.out.println(a1.nombre);
		System.out.println(a1.legajo);
		a1.asistir();

		Alumno a2 = new Alumno("Pepe Juarez", 65);
		/*
		 * a2.nombre="Pepe Juarez"; a2.legajo=65;
		 */
		System.out.println(a2.nombre);
		System.out.println(a2.legajo);
		a2.asistir();

		Alumno a3 = new Alumno("José", 28);
		a3.asistir(true);
		Alumno a4 = new Alumno("X", 29);
		a4.asistir(false);

		System.out.println("Probando el IF");
		if (a1.legajo == 25)
			System.out.println("Alumno encontrado");
		else
			System.out.println("No lo encontré");

		System.out.println("Probando el switch");
		int nro = 0;
		switch(nro)
		{
		case 0:
			System.out.println("Es cero");
			break;
		case 1:
			System.out.println("Es uno");
			break;
		// optativo
		default:
			System.out.println("No es cero ni uno");
			// puedo poner el break; o no, ya que no hay cascada hacia abajo
			break;
		}
		
		// va a dar 0 porque es un post-incremento. Imprime y despues hace
		// k=k+1;
		System.out.println("Imprimiendo K - Postincremento");
		int k = 0;
		System.out.println(k++);
		System.out.println(k);
		// PRE-INCREMENTO
		System.out.println("Imprimiendo J - Precincremento");
		int j = 4;
		System.out.println(++j);
		
		// probando el for, creando 50 alumnos
		for(int i=0; i<50; i++)
		{
			Alumno a=new Alumno("a" + i, i);
			a.asistir(true);
		}
		
		for(int i=0; i<50; i++)
		{
			Alumno a = new Alumno("a" + i, i);
			if(a.legajo % 2 == 0) //si es par
				a.asistir(true);
			else
				a.asistir(false);
		}
		//while
		int contador = 0;
		while(contador < 50)
		{
			System.out.println(contador++);
		}
		
		//do-while
		int contador2 = 0;
		do
		{
			System.out.println(contador2++);
		}while(contador2<50);
		
		//el scope es el alcance de las variables (ambito)
		//Mostrando la cantidad de alumnos generados
		System.out.println(Alumno.cantidadDeAlumnos);		
	}
}