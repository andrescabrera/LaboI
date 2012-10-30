import java.util.Date;


class CdMusica {
	/*
	public CdMusica(){}
	
	CdMusica(String titulo, int codigo, Date date, float precio)
	{
		this.titulo = titulo;
		this.codigo = codigo;
		this.date = date;
		this.precio = precio;
	}
	*/	
	
	public String toString()
	{
		return ("Codigo: " + codigo + " Titulo: " + titulo + " Fecha: " + date + " Precio: " + precio + " Autor: " + autor.getNombre() + " Genero: " + genero.getNombre());
	}
	private String titulo;
	private int codigo;
	private Date date;
	private float precio;
	private Autor autor;
	private Genero genero;
		
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
}
