
public class Autor {
	
	private int codigo;
	private String nombre;
	
	public String toString()
	{
		return ("Codigo: " + codigo + " Nombre: " + nombre);
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
