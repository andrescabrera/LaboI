public abstract class CuentaBancaria {
	
	private String numero;
	private double saldo;
	
	public String toString(){
		return ("Su cuenta es: " + numero + " su saldo disponible es: " + saldo);
	}
	
	public abstract void extraerDinero(double cantidad);
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}	
	
	public double getSaldo() {
		return saldo;
	}	
	
	public void depositarDinero(double monto){
		saldo = saldo + monto;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}