package edu.design.patterns;

public class PruebaCtaCte {

	public static void main(String[] args) {
		Cliente juan = new Cliente("Juan");
		CtaCte cuenta = new CtaCte(1000, juan, 500);
		
		try {
			cuenta.retirar(1100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("el saldo es "+cuenta.getSaldo());
		try {
			cuenta.retirar(1100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("el saldo es "+cuenta.getSaldo());
		
		System.out.println("deposito 500");
		cuenta.depositar(500);
		System.out.println("el saldo es "+cuenta.getSaldo());

		try {
			cuenta.retirar(1100);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
