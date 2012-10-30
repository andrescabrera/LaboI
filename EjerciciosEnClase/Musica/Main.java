import java.sql.Date;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CdMusica aux = null;

		for (int i = 0; i < 50; i++) {

			Autor a = new Autor();
			a.setCodigo(i);
			a.setNombre("N"+i);

			Genero g = new Genero();
			g.setCodigo(i);
			g.setNombre("N" + i);

			CdMusica cd = new CdMusica();
			cd.setCodigo(i);
			cd.setTitulo("T" + i);
			cd.setDate(new Date(2010, 7, 24));
			cd.setPrecio((float) Math.random() * 20);
			cd.setAutor(a);
			cd.setGenero(g);

			if (aux == null)
				aux = cd;
			else if (cd.getPrecio() > aux.getPrecio())
				aux = cd;
			
			System.out.println(cd);
		}
		
		System.out.println(aux);
	}
}
