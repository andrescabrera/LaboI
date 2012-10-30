public class Main {
	
	public static void main(String[] args){
		/*
		//sin constructores
		CuentaBancaria c1 = new CuentaBancaria();
		c1.setSaldo(0);
		c1.setNumero("CA-1");
		System.out.println("Extrayendo 500 pesos de la cuenta " + c1.getNumero());
		c1.extraerDinero(500);
		System.out.println("Su cuenta es: " + c1.getNumero() + " su saldo disponible es:  " + c1.getSaldo());
		c1.getSaldo();
		
		CuentaBancaria c2 = new CuentaBancaria();
		c2.setSaldo(2000);
		c2.setNumero("CA-2");
		System.out.println("Extrayendo 1000 pesos de la cuenta" + c2.getNumero());
		c2.extraerDinero(1000);
		System.out.println("Su cuenta es: " + c2.getNumero() + " su saldo disponible es: " + c2.getSaldo());
		*/
		
		//con constructores y el toString redefinido
		CajaAhorro c1 = new CajaAhorro("CA-1");
		System.out.println("Extrayendo 500 pesos de la cuenta " + c1.getNumero());
		c1.extraerDinero(500);
		System.out.println(c1);
		
		CajaAhorro c2 = new CajaAhorro("CA-2", 2000);
		System.out.println("Extrayendo 1000 pesos de la cuenta " + c2.getNumero());
		c2.extraerDinero(1000);
		System.out.println(c2);
		
		CuentaCorriente c3 = new CuentaCorriente();
		c3.setNumero("Cuenta de Caro");
		c3.setSaldo(5000);
		System.out.println(c3);
		c3.extraerDinero(10000);
		System.out.println(c3);
		
	}
}