package Facturas;

import Productos.Producto;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Factura f1 = new Factura();
		ItemFactura if1 = new ItemFactura();
		Producto p1 = new Producto();
		Producto p2 = new Producto();

		p1.setStock(2);
		p1.setCosto(25);
		p1.setNombre("kiwi");
		p1.agregarStock(2);
		p1.descripcion();
		boolean resp=p1.quitarCantidad(1);
		
		
		p2.setStock(3);
		p2.setCosto(12.3);
		p2.setNombre("manzana");
		p2.quitarCantidad(2);
		p2.descripcion();
		
		
		if1.setCantidad(2);
		if1.ingresarProd(p1);
		if1.ingresarProd(p2);
		
		//double sub = if1.calcularSubtotal();
		//System.out.println("el subtotal del item es: " + sub);

		f1.setCliente("juan");
		f1.agregarItems(if1);
		double total=f1.calcularTotal();
		System.out.println("el total de la factura es: "+total);
	}

}
