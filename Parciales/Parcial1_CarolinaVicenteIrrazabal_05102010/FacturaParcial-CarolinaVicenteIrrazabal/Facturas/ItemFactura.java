package Facturas;

public class ItemFactura {

	private int cantidad;
    private Producto producto;
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	public double calcularSubtotal(){
		
		return cantidad*producto.getCosto();
		
	}
}
