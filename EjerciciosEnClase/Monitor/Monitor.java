class Monitor {
	// redefinicion de metodo toString() heredado de la clase Object

	public String toString() {

		return marca + "," + modelo + "," + color;
	}

	String marca;

	String modelo;

	String color;

	boolean estaEncendido;

	Monitor() {
	}

	Monitor(String marca, String modelo, String color) {
		// con el this agarro la var de est
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
	}

	void encender() {
		if (estaEncendido)
			System.out.println("El monitor ya estaba encendido");
		else {
			estaEncendido = true;
			System.out.println("Encender");
		}
	}

	void apagar() {
		if (estaEncendido) {
			estaEncendido = false;
			System.out.println("Apagar");
		} else
			System.out.println("Ya estaba apagado");
	}
}
