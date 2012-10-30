package edu.design.patterns;

public abstract class Cuenta {
	private float saldo = 0;
	private Cliente cliente = null;
	
	public Cuenta(float saldoInicial, Cliente cliente)
	{
		this.saldo = saldoInicial;
		this.cliente = cliente;
	}
	
	public Cliente getCliente() {
			return cliente;
	}

	public float getSaldo(){
		  return saldo;
	}

	protected abstract boolean puedeRetirar(float monto);
		
	
    public void retirar(float monto) throws Exception{
	  if (monto <= 0) throw new Exception("No puede retirar cantidades negativas");

	  boolean puedeRetirar = puedeRetirar(monto);
	  
	  if (puedeRetirar == false)
	  {
		  throw new Exception("No tiene saldo suficiente");
	  }
	  else
	  {
		  saldo = saldo - monto;
		  loguearMensaje("Se ha producido un retiro de $" + String.valueOf(monto) + " en la cuenta del cliente " + this.cliente.getNombre());
	  }
	}
  
    private void loguearMensaje(String mensaje){
	  System.out.println(mensaje);
    }


    public void depositar(float monto){
	  saldo = saldo + monto;
	  System.out.println("Monto depositado");
    }
    
}
