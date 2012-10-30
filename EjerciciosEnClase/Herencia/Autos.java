
abstract class Autos {
	
	private String patente;
	private String color;
	private int CantidadDePuertas;
		
		public int getCantidadDePuertas() {
			return CantidadDePuertas;
		}
		public void setCantidadDePuertas(int cantidadDePuertas) {
			CantidadDePuertas = cantidadDePuertas;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getPatente() {
			return patente;
		}
		public void setPatente(String patente) {
			this.patente = patente;
		}
		//metodos abstractos
		public abstract void avanzar();
}
