package edu.design.patterns;

public class CajaDeAhorro extends Cuenta{
	
	public CajaDeAhorro(float saldoInicial, Cliente cliente){
		super(saldoInicial, cliente);
	}

	protected boolean puedeRetirar(float monto) {
		return (monto <= getSaldo());
	}
}
