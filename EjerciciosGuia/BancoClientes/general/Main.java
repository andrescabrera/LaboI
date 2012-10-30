package general;

public class Main {

	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente();
		cliente1.setNumero(1234);
		cliente1.setNombre("Juan");
		cliente1.setApellido("Perez");
		
		CuentaBancaria cuentaBancaria1 = new CuentaBancaria();
		cuentaBancaria1.setNumero(8865);
		cuentaBancaria1.depositar(500);
		
		CuentaBancaria cuentaBancaria2 = new CuentaBancaria();
		cuentaBancaria2.setNumero(8456);
		cuentaBancaria2.depositar(1500);
		
		cliente1.getCuentas().add(cuentaBancaria2);
		cliente1.getCuentas().add(cuentaBancaria1);
		
		System.out.println("El saldo de " + cliente1.getNombre() + " es: " + cliente1.consolidarSaldo());
	}
}
