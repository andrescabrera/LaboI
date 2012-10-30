import java.util.*;

/**
 *esta clase representa una cuenta bancaria
 *notese que es abstracta... debe ser terminada de implementar
 *en caja de ahorro y cuenta corriente
 */
public abstract class Cuenta
{
    private int saldo;
    private String codigoCuenta;
    private ArrayList titulares;
    
    
    /** constructor */
    public Cuenta()
    {
        this.setSaldo(0);
        this.setCodigoCuenta("");
        titulares = new ArrayList();
    }
    
    
    /*
     aumenta el saldo de la cuenta en la cantidad indicada
     */
    public void depositar(int monto)
    {
        int nuevoSaldo;
        nuevoSaldo = this.getSaldo() + monto;
        this.setSaldo(nuevoSaldo);
    }
    
    /*
     *este metodo es dejado como abstracto
     *y debe ser implementado en la caja de ahorro
     *y la cuenta corriente
     *ya que la forma de retirar dinero de cada una de ellas es distinto
     */
    public abstract int extraer(int monto);
    
    
    
    
    /*
     *los metodos para manejar los titulares de las cuentas...
     *agrego una titular a la cuenta
     */
    public void agregarTitular(Cliente c)
    {
        titulares.add(c);
    }
    
    /*quito una titular de la cuenta*/
    public void quitarTitular(Cliente c)
    {
        titulares.remove(c);
    }
    
    /*devuelve la cantidad de titulares*/
    public int getCantidadTitulares()
    {
        return titulares.size();
    }
    
    
    ///a partir de aqui estan todos los get y set...
    public int getSaldo()
    {
        return saldo;
    }
    
    public void setSaldo(int saldo)
    {
        this.saldo = saldo;
    }
    
    public String getCodigoCuenta()
    {
        return codigoCuenta;
    }
    
    public void setCodigoCuenta(String codigoCuenta)
    {
        this.codigoCuenta = codigoCuenta;
    }
    
    
    /*
     *devuelve una descripcion de la cuenta
     */
    public String toString(){
        return "Cuenta numero: " + this.getCodigoCuenta() + "\n"
                + "Saldo: " + this.getSaldo();
    }
    
}
