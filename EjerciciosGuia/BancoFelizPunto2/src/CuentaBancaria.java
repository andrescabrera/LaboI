
public class CuentaBancaria {
	
	private String numero;
	private int saldo;

	//redefinicion de toString
	public String toString(){
		
		return ("Su cuenta es: " + numero + " su saldo disponible es: " + saldo + "$.");
	}
	
	public void extraerDinero(int cantidad){
		if(this.getSaldo() >= cantidad){
			this.setSaldo(this.getSaldo() - cantidad);
		}
		else
			System.out.println("Saldo insuficiente. A vender churros...");
	}
	
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
