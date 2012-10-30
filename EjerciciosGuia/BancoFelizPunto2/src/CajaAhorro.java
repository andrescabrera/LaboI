
public class CajaAhorro extends CuentaBancaria {

	//constructores
	public CajaAhorro(){
		System.out.println( "No se pudo crear la cuenta sin el respectivo numero" ); 
		//TODO revisar que hacer en el constructor vacio
		setNumero(null);
		setSaldo(0);
	}
	
	public CajaAhorro(String numero){
		System.out.println( "Creando la cuenta bancaria numero: " + numero );
		//seteo la cuenta en 0 y le zampo el nombre que paso por parametro
		setNumero(numero);
		setSaldo(0);
	}
	
	public CajaAhorro(String numero, int saldo){
		System.out.println( "Creando la cuenta bancaria numero: " + numero );
		setNumero(numero);
		setSaldo(saldo);
	}
	
	public void extraerDinero(int cantidad){
		System.out.println("Extrayendo de Caja Ahorro: " + cantidad + "$.");
		super.extraerDinero(cantidad);
	}
	
}
