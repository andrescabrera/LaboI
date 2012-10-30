
/**
 *representa una cuenta corriente
 */
public class CuentaCorriente extends Cuenta
{
    
    
    /*aqui hacemos la extraccion
    una cuenta corriente puede quedar con un saldo negativo
    es decir... siempre se puede extraer
     */
    public int extraer(int monto)
    {
        int nuevoSaldo;
        nuevoSaldo = this.getSaldo() - monto;
        this.setSaldo(nuevoSaldo);
        return monto;
    }
    
    
}
