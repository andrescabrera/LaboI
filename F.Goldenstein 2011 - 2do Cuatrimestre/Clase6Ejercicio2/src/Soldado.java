public class Soldado {
	private int energia;
	private String nombre;

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

	public void lastimador(Soldado soldado, Revolver revolver) {
		System.out.println("Estoy tirando con un revolver");
		revolver.lastimar(soldado);
	}

	public void lastimador(Soldado soldado, Cuchillo cuchillo) {
		System.out.println("Estoy tirando con un cuchillo");
		cuchillo.lastimar(soldado);
	}

	public void lastimador(Soldado soldado, Metralladora metralladora) {
		System.out.println("Estoy tirando con una metralladora");
		metralladora.lastimar(soldado);
	}

	public void lastimador(Soldado soldado, Piedra piedra) {
		System.out.println("Estoy tirando con una piedra");
		piedra.lastimar(soldado);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}
}