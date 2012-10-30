import java.util.ArrayList;


public abstract class CuentaBancaria {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private double saldo;
	private int numero;
	private int id;
	
	public String toString(){
		return "Cuenta numero: " + numero + " su saldo es: $" + saldo + " y su id en la BD es: " + id;
	}
	
	public void listarClientes(){
			System.out.println("Mostrando Titulares");
			for(Cliente clienteActual: clientes)
				System.out.println("Nombre: " + clienteActual.getNombre());
	}
	
	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public abstract void extraer(double monto) throws FaltaDeSaldoException;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
 