import java.util.ArrayList;

public class Producto {
	private int id;

	private String nombre;

	private double costo;
	
	private ArrayList<MateriaPrima> nMateriasPrimas = new ArrayList<MateriaPrima>();
	
	// Constructores
	public Producto(){}

	public Producto(String nombre) {
		this.nombre = nombre;
	}

	public Producto(String nombre, double costo) {
		this.nombre = nombre;
		this.costo = costo;
	}

	// ToString Override
	public String toString() {
		return "Nombre: " + nombre + " Costo: $" + costo;
	}

	// Getters & Setters
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

	public ArrayList<MateriaPrima> getNMateriasPrimas() {
		return nMateriasPrimas;
	}

	public void setNMateriasPrimas(ArrayList<MateriaPrima> materiasPrimas) {
		nMateriasPrimas = materiasPrimas;
	}
	
	public void calcularCosto(){
		int costo = 0;
		for(MateriaPrima mActual : nMateriasPrimas){
			costo += mActual.getCosto();
		}
		this.costo = costo;
	}
	
	public void listarMateriasPrimas(){
		System.out.println("-----Listando Materias Primas de: " + this.getNombre() + "----------");
		for(MateriaPrima mActual : nMateriasPrimas){
			System.out.println(mActual);
		}
	}
}
