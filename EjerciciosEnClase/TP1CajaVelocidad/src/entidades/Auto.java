package entidades;

public class Auto {
	
	private Motor motor;
    private Cajavelocidad cajavelocidad;
    private Rueda rueda;
    private int puerta;
    private boolean aire;
	    
    public Auto() {}

    public Auto(int puerta, boolean aire) {
		this.puerta = puerta;
		this.aire = aire;
	}
    public int getPuerta() {
		return puerta;
	}
	public void setPuerta(int puerta) {
		this.puerta = puerta;
	}
	public boolean getAire() {
		return aire;
	}
	public Motor getMotor() {
		return motor;
	}
	public void setMotor(Motor motor) {
		this.motor = motor;
	}
	public Cajavelocidad getCajavelocidad() {
		return cajavelocidad;
	}
	public void setCajavelocidad(Cajavelocidad cajavelocidad) {
		this.cajavelocidad = cajavelocidad;
	}
	public Rueda getRueda() {
		return rueda;
	}
	public void setRueda(Rueda rueda) {
		this.rueda = rueda;
	}	
	public void setAire(boolean aire) {
		this.aire = aire;
	}
	public boolean tieneAire() {
		return aire;
	}

	public String toString() {
	 	String respuesta;
	   	if (getAire() == true)
	   		respuesta = "El auto trae aire "  ;
	   	else
	   		respuesta = "El auto no trae aire " ;
	   	return (respuesta + 
		      	"y tiene " + getPuerta() + 	" puertas" + "\n" +
		      	motor + "\n" +
		      	rueda + "\n" + 
		      	cajavelocidad + "\n" ) ;
	   }   
}
