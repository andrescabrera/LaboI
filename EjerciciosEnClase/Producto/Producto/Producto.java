package producto;

public class Producto {
	private String nombre;
	private double precio;
	private int cantidad;
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Producto(String nombre, int cantidad, double precio2) 
	{
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio2;
	}
}
