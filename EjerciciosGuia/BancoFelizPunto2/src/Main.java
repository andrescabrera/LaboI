//Andrés Cabrera - BancoFeliz, punto 2

public class Main {
	
	public static void main(String[] args){
		
		//creo una caja de ahorro sin saldo
		CajaAhorro c1 = new CajaAhorro("CA-1");
		c1.extraerDinero(500);
		System.out.println(c1);
		
		//creo una caja de ahorro con saldo 2000
		CajaAhorro c2 = new CajaAhorro("CA-2", 2000);
		c2.extraerDinero(1800);
		System.out.println(c2);
		
		//creo una cuenta corriente con saldo 1000
		CuentaCorriente c3 = new CuentaCorriente("CC-3", 1000, 0);
		c3.extraerDinero(1500);
		System.out.println(c3);	
				
	}
}
