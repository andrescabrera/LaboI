import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GestorDeCuentasBancarias {
	
	static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	static final String URLDB = "jdbc:mysql://127.0.0.1/toti";
		
	public void recuperarCuentas(){
		String sqlSelect = "SELECT * FROM cuentabancaria";
		Connection conexion = null;
		Statement instruccion = null;
		ResultSet cjtoRes = null;
		ResultSetMetaData cjtoResMetaDatos = null;
		ArrayList nCuentas = new ArrayList();
		try {
			Class.forName(CONTROLADOR);
			conexion = DriverManager.getConnection(URLDB, "toti", "132456");
			instruccion = conexion.createStatement();
			cjtoRes = instruccion.executeQuery(sqlSelect);
			cjtoResMetaDatos = cjtoRes.getMetaData();
			int numColumnas = cjtoResMetaDatos.getColumnCount();
			while(cjtoRes.next())
			{
				CuentaBancaria cuenta = new CuentaBancaria(); 
				for(int i = 1; i <= numColumnas; i++)
					 cuenta.set= cjtoRes.getObject(i).toString();
				nCuentas.add()
			}
			conexion.close();
		} catch (ClassNotFoundException e) {
			System.out.println("¡¡Problema al cargar el Driver!!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("¡¡Problema al realizar la consulta SQL!!");
			e.printStackTrace();
		}
	}
	
	public void agregarCuentaBancaria(){
		
	}
}
