
public class CuentaCorriente extends CuentaBancaria {
	
	private int deuda;
	
	//constructor	
	public CuentaCorriente (String numero, int saldo, int deuda){
		setNumero(numero);
		setSaldo(saldo);
		System.out.println( "Creando la cuenta corriente numero: " + numero );
		this.deuda = deuda;
	}
		
	public void extraerDinero(int cantidad){
		System.out.println("Extrayendo de Cuenta Corriente: " + cantidad + "$." );
		if(this.getSaldo() >= cantidad )
			super.extraerDinero(cantidad);
		else
		{
			deuda = deuda + (cantidad - getSaldo());
			super.extraerDinero(getSaldo());
			System.out.println("Su deuda ahora es de " + getDeuda() + "$.");
		}
	}
	
	public int getDeuda() {
		return deuda;
	}
	
}
