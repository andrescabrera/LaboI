import java.util.ArrayList;


public abstract class CuentaBancaria {
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private double saldo;
	

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
	
	public abstract void extraer(double monto);
}
 