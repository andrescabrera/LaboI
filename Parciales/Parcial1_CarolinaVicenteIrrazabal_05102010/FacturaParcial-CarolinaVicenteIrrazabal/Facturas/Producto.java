package Facturas;

public class Producto {

	private String nombre;
	private double costo;
	private int cantidad;
	private int stock;
	
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
		
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void agregarCantidad(int x){
		if( (stock-cantidad) >= 0 )
		   cantidad+=x ;
		else
			System.out.println("No es posible realizar la operacion: Stock insuficiente ");
		return;
	}
	
    public boolean quitarCantidad(int x){
    	if( x <= cantidad )  {
    	    cantidad-=x ;
    	    return true;
    	 }else{
    		 System.out.println("No es posible realizar la operacion");
    		 return false;
   	       }
    		
	}


}
