package facturacion;

import java.util.ArrayList;

public class Factura {
	private String cliente;

	private String tipo;

	private ArrayList<ItemFactura> nItems = new ArrayList<ItemFactura>();
	
	public Factura(String cliente, String tipo){
		this.cliente = cliente;
		this.tipo = tipo;
	}
	
	public double calcularTotal() {
		double total = 0;
		for (ItemFactura unItem : nItems) {
			total += unItem.calcularSubtotal();
		}
		return total;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ArrayList<ItemFactura> getNItems() {
		return nItems;
	}

	public void setNItems(ArrayList<ItemFactura> items) {
		nItems = items;
	}
	
	public String toString(){
		return ("Factura a nombre de: " + cliente + " por un total de: " + calcularTotal());
	}
}
