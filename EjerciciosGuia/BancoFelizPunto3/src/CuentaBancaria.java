
public abstract class CuentaBancaria {
	
	private String numero;
	private int saldo;

	//redefinicion de toString
	public String toString(){
		
		return ("Su cuenta es: " + numero + " su saldo disponible es: " + saldo + "$.");
	}
	
	public abstract void extraerDinero(int cantidad);
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}	
	
	public int getSaldo() {
		return saldo;
	}	
	
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
}
