package entidades;

public class Telefono {
	private String marca;
	private String modelo;
	private boolean encendido;
	
	public String getMarca(){
		return marca;
	}
	public void setMarca(String marca){
		this.marca = marca;
	}
	public String getModelo(){
		return modelo;
	}
	public void setModelo(String modelo){
		this.modelo = modelo;
	}
	public boolean getEncendido(){
		return encendido;
	}
	public void setEncendido(boolean encendido){
		this.encendido = encendido;
	}
	
	public void llamar(String numero){
		
	}
	public void cortar(String numero){
		
	}
	
	public Telefono(){}
	public Telefono(String marca){
		this.marca = marca;
	}
	public Telefono(String marca, String modelo){
		this.marca = marca;
		this.modelo = modelo;
	}
	public String toString(){
		return "Marca: " + marca + " Modelo: " + modelo +  " Encendido: " + encendido + "\n";
	}
}

