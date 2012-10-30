package general;

import facturacion.*;

public class Main {

	public static void main(String[] args) {
		//porcentaje de descuento en Productos
		Producto.setDescuento(10);
				
		Computacion placa = new Computacion("Placa de red", 25, "EZZ-352");
		placa.agregarCantidad(150);
		
		Computacion netbook = new Computacion("Netbooks", 2000, "OVR-352");
		netbook.agregarCantidad(1000);
		
		Computacion monitores = new Computacion("Monitores LCD", 800, "SNY-456");
		monitores.agregarCantidad(30);
		
		Ropa babis = new Ropa("Ropita de bebe", 40, "SMALL");
		babis.agregarCantidad(1500);
		
		System.out.println(placa);
		System.out.println(netbook);
		System.out.println(monitores);
		System.out.println(babis);
		
		Factura fac0001= new Factura("Jose Hernandez", "A");
		
		fac0001.getNItems().add(new ItemFactura(100, placa, fac0001));
		fac0001.getNItems().add(new ItemFactura(500, netbook, fac0001));
		fac0001.getNItems().add(new ItemFactura(20, monitores, fac0001));
				
		System.out.println(fac0001);
		
		Factura fac0002= new Factura("Varon B", "B");
		fac0002.getNItems().add(new ItemFactura(5, placa, fac0002));
		fac0002.getNItems().add(new ItemFactura(10, babis, fac0002));
		
		System.out.println(fac0002);		
	}
}
