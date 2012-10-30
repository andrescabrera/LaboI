import java.util.ArrayList;
import java.util.List;

public class Edficio {

	public static void main(String[] args) {
		List<Ascensor> ascensoresDelEdificio = new ArrayList<Ascensor>();
		
		ascensoresDelEdificio.add(new Ascensor());
		ascensoresDelEdificio.add(new Ascensor());
		ascensoresDelEdificio.add(new Ascensor());
		ascensoresDelEdificio.add(new Ascensor());
		
		Ascensor ascensor1 = ascensoresDelEdificio.get(1);
		Ascensor ascensor2 = ascensoresDelEdificio.get(2);
		
		System.out.println("Piso mas alto: " + Ascensor.getPisoMasAlto());
		System.out.println("Piso actual: "+ascensor1.getPisoActual());
		ascensor1.subirCantidadPisos(4);
		System.out.println("Piso actual: "+ascensor1.getPisoActual());
		ascensor1.subirCantidadPisos(3);
		System.out.println("Piso actual: "+ascensor1.getPisoActual());
		ascensor1.irAUnPiso(3);
		System.out.println("Piso actual: "+ascensor1.getPisoActual());
		
		System.out.println("Piso actual: "+ascensor2.getPisoActual());
		ascensor2.subirCantidadPisos(2);
		System.out.println("Piso actual: "+ascensor2.getPisoActual());
		ascensor2.subirCantidadPisos(15);
		System.out.println("Piso actual: "+ascensor2.getPisoActual());
		ascensor2.irAUnPiso(1);
		System.out.println("Piso actual: "+ascensor2.getPisoActual());
		ascensor2.irAUnPiso(-1);
		System.out.println("Piso actual: "+ascensor2.getPisoActual());
		
	}

}
