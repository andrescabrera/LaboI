import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Soldado soldado1 = new Soldado();
		soldado1.setEnergia(100);
		soldado1.setNombre("Juan");
		Soldado soldado2 = new Soldado();
		soldado2.setEnergia(100);
		soldado2.setNombre("Ramon");
		while (soldado1.getEnergia() > 0 && soldado2.getEnergia() > 0) {
			pelear(soldado1, soldado2);
			System.out.println("Soldado " + soldado1.getNombre()
					+ " peleando a " + soldado2.getNombre() + " solo le queda "
					+ soldado2.getEnergia());
			if (soldado2.getEnergia() > 0) {
				pelear(soldado2, soldado1);
				System.out.println("Soldado " + soldado2.getNombre()
						+ " peleando a " + soldado1.getNombre()
						+ " solo le queda " + soldado1.getEnergia());
			}
		}
	}

	public static void pelear(Soldado soldado1, Soldado soldado2) {
		int numero;
		Random r = new Random();
		numero = r.nextInt(100);
		if (numero < 25)
			soldado1.lastimador(soldado2, new Cuchillo());
		else if (numero < 50)
			soldado1.lastimador(soldado2, new Revolver());
		else if (numero < 75)
			soldado1.lastimador(soldado2, new Metralladora());
		else
			soldado1.lastimador(soldado2, new Piedra());
	}
}
