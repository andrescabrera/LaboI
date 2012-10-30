package Facturas;

import java.util.ArrayList;

public class Factura {

	private Cliente cliente;
    private String tipo;
    private int numero;
	private static double iva;

	private ArrayList<ItemFactura> items = new ArrayList<ItemFactura>();

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public static double getIva() {
		return iva;
	}

	public static void setIva(double iva) {
		Factura.iva = iva;
	}

	public ArrayList<ItemFactura> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemFactura> items) {
		this.items = items;
	}

	public double calcularTotal() {

		double total = 0;

		for (ItemFactura i : items) {

			total += i.calcularSubtotal();
		}
		total += total * iva;

		return total;
	}

	
}
