package palermo.primerparcial;

public class ItemFactura extends Item
{
	private int cantidad;
	
	public double calcularSubTotal()
	{
		double total = this.getCantidad() * this.getCosto();
		return total;
	}
	public int getCantidad() 
	{
		return cantidad;
	}
	public void setCantidad(int cantidad) 
	{
		this.cantidad = cantidad;
	}
}
