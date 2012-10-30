import java.util.ArrayList;


public abstract class CuentaBancaria {
	private ArrayList clientes = new ArrayList();
	private double saldo;
	

	public void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
	}
	
	public ArrayList getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList clientes) {
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
 