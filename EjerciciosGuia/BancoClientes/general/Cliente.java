package general;

import java.util.ArrayList;

public class Cliente {
	private int numero;
	private String nombre;
	private String apellido;
	private ArrayList<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
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
	public ArrayList<CuentaBancaria> getCuentas() {
		return cuentas;
	}
	public void setCuentas(ArrayList<CuentaBancaria> cuentas) {
		this.cuentas = cuentas;
	}
	
	public double consolidarSaldo(){
		double total = 0;
		for(CuentaBancaria c : cuentas){
			total += c.consultarSaldo();
		}
		return total;
	}
	
	
}
