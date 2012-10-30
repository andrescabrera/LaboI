package Facturas;
import java.util.ArrayList;
import Productos.Producto;
public class ItemFactura {

	Producto pro;
	private int cantidad;
	static int canti;
	private ArrayList<Producto> prod = new ArrayList<Producto>();


	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ArrayList<Producto> getProd() {
		return prod;
	}

	public void setProd(ArrayList<Producto> prod) {
		this.prod = prod;
	}

	// ------------------------------------


	
	/*public double calcularSubtotal() {
		double subt = ((Producto).getCosto()) ;
		return subt;
	
	}*/
	public void ingresarProd(Producto p) {
		prod.add(p);
		canti++;
		System.out.println("ingresado en el item"+canti+" prod: " + p.getNombre() + ": "
				+ cantidad);
	}
	
	
	

}
