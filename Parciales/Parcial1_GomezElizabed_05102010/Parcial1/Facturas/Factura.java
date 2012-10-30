package Facturas;

import java.util.ArrayList;

public class Factura extends Documentos {

	
	private ArrayList<ItemFactura> items = new ArrayList<ItemFactura>();

	public ArrayList<ItemFactura> getItems() {
		return items;
	}

	public void setItems(ArrayList<ItemFactura> items) {
		this.items = items;
	}

	public double calcularTotal() {
		double total=0;
		//for(int i=0; i<items.size();i++){
			//total=items.get(i).calcularSubtotal();
		//}
		return total;
	}
	
	public void agregarItems(ItemFactura i){
		items.add(i);
		System.out.println("item ingresado" );
	}
}
