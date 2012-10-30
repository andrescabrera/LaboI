
public class CuentaCorriente extends CuentaBancaria {

	private double limite = 5000;
	public double getLimite() {
		return limite;
	}
	public void setLimite(double limite) {
		this.limite = limite;
	}
	public void extraer(double monto) {
		double saldoActual = this.getSaldo();
		setSaldo(saldoActual - monto);
		
	}

}
