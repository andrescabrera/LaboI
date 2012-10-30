public class MateriaPrima {

	private int id;

	private String nombre;

	private double costo;

	private Producto producto = new Producto();
	
	//Constructores
	//public MateriaPrima(){}
	public MateriaPrima(String nombre){
		this.nombre = nombre;
	}

	public MateriaPrima(String nombre, double costo){
		this.nombre = nombre;
		this.costo = costo;
	}
	//toString Override
	public String toString(){
		return "Nombre: " + nombre + " Costo: $" + costo;
	}
	//Getters & Setters
	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
