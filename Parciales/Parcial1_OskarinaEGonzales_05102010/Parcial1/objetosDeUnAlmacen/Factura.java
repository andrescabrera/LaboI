package objetosDeUnAlmacen;
import java.util.ArrayList;

public class Factura extends Producto {
	private String cliente;
	private  String tipo;
	private static ArrayList<ItemFactura> items = new ArrayList<ItemFactura>();
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public ArrayList<ItemFactura> getItems() {
		return items;
	}
	public void setItems(ArrayList<ItemFactura> items) {
		this.items = items;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) { 
		this.tipo = tipo;
	}
	
	
	public  static double  calcularTotal(){
		double total = 0;
		for (ItemFactura i : items){
			total = total + i.getCantidad();
		}
		return total;
	}
}
