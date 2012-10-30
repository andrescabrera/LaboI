package principal;

import productos.Productos;

public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Productos p1 = new Productos();
		p1.setPrecio(1000);
		p1.calcularPrecio(21, 500);
	}
	
}
