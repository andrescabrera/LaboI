package edu.design.patterns;

public class CtaCte extends Cuenta{
	private float descubierto;
	
	public CtaCte (float saldoInicial, Cliente cliente, float descubierto){
		super(saldoInicial, cliente);
		this.descubierto = descubierto;
	}

	protected boolean puedeRetirar(float monto) {
		return (monto <= getSaldo() + descubierto);
	}
	  
}
