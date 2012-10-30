package Facturas;

public class Cliente extends RazonSocial {

	private int codigo;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String toString(){
		return ( super.toString() + "  Codigo de Cliente: " + codigo);
		
	}
	
}
