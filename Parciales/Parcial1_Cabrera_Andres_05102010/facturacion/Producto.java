package facturacion;

import java.util.ArrayList;

public abstract class Producto {
	private String nombre;

	private double costo;

	private int cantidad;
	
	private static int descuento;

	private ArrayList<ItemFactura> nItems = new ArrayList<ItemFactura>();
	
	public Producto(String nombre, double costo){
		this.nombre = nombre;
		this.costo = costo;
	}
	
	public void agregarCantidad(int x) {
		cantidad += x;
	}

	public boolean quitarCantidad(int x){
		if (cantidad >= x) {
			cantidad -= x;
			return true;
		} else
			return false;
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

	public ArrayList<ItemFactura> getNItems() {
		return nItems;
	}
	
	public String toString(){
		return ("El producto: " + nombre + " cuesta: " + costo + "$ y dispone de: " + cantidad);
	}

	public static int getDescuento() {
		return descuento;
	}

	public static void setDescuento(int descuento) {
		Producto.descuento = descuento;
	}
}
