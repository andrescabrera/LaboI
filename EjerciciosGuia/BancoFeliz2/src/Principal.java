
public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cliente cliente1 =new Cliente();
		cliente1.setNombre("Juan carlos");
		cliente1.setNumero(453434);
		
		CuentaBancaria cuentaBancaria1 = new CuentaCorriente();
		cuentaBancaria1.setSaldo(500);
		cuentaBancaria1.agregarCliente(cliente1);
		cliente1.agregarCuentaBancaria(cuentaBancaria1);
		System.out.println(cuentaBancaria1.getClass().getName());
		
		CajaDeAhorro cuentaBancaria2 = new CajaDeAhorro();
		cuentaBancaria2.setSaldo(1000);
		cuentaBancaria2.agregarCliente(cliente1);
		cliente1.agregarCuentaBancaria(cuentaBancaria2);
		
		System.out.println("El saldo total para el cliente " + cliente1.getNombre() + " es de " + cliente1.calcularTotal());
		//System.out.println("El cliente de la cuenta 1 es :" + cuentaBancaria1.getCliente().getNombre() );
	}

}
