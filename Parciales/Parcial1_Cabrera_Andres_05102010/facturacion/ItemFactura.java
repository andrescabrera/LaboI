package facturacion;

import general.Utilerias;

public class ItemFactura {
	private int cantidad;

	private Factura factura;

	private Producto itemProducto;

	public ItemFactura(int cantidad, Producto itemProducto, Factura factura) {
		// TODO stock ----------------
		if (itemProducto.quitarCantidad(cantidad) == true) {
			this.factura = factura;
			this.cantidad = cantidad;
			this.itemProducto = itemProducto;
			itemProducto.getNItems().add(this);
		} else {
			System.out.println("Disculpe, el producto " + itemProducto.getNombre() +  " no dispone de stock.");
		}
		// stock ------------------------
	}

	public double calcularSubtotal() {
		double subtotal = 0;
		double descuento;
		//Aplico el descuento
		descuento = Utilerias.aplicarDescuento(itemProducto.getCosto(), Producto.getDescuento());
		subtotal = cantidad * descuento;
		return subtotal;
	}

	public int getCantidad() {
		return cantidad;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
}
