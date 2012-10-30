import java.util.ArrayList;

//import java.util.ArrayList;

public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		Cliente cliente1 =new Cliente();
		cliente1.setNombre("Juan carlos");
		cliente1.setNumero(453434);
		
		CuentaBancaria cuentaBancaria1 = new CuentaCorriente();
		cuentaBancaria1.setNumero(101);
		cuentaBancaria1.setSaldo(500);
		cuentaBancaria1.agregarCliente(cliente1);
		cliente1.agregarCuentaBancaria(cuentaBancaria1);
		System.out.println(cuentaBancaria1.getClass().getName());
		
		CajaDeAhorro cuentaBancaria2 = new CajaDeAhorro();
		cuentaBancaria2.setNumero(102);
		cuentaBancaria2.setSaldo(1000);
		cuentaBancaria2.agregarCliente(cliente1);
		cliente1.agregarCuentaBancaria(cuentaBancaria2);
		System.out.println(GestorDeCuentasBancarias.devolverCuentaEnXml(cuentaBancaria1));
		System.out.println(GestorDeCuentasBancarias.devolverCuentaEnXml(cuentaBancaria2));
		try {
			cuentaBancaria2.extraer(4500);
		} catch (FaltaDeSaldoException e) {
			System.out.println("Alguien te esta mandando a freir churros... fijate abajo");
			e.printStackTrace();
		}
		System.out.println("El saldo total para el cliente " + cliente1.getNombre() + " es de " + cliente1.calcularTotal());
		//System.out.println("El cliente de la cuenta 1 es :" + cuentaBancaria1.getCliente().getNombre() );
		*/
		
		ArrayList<CuentaBancaria> cuentasRecuperadas = GestorDeCuentasBancarias.recuperarCuentas();
		//ArrayList<Cliente> clientesRecuperados = GestorDeCuentasBancarias.recuperarClientes();
		/*
		System.out.println("Listando clientes del banco.");
		for(Cliente cActual : clientesRecuperados){
			System.out.println("\n" + cActual);
			cActual.imprimirCuentasBancariasDelCliente();
		}
		*/
		System.out.println("\n\nListando cuentas bancarias.");
		for(CuentaBancaria cActual : cuentasRecuperadas){
			String xml = GestorDeCuentasBancarias.devolverCuentaEnXml(cActual);
			System.out.println(xml);
			//System.out.println("\n" + cActual);
			//cActual.listarClientes();
		}
		
		/*
		GestorDeCuentasBancarias.generarCsv("cuentas.csv", cuentasRecuperadas);
		cuentasRecuperadas = GestorDeCuentasBancarias.cargarCsv("cuentas.csv");
		System.out.println("\n\nListando cuentas bancarias.");
		for(CuentaBancaria cActual : cuentasRecuperadas){
			System.out.println("\n" + cActual);
			cActual.listarClientes();
		}
		for(CuentaBancaria cActual : cuentasRecuperadas)
			GestorDeCuentasBancarias.insertarCuenta(cActual);
			*/		
	}	
}
