package Productos;

import Facturas.ItemFactura;

public class Producto {

	private String nombre;
	private double costo;
	private int stock;
	ItemFactura itemf;
	
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
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
	
	//--------------------------------------------
	
	public void agregarStock(int x){
		int cant=x;
		stock=stock+cant;
	}
	
	public boolean quitarCantidad(int cant){
		int x1=cant;
		
		if(cant>0){
			stock=stock-x1;
			return true;}
		else 
			return false;
		
	}
	
	public void confirma(){
		boolean x=this.quitarCantidad(itemf.getCantidad());
		System.out.println("confirmado: "+ stock);
	}
	public void descripcion(){
		
		System.out.println("Producto: "+nombre+"cant: "+stock+"p/u: "+costo);
	}
}
