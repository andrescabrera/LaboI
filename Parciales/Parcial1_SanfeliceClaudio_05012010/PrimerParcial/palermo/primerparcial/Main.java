package palermo.primerparcial;
import java.util.*;

//Sanfelice Claudio
public class Main 
{
	public static void main(String[] args) 
	{
		Factura fact1 = new Factura();
		fact1.setCliente("Juan Pepe");
		fact1.setTipo("C");
		
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Random r = new Random();
		Random r2 = new Random();
		int totalProductos=r.nextInt(10);
		for (int i = 0; i < totalProductos; i++) 
		{
			int cant=0;
			Producto prod = new Producto(r2.nextInt(50),"Producto"+i,r2.nextDouble()*100);
			prod.agregarCantidad(r2.nextInt(10));
			productos.add(prod);
			if	(prod.quitarCantidad(cant=r2.nextInt(60)))
			{
				ItemFactura itemfact = new ItemFactura();
				itemfact.setNombre(prod.getNombre());
				itemfact.setCosto(prod.getCosto());
				itemfact.setCantidad(cant);
				fact1.getItemfacturas().add(itemfact);
			}
			else
			{
				System.out.println("No se pudo agregar a item factura");
			}
		}
		System.out.println();
		Producto.setTotalProductos(totalProductos);
		
		fact1.listarItems();
		Producto p1 = new Producto();
		Producto p2 = new Producto();
		System.out.println("Total de productos disponibles "+p1.getTotalProductos());	//Una variable static es la misma para toda la clase
		System.out.println("Total de productos disponibles "+p2.getTotalProductos());
	}
}