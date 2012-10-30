package entidades;

public class Cajavelocidad {
	private int marchas;
	private String relacion;
	
	public void setMarchas(int marchas){
		this.marchas = marchas;
	}
	
	public int getMarchas(){
		return marchas;
	}
	
	public void setRelacion (String relacion ){
		this.relacion = relacion;
	}
	
	public String  getRelacion (){
		return relacion;
	}
			
	public Cajavelocidad() {
		
	}
	public Cajavelocidad (String relacion  , int marchas){
		this.relacion  = relacion;
		this.marchas  = marchas;
	}
	
	public String toString() {
	   return " la caja de velocidad tieje " + getMarchas() + " marchas, con relacion "+
		 getRelacion() ;
		 }   
	
	
}
