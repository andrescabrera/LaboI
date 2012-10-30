package objetosDeUnAlmacen;

public class Producto {
	private String nombre;
	private double costo;
	private int cantidad;
	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void agregarCantidad(int x){
		System.out.println("Los productos que se agregaron fueron :");
		System.out.println("Nombre: " + nombre);
		System.out.println("Costo: " + costo);
		System.out.println("Cantidad: " + cantidad);
	}
	
	public boolean quitarCantidad(int x){
		double hay = 0;
		if(cantidad < hay){
			System.out.println(true);
			}
		return false;
		}
	}






	


