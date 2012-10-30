
public class ClaseCremita {
	
	private int unaVariableEntera;
	public static int unNumero;
	
	public ClaseCremita () {
		this.hacerOtraCosa();
		System.out.println("Aca me crearon, soy la clase: " + this.getClass().getName());
	}
	
	public static void hacerAlgo() {
		//unaVariableEntera = 0; //Error de la vida
		unNumero = 0;
		System.out.println("Estoy haciendo algo con unNumero: " + unNumero);
		//this.hacerOtraCosa(); //Horror de la vida
	}
	
	private void hacerOtraCosa() {
		ClaseCremita.hacerAlgo();
		System.out.println("Hago otra cosa con unaVariableEntera: " + unaVariableEntera);
	}
	
}
