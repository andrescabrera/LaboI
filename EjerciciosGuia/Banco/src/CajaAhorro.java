/**
 *representa una caja de ahorro
 *lo que tiene de diferente es que
 *en una caja de ahorro no siempre se puede extraer...
 */
public class CajaAhorro extends Cuenta
{
    
    /*
     *realiza la extraccion de la caja de ahorro
     *si hay dinero suficiente procede a actualizar el saldo
     *y devuelve el dinero
     *si no hay dinero suficiente muestra un error y no devuelve dinero
     */
    public int extraer(int monto)
    {
        if (this.getSaldo() > monto)
        {
            int nuevoSaldo;
            nuevoSaldo = this.getSaldo() - monto;
            this.setSaldo(nuevoSaldo);
            return monto;
        }
        else
        {
            System.out.println("No hay dinero suficiente en la caja de ahorro para la extraccion pedida.");
            return 0;
        }
    }
    
    
}
