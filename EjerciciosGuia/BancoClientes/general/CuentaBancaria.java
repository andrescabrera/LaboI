package general;

public class CuentaBancaria {
	private int numero;
	private double saldo;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void extraer(double monto){
		if(saldo - monto >= 0){
			saldo = saldo - monto;
		}
	}
	public void depositar(double monto){
		saldo += monto;
	}
	
	public double consultarSaldo(){
		return saldo;
	}
}
