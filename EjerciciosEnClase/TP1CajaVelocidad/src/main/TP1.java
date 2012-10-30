package main;
import entidades.Auto;
import entidades.Motor;
import entidades.Rueda;
import entidades.Cajavelocidad;

public class TP1 {
   public static void main(String[] args){
	    
	   Auto fiat = new Auto( 4, true);
	   Auto bmw = new Auto( 2, false);
	   Auto audi = new Auto();
	   
	   audi.setAire(true);
	   audi.setPuerta(3);
	 	   
	   Rueda rueda = new Rueda();
	   rueda.setRadio("17");
	   rueda.setColor("B");
	   rueda.setMaterial("aluminio");
	   bmw.setRueda(rueda);
	    
	   Motor motor = new Motor();
	   motor.setCilindrada(2000);
	   motor.setCv(120);
	   motor.setMarca("bmw");
	   bmw.setMotor(motor);
	    
	   Cajavelocidad cajavelocidad = new Cajavelocidad();
	   cajavelocidad.setMarchas(6);
	   cajavelocidad.setRelacion("automatica");
	   bmw.setCajavelocidad(cajavelocidad);  
	    
	   rueda = new Rueda();
	   rueda.setRadio("13");
	   rueda.setColor("plateado");
	   rueda.setMaterial("chapa");
	   fiat.setRueda(rueda);
	    
	   motor = new Motor();
	   motor.setCilindrada(1300);
	   motor.setCv(45);
	   motor.setMarca("fiat");
	   fiat.setMotor(motor);
	   
	   cajavelocidad = new Cajavelocidad();
	   cajavelocidad.setMarchas(6);
	   cajavelocidad.setRelacion("automatica");
	   fiat.setCajavelocidad(cajavelocidad);  
	    
	   audi.setMotor(bmw.getMotor());
	   audi.setCajavelocidad(fiat.getCajavelocidad());
	   audi.setRueda(bmw.getRueda());
	   
	   System.out.print(fiat.toString());
	   System.out.print(bmw.toString());
	   System.out.print(audi.toString());  
   }

}

