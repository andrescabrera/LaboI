
public class Genero {

	private String nombre;
	private int codigo;
	
	public String toString()
	{
		return ("Nombre: " + nombre + " Codigo: " + codigo);
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}
