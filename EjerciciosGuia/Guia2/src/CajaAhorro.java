
public class CajaAhorro extends CuentaBancaria {
	public CajaAhorro(String numero){
		setNumero(numero);
	}
	public CajaAhorro(String numero, double saldo){
		setNumero(numero);
		setSaldo(saldo);
	}
	
	public void extraerDinero(double cantidad){
		//cuenta de ahorro - no nos permite extraer al descubierto
		if(getSaldo() > cantidad){
			setSaldo(getSaldo() - cantidad);
		}
		else
			System.out.println("Saldo insuficiente. A vender churros amigo...");	
	}
	
	
}
