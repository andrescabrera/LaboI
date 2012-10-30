package Facturas;

public abstract class Documentos {

	private String cliente;

	private String tipo;

	

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	abstract double calcularTotal();

}
