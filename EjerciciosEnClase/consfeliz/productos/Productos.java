package productos;

public class Productos {
		
		private double precio;
		
		public void calcularPrecio(){
			System.out.println("El precio es: " +precio);			
		}
		
		public void calcularPrecio(double iva){
			double pfin = ((precio / 100) *21) + precio;
			System.out.println("El precio final es: " +pfin);
		}
		
		public void calcularPrecio(double iva, double dto){
			double parcial = (precio - dto);
			double pfin = ((parcial / 100) *21) + parcial;
			
			System.out.println("El precio final es: " + pfin);			
		}

		public double getPrecio() {
			return precio;
		}

		public void setPrecio(double precio) {
			this.precio = precio;
		}
}
