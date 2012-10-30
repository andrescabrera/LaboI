package general;

public class Utilerias {
	
	public static double aplicarDescuento(double n1, int porc){
		double total = 0;
		total = n1 - ((n1 / 100) * porc);
		return total;
	}
}
