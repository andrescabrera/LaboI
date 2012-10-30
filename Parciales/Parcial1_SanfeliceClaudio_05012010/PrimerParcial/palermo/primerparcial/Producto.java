package palermo.primerparcial;
public class Producto extends Item
{
	private int cantidad;
	private static int totalProductos;
	public Producto(int cantidad, String nombre, double costo)
	{
		this.cantidad=cantidad ;
		this.nombre=nombre ;
		this.costo=costo ;
	}
	public Producto ()
	{
		this.cantidad=0;
	}
	
	public void agregarCantidad(int x)
	{
		if (x>0)
			this.cantidad+=x;
		else
			System.out.println("No se pudo agregar cantidad a producto");
	}
	public boolean quitarCantidad(int x)
	{
		if (x>0 && this.cantidad>=x)
		{
			this.cantidad-=x;
			return true;
		}
		else
		{
			return false;
		}
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public static int getTotalProductos() {
		return totalProductos;
	}
	public static void setTotalProductos(int totalProductos) {
		Producto.totalProductos = totalProductos;
	}
}