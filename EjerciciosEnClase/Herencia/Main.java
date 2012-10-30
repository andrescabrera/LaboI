/*
 * NO USAR EÑES ni ACÉNTOS -> no se recomienda
 */

/*
 * HERENCIA
 * Las clases abstract están definidas para generalizar (no se pueden instanciar).
 * Nos permite definir metodos abstractos. Ejemplo de avanzar{};
 * Las clases hijas están obligadas a definir los metodos abstractos.
 */

public class Main {
	
	public static void main(String args[])
	{
		//AutoDeportivo es un Auto.
		Autos auto = new AutoDeportivo();
		//Upcasting -> Automatico
		auto.avanzar();
		//por POLIMORFISMO (late - binding)
		System.out.println(auto);
	}
}
