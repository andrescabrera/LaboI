import java.util.Random;

public class Main {

	/**
	 * @param args
	 */
	/*
	 * importar todo un paquete
	 * import java.util.x;
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			Monitor m = new Monitor("Marca" + i, "Modelo" + i, "Color" + i);
			System.out.println(m);
			/*
			 * System.out.println("Marca " + m.marca);
			 * System.out.println("Modelo " + m.modelo);
			 * System.out.println("Color " + m.color);
			 */

			/*
			 * Sabe que 0.5 es double, porque para numeros con coma el default
			 * es double Sino se especifica 5l -> long 0.5f -> float
			 */
			
			//con la clase Random
			Random r = new Random();
			for (i = 0; i < 10; i++) {
				if(r.nextInt(2) == 0)
				//con la clase Math
				//if (Math.random() < 0.5)
					m.encender();
				else
					m.apagar();
			}

			// System.out.println("PIx2=" + Math.PI*2);
			
			/*
			 * Generar numeros aleatorios entre 100 y 200
			 * Math.random() -> multiplico por 100
			 * r.nextInt(100)+100
			 * 
			 * Clase Random -> sumo 100.
			 */
			for(i=0; i<5; i++)
				System.out.println("Aleatorio vale: " + (r.nextInt(100)+100));
		}
	}

}
