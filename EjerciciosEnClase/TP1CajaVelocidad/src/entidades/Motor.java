package entidades;

public class Motor {
	private String marca ;
	private int caballos;
	private int cilindrada;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getCaballos() {
		return caballos;
	}
	public void setCaballos(int caballos) {
		this.caballos = caballos;
	}
	public int getCilindrada() {
		return cilindrada;
	}
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	public String toString() {
	  return "La marca del motor es " + getMarca() + 
	  " , tiene " + getCaballos() + " caballos " +
	  "y una cilindrada de " + getCilindrada() + ".";
	}
}
