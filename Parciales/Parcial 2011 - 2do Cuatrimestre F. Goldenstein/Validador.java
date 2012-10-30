/*
	Item 4 - Validador.java
	
	@author Andrés Cabrera
	
	Ejemplo de una clase final.
	
	Una clase final Validador, que tenga metodos final static para validar determinadas cosas, 
	por ejemplo contraseñas; estas clase no se va a poder heredar ni tampoco se van a poder redefinir sus metodos.
*/
public final class Validador {
   
    public final int cantidadMinimaCaracteres = 8;
    public final String[] contraseniasComunes = {"queContraseniaFacil", "1234", "4321", "qwerty"}
   
    public static final Boolean contraseniaSegura (String textoContrasenia) {
        //Acá validaría si la contrasenia esta en el array de String de contraseniasComunes...
    }
   
    public static final Boolean validarContraseña (String hash, String textoContrasenia) {
        Boolean verdaderoSiNo = false;
        if(generarHash(textoContrasenia) == hash)
            verdaderoSiNo = true;
        else
            verdaderoSiNo = false;
        return verdaderoSiNo;
    }

    public static final String generarHash(String textoContrasenia) {
        return "12498yafskhjk" + textoConstrasenia + "24109124094asdkjasdlkj";
    }
   
   
}
