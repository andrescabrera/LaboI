
public class CuentaCorriente extends CuentaBancaria{
	
	public void extraerDinero(double cantidad){
		if(getSaldo() < cantidad)
			setSaldo(getSaldo() - cantidad); 
		else
			setSaldo(getSaldo() - cantidad);
	}
	

}
