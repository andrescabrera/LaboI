package objetosDeUnAlmacen;
import java.util.ArrayList;

public class ItemFactura extends Factura{
	private int cantidad;
	private ArrayList<Producto> productos = new ArrayList<Producto>();
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	
	public double calcularSubTotal(){
		double total = 0;
		for (Producto p : productos){
			System.out.println("El SubTotal fue: " + p.getCantidad());
		}
		return total;
	}
}
