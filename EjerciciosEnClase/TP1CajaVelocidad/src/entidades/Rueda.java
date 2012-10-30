package entidades;

public class Rueda {
	private String radio;
	private String color;
	private String material;
	
	public void setRadio (String radio){
		this.radio = radio;
	}
	
	public String getRadio (){
		return radio;
	}
	
	public void setColor (String color ){
		this.color = color;
	}
	
	public String  getColor (){
		return color;
	}
	
	public void setMaterial (String material){
		this.material = material;
	}
	
	public String getMaterial (){
		return material;
	}
				
	public Rueda () {}
	public Rueda (String radio){
		this.radio= radio;
	}
	public String toString() {
	  return " las rueda tiene un radio de " + getRadio() + " de color "+
			 getColor() + " y construidas de " + getMaterial();
	}	 
}
