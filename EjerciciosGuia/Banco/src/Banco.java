

/**
 *
 * Este es el programa principal
 */
public class Banco
{
    
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //creamos un duenio...
        Cliente cliente1 = new Cliente();
        cliente1.setNombre("Juan Perez");
        cliente1.setDni("123456789");
        
        //creamos una cuenta...
        CajaAhorro caja1 = new CajaAhorro();
        caja1.setCodigoCuenta("987654321");
        caja1.depositar(1000);
        
        //asociamos un titular a la caja de ahorro...
        caja1.agregarTitular(cliente1);
        //agregamos una cuenta a un cliente...
        cliente1.agregarCuenta(caja1);
        
        
        //Mostramos al cliente...
        System.out.println("Cliente:" + cliente1.toString());
        //mostramos la cuenta
        System.out.println("Caja de ahorro:" + caja1.toString());
        
        
        //realizamos una extraccion
        caja1.extraer(900);
        //mostramos la cuenta
        System.out.println("Caja de ahorro:" + caja1.toString());
       
        
        
        //intentamos realizar otra extraccion....
        caja1.extraer(900);
        //mostramos la cuenta
        System.out.println("Caja de ahorro:" + caja1.toString());
        
        //mostramos cuantas cuentas tiene un cliente y cuantos titulares tiene una cuenta...
        System.out.println("El cliente tiene:" + cliente1.getCantidadCuentas() + " cuentas");
        System.out.println("La cuenta tiene:" + caja1.getCantidadTitulares() + " titulares");
        
    }
    
}
