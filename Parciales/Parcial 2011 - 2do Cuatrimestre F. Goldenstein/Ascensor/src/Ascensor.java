import java.util.Random;

public class Ascensor {
	public static int pisoMasAlto = generarPisoMasAlto();
	public static int pisoMasBajo = 0;
	private int pisoActual = 0;

	public int getPisoActual() {
		return pisoActual;
	}

	public void irAUnPiso(int numeroPisoQueDeboIr) {
		if ((numeroPisoQueDeboIr > pisoActual)
				&& (numeroPisoQueDeboIr <= pisoMasAlto)) { // subir pisos
			while (pisoActual != numeroPisoQueDeboIr) {
				pisoActual++;
				System.out.println("Estoy en el piso " + pisoActual);
			}
		} else { // bajar pisos
			if ((numeroPisoQueDeboIr > pisoMasBajo)
					&& (numeroPisoQueDeboIr < pisoActual)) {
				while (pisoActual != numeroPisoQueDeboIr) {
					pisoActual--;
					System.out.println("Estoy en el piso " + pisoActual);
				}
			} else {
				System.out.println("Error: piso ingresado incorrecto.");
			}
		}
	}

	public void subirCantidadPisos(int cantidadPisosASubir) {
		if ((pisoActual + cantidadPisosASubir) <= pisoMasAlto) {
			// Me habia equivocado en este for
			for (int i = 0; i < cantidadPisosASubir; i++) {
				pisoActual++;
				System.out.println("Estoy en el piso " + pisoActual);
			}
		} else {
			System.out.println("No existe el piso "
					+ (pisoActual + cantidadPisosASubir));
		}
	}

	public static int getPisoMasAlto() {
		return pisoMasAlto;
	}

	public static int getPisoMasBajo() {
		return pisoMasBajo;
	}

	public static int generarPisoMasAlto() {
		int pisoMasAlto = 0;
		Random r = new Random();
		pisoMasAlto = r.nextInt(15) + 10;
		return pisoMasAlto;
	}
}
