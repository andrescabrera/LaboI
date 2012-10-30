package facturacion;

public class Ropa extends Producto {
	
	private String talla;
	
	public Ropa(String nombre, double costo, String talla) {
		super(nombre, costo);
		this.talla = talla;
	}	

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}
	
	public String toString(){
		return (super.toString() + " Tiene una talla: " + talla);
	}
	
}
