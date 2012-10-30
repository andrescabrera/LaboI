
public class Revolver extends Arma implements Lastimador {
	public void lastimar(Soldado soldado){
		soldado.setEnergia(soldado.getEnergia()-50);
	}

}
