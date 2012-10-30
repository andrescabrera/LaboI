
public class Piedra implements Lastimador{
	public void lastimar(Soldado soldado){
		soldado.setEnergia(soldado.getEnergia()-10);
	}

}
