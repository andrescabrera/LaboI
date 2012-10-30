import java.util.ArrayList;
import java.util.Iterator;


public class Cliente {
	private String nombre;
	private int numero;
	private ArrayList<CuentaBancaria> cuentasBancarias = new ArrayList<CuentaBancaria>();
	//private ArrayList cuentasBancarias2 = new ArrayList();
	
	public String toString(){
		return "Nombre: " + nombre + " numero: " + numero;
	}
	
	public void imprimirCuentasBancariasDelCliente(){
		System.out.println("Mostrando cuentas bancarias del cliente: " + nombre);
		for(CuentaBancaria cActual:cuentasBancarias)
			System.out.println("Numero: " + cActual.getNumero() + " Saldo: $" + cActual.getSaldo());
	}
	
	public void agregarCuentaBancaria(CuentaBancaria cuentaBancaria) {
		cuentasBancarias.add(cuentaBancaria);
		
	}
	
	public void quitarElemento(CuentaBancaria cuentaBancaria) {
		cuentasBancarias.remove(cuentaBancaria);
	}

	public double calcularTotal() {
		double total = 0;
		Iterator<CuentaBancaria> iterator = cuentasBancarias.iterator();
		while (iterator.hasNext()) {
			CuentaBancaria cuentaBancaria = iterator.next();
			System.out.println(cuentaBancaria.getClass().getName() + " padre: " + cuentaBancaria.getClass().getSuperclass().getName());
			total = total + cuentaBancaria.getSaldo();
		}
		return total;
		
		/*
		for(CuentaBancaria c : cuentasBancarias2) {
			total += c.getSaldo();
		}*/
		

	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ArrayList<CuentaBancaria> getCuentasBancarias() {
		return cuentasBancarias;
	}

	public void setCuentasBancarias(ArrayList<CuentaBancaria> cuentasBancarias) {
		this.cuentasBancarias = cuentasBancarias;
	}
}
