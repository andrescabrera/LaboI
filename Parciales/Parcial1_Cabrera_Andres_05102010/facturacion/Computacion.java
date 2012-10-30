package facturacion;

public class Computacion extends Producto {
	private String modelo;
		
	public Computacion(String nombre, double costo, String modelo) {
		super(nombre, costo);
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String toString(){
		return (super.toString() + " El modelo es: " + modelo);
	}
}
