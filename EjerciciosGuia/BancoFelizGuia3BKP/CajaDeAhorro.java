
public class CajaDeAhorro extends CuentaBancaria{

	@Override
	public void extraer(double monto) throws FaltaDeSaldoException {
		if(this.getSaldo() < monto)
			throw new FaltaDeSaldoException("No tiene saldo en la cuenta, valla a freir churros por favor..!");
		else
			this.setSaldo(this.getSaldo() - monto);		
	}
}
