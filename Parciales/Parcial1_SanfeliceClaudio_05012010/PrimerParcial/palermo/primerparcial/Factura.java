package palermo.primerparcial;
import java.util.*;

public class Factura 
{
	private String cliente;
	private String tipo;
	private ArrayList<ItemFactura> itemfacturas = new ArrayList<ItemFactura> ();
	
	public double calcularTotal()
	{
		double total=0;
		for (ItemFactura x : itemfacturas) 
		{
			total+=x.calcularSubTotal();
		}
		return total;
	}
	public String getCliente() 
	{
		return cliente;
	}
	public void setCliente(String cliente) 
	{
		this.cliente = cliente;
	}
	public String getTipo() 
	{
		return tipo;
	}
	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}
	public ArrayList<ItemFactura> getItemfacturas() 
	{
		return itemfacturas;
	}
	public void setItemfacturas(ArrayList<ItemFactura> itemfacturas) 
	{
		this.itemfacturas = itemfacturas;
	}
	
	public void listarItems()
	{
		System.out.println("Listando Factura tipo "+this.getTipo()+" de "+this.getCliente());
		for (ItemFactura x : this.getItemfacturas()) 
		{
			System.out.println(x.getNombre()+" | Costo: "+x.getCosto()+"$ | Cantidad: "+x.getCantidad()+" | Sub total: "+x.calcularSubTotal()+"$");
		}
		System.out.println("Total: "+this.calcularTotal()+"$");
		System.out.println();
	}
}
