package Facturas;

import java.util.ArrayList;

public class Proveedor extends RazonSocial {

	private int codigo;
	private ArrayList<Producto> productos = new ArrayList<Producto>();

	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}


	
}
