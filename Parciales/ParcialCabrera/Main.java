import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Producto> nProductos = new ArrayList<Producto>();

		// instancio productos
		Producto p1 = new Producto("Pinza");
		Producto p2 = new Producto("Martillo");

		// instancio Materias Primas
		// para la pinza
		MateriaPrima m1 = new MateriaPrima("Tornillo Eje de Pinza", 6);
		m1.setProducto(p1);
		MateriaPrima m2 = new MateriaPrima("Pico de Pinza", 36);
		m2.setProducto(p1);
		MateriaPrima m3 = new MateriaPrima("Mango de Pinza", 13);
		m3.setProducto(p1);
		// para el martillo
		MateriaPrima m4 = new MateriaPrima("Mango de Madera", 37);
		m4.setProducto(p2);
		MateriaPrima m5 = new MateriaPrima("Bola de Metal", 86);
		m5.setProducto(p2);
		MateriaPrima m6 = new MateriaPrima("Cola de Pegar", 5);
		m6.setProducto(p2);

		p1.getNMateriasPrimas().add(m1);
		p1.getNMateriasPrimas().add(m2);
		p1.getNMateriasPrimas().add(m3);

		p2.getNMateriasPrimas().add(m4);
		p2.getNMateriasPrimas().add(m5);
		p2.getNMateriasPrimas().add(m6);

		// los agrego al array
		nProductos.add(p1);
		nProductos.add(p2);

		//Calculo los costos
		for(Producto pActual : nProductos){
			pActual.calcularCosto();
		}
		
		// los muestro
		/*
		for (Producto pActual : nProductos) {
			System.out.println("-------Listando Producto--------");
			System.out.println(pActual);
			pActual.listarMateriasPrimas();
		}
		*/
		//Dando de alta todo el array en la BD
		for(Producto pActual : nProductos){
			GestorDeProductos.altaProducto(pActual);
		}
		//Mostrando los productos de la BD
		GestorDeProductos.listarProductos();
		
		//Borrando un producto
		//GestorDeProductos.bajaProducto(42);
		
		//Buscando un producto
		//GestorDeProductos.buscarProducto(50);
		
		//Modificando un producto
		//GestorDeProductos.modificarProducto(74, "Martillo", 480);
		
	}

}
