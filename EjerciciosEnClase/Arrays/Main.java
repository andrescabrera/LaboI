import java.util.Arrays;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int[] numeros = new int[4];
		
		//System.out.println(numeros[0]);
		//System.out.println(numeros[2]);
		numeros[2] = 22;
		
		//System.out.println(numeros[2]);
		System.out.println("Todo el array");
		
		/*
		for(int i=0; i<numeros.length; i++)
			System.out.println(numeros[i]);
		*/
		
		/*
		 *	FOREACH - a partir de Java 1.5
		 *	for(int numero: numeros)
		 *	System.out.println(numero);
		 */
			
		for(int numero: numeros)
		{
			if(numero == 22)
			{
				System.out.println(numero);
				break;
			}
			else
				System.out.println("No es 22");
		}
		
		System.out.println("\n");
		for(int numero: numeros)
			System.out.println(numero);
		
		System.out.println("\n");
		//Clase Arrays - facilita el ordenamiento
		Arrays.sort(numeros);
		
		for(int numero: numeros)
			System.out.println(numero);
		
		System.out.println("\n");
		System.out.println(numeros);
		
		String[] palabras = new String[4];
		
		for(int i = 0; i< palabras.length; i++)
			palabras[i] = "pal"+i;
		
		for(String pal: palabras)
			System.out.println(pal);
		
		String[] ps = { "pal1", "pal2", "pal3", "pal4" };
				
		for(String pal: ps)
			System.out.println(pal);
	}
}

/*
 * En la clas CdMusica: private Cancion[] canciones = new Cancion[10];
 */

/*
 * NO USAR EÑES ni ACÉNTOS -> no se recomienda
 */

/*
 * HERENCIA
 * Las clases abstract están definidas para generalizar (no se pueden instanciar).
 * Nos permite definir metodos abstractos. Ejemplo de avanzar{};
 * Las clases hijas están obligadas a definir los metodos abstractos.
 */
 
