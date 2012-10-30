package objetosDeUnAlmacen;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto producto1 = new Producto();
		producto1.setCantidad(2);
		producto1.setCosto(50);
		producto1.setNombre("Zapato");
		
		Producto producto2 = new Producto();
		producto2.setCantidad(3);
		producto2.setCosto(100);
		producto2.setNombre("Jean");
		
		Factura factura1 = new Factura();
		factura1.setTipo("A");
		factura1.setCliente("Pedro Perez");
		double total = Factura.calcularTotal();
		System.out.println("El total es: " + producto1.getCosto());
		
		Factura factura2 = new Factura();
		factura2.setTipo("B");
		factura2.setCliente("Juan Gomez");
		double total2= Factura.calcularTotal();
		System.out.println("El total2es: " + producto2.getCosto());
		
		
		ItemFactura itemFactura1 = new ItemFactura();
		itemFactura1.setCantidad(6);
		double subTotal = ItemFactura.calcularTotal();
		System.out.println("El subTotal es: " + itemFactura1.getCosto());
		
		ItemFactura itemFactura2= new ItemFactura();
		itemFactura2.setCantidad(8);
		double subTotal2= ItemFactura.calcularTotal();
		System.out.println("El subTotal2es: " + itemFactura2.getCosto());
	
	
		producto1.agregarCantidad(4);
		producto1.quitarCantidad(6);
		
		producto2.agregarCantidad(5);
		producto2.quitarCantidad(4);
		
	
		

	}

}
