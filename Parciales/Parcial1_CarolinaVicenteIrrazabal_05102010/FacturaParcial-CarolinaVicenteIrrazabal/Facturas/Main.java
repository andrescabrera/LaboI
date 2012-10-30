package Facturas;

public class Main {

	public static void main(String[] args) {
		
	Cliente c1 = new Cliente();
	c1.setNombre("Juan Perez");
	c1.setCodigo(1234);
	c1.setTelefono("3294-9843");
	c1.setDireccion("Charcas 3245");
	System.out.println(c1);
	
	Cliente c2 = new Cliente();
	c2.setNombre("Maria Lopez");
	c2.setCodigo(4321);
	c2.setTelefono("4345-9436");
	c2.setDireccion("Jujuy 35");
	System.out.println(c2);
	
	Producto p1 = new Producto();
	p1.setCosto(420);
	p1.setStock(30);
	
	Producto p2 = new Producto();
	p2.setCosto(150);
	p1.setStock(50);
	
	Factura f1 = new Factura();
	f1.setTipo("A");
	f1.setCliente(c1);
	f1.setNumero(2341);
	Factura.setIva(0.21);
	
	ItemFactura it1 = new ItemFactura();
	it1.setCantidad(5);
	it1.setProducto(p1);
	double sub1 = it1.calcularSubtotal();
	
	System.out.println(" Subtotal Item1: " + sub1); 
	
	ItemFactura it2 = new ItemFactura();
	it2.setCantidad(8);
	it2.setProducto(p2);
	double sub2 = it2.calcularSubtotal();
	System.out.println(" Subtotal Item2: " + sub2); 
		
	f1.getItems().add(it1);
	f1.getItems().add(it2);

	double t1 = f1.calcularTotal();	
	
	System.out.println("\nFactura nro. " + f1.getNumero() + " : \nCliente: " + f1.getCliente() +"\nTotal = $" + t1);
	
	}

}
