
import java.util.*;

/**
 *esta clase representa un cliente del banco
 */
public class Cliente
{
   
    //variables privadas donde guardaremos
    //el valor de los atributos de los clientes...
    private String dni;
    private String nombre;
    
    //en esta coleccion guardaremos todas las cuentas que tiene un cliente
    private ArrayList cuentas;
            
    
    /** constrnctor de la clase cliente */
    public Cliente()
    {
        this.setDni("0");
        this.setNombre("");
        cuentas = new ArrayList();
    }
    
    
    //agrego una cuenta al cliente...
    public void agregarCuenta(Cuenta c){
        cuentas.add(c);
    }
    
    //quito una cuenta del cliente
    public void quitarCuenta(Cuenta c){
        cuentas.remove(c);
    }
    
    //devuelve la cantidad de cuentas que tiene
    //un cliente
    public int getCantidadCuentas(){
        return cuentas.size();
    }

    
    
    //***todos los get/set para poder acceder a los atributos...
    public String getDni()
    {
        return dni;
    }

    public void setDni(String dni)
    {
        this.dni = dni;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    
    
    /*
     *se agrega este metodo que tiene como finalidad
     *devolver una descripcion del cliente
     */
    public String toString(){
        return "Nombre: " + this.getNombre() + "\n"
                + "Dni: " + this.getDni();
    }
    
}
