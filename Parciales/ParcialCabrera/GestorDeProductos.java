import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class GestorDeProductos {
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";

	private static final String URLDB = "jdbc:mysql://10.128.14.3/acabrera";

	private static final String PASS = "lococaz";

	private static final String USER = "root";

	public static void altaProducto(Producto p) {
		String sqlInsert = "INSERT INTO producto (nombre, costo) VALUES ('"
				+ p.getNombre() + "', " + p.getCosto() + ")";
		try {
			Class.forName(CONTROLADOR);
			Connection conexion = DriverManager
					.getConnection(URLDB, USER, PASS);
			Statement instruccion = conexion.createStatement();
			instruccion.execute(sqlInsert);
			for (MateriaPrima mActual : p.getNMateriasPrimas()) {
				GestorDeProductos.altaMateria(mActual);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver bolo...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Problema jdbc JDBC");
			e.printStackTrace();
		}
	}

	private static void altaMateria(MateriaPrima actual) {
		String idprod = null;
		String sqlSelect = "SELECT id FROM producto WHERE nombre = '"
				+ actual.getProducto().getNombre() + "'";
		try {
			Class.forName(CONTROLADOR);
			Connection conexion = DriverManager
					.getConnection(URLDB, USER, PASS);
			Statement instruccion = conexion.createStatement();
			Statement instruccion2 = conexion.createStatement();
			// Encuentro el id_producto de la materia prima
			ResultSet resultados = instruccion.executeQuery(sqlSelect);
			if (resultados.next()) {
				idprod = resultados.getString(1);
				// System.out.println("id prod vale: " + idprod);
			}
			// Inserto materia prima
			String sqlInsert = "INSERT INTO materiaprima (nombre, costo, id_producto) VALUES ('"
					+ actual.getNombre()
					+ "', "
					+ actual.getCosto()
					+ ","
					+ idprod + ")";
			instruccion2.execute(sqlInsert);
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Problema jdbc JDBC...");
			e.printStackTrace();
		}
	}

	public static void bajaProducto(int idProd) {
		String sqlDelete = "DELETE FROM producto WHERE id = " + idProd;
		try {
			Class.forName(CONTROLADOR);
			Connection conexion = DriverManager
					.getConnection(URLDB, USER, PASS);
			Statement instruccion = conexion.createStatement();
			instruccion.execute(sqlDelete);
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver bolo...");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Problema jdbc JDBC");
			e.printStackTrace();
		}
	}

	public static void listarProductos() {
		String sqlSelect = "SELECT * FROM producto";
		try {
			Class.forName(CONTROLADOR);
			Connection conexion = DriverManager
					.getConnection(URLDB, USER, PASS);
			Statement instruccion = conexion.createStatement();
			ResultSet cjtoResultados = instruccion.executeQuery(sqlSelect);
			ResultSetMetaData cjtoResultadosMetaDatos = cjtoResultados
					.getMetaData();
			int numCol = cjtoResultadosMetaDatos.getColumnCount();
			while (cjtoResultados.next()) {
				System.out.println();
				System.out.println("--------Producto---------");
				for (int i = 1; i < numCol; i++) {
					System.out.printf(cjtoResultados.getString(i) + " ");
				}
				System.out.println();
				System.out.println("----------Materias Primas del producto------------");
				GestorDeProductos.listarMateriasDelProducto(cjtoResultados.getInt(1));
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error: Problemas con el driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Problema con JDBC!!");
			e.printStackTrace();
		}
	}
	
	public static void listarMateriasDelProducto(int idprod){
		String sqlSelect = "SELECT * FROM materiaprima WHERE id_producto = ";
		try {
			Class.forName(CONTROLADOR);
			Connection conexion = DriverManager
					.getConnection(URLDB, USER, PASS);
			Statement instruccion = conexion.createStatement();
			ResultSet cjtoResultados = instruccion.executeQuery(sqlSelect + idprod);
			ResultSetMetaData cjtoResMetaDatos = cjtoResultados.getMetaData();
			int numCol = cjtoResMetaDatos.getColumnCount();
			while(cjtoResultados.next()){
				System.out.println();
				for(int i = 1; i < numCol; i++)
					System.out.printf(cjtoResultados.getString(i) + " ");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error con el driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error con JDBC");
			e.printStackTrace();
		}
	}

	public static void modificarProducto(int idprod, String nombre, double costo) {
		String sqlUpdate = "UPDATE producto SET nombre = '"+ nombre +"', costo = '"+ costo +"' WHERE id = ";
		try {
			Class.forName(CONTROLADOR);
			Connection conexion = DriverManager
					.getConnection(URLDB, USER, PASS);
			Statement instruccion = conexion.createStatement();
			instruccion.execute(sqlUpdate + idprod);
		} catch (ClassNotFoundException e) {
			System.out.println("Error con el driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error con JDBC");
			e.printStackTrace();
		}
	}

	public static void buscarProducto(int idprod) {
		String sqlSelect = "SELECT * FROM producto WHERE id = ";
		try {
			Class.forName(CONTROLADOR);
			Connection conexion = DriverManager
					.getConnection(URLDB, USER, PASS);
			Statement instruccion = conexion.createStatement();
			ResultSet cjtoResultados = instruccion.executeQuery(sqlSelect
					+ idprod);
			ResultSetMetaData cjtoResMetaDatos = cjtoResultados
					.getMetaData();
			int numCol = cjtoResMetaDatos.getColumnCount();
			if (cjtoResultados.next())
				for (int i = 1; i < numCol; i++)
					System.out.println(cjtoResultados.getObject(i).toString());
			else
				System.out.println("No se encontro el producto.");
		} catch (ClassNotFoundException e) {
			System.out.println("Error: no se encontro el driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error con JDBC");
			e.printStackTrace();
		}

	}
}
