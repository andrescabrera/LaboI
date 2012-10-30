import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.csvreader.CsvReader;

public abstract class GestorDeCuentasBancarias {

	static final String CONTROLADOR = "com.mysql.jdbc.Driver";

	static final String URLDB = "jdbc:mysql://diinsoluciones.dontexist.com/toti";

	public static ArrayList<CuentaBancaria> recuperarCuentas() {
		String sqlSelect = "SELECT * FROM cuentas";
		Connection conexion = null;
		Statement instruccion = null;
		ResultSet cjtoRes = null;
		ArrayList<CuentaBancaria> nCuentas = new ArrayList<CuentaBancaria>();
		CuentaCorriente cC = new CuentaCorriente();
		CajaDeAhorro cA = new CajaDeAhorro();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		try {
			Class.forName(CONTROLADOR);
			conexion = DriverManager.getConnection(URLDB, "toti", "132456");
			instruccion = conexion.createStatement();
			cjtoRes = instruccion.executeQuery(sqlSelect);
			while (cjtoRes.next()) {
				if (cjtoRes.getInt("id_tiposCuentas") == 1) {
					cA = new CajaDeAhorro();
					cA.setNumero(cjtoRes.getInt("numero"));
					cA.setSaldo(cjtoRes.getDouble("saldo"));
					cA.setId(cjtoRes.getInt("id"));
					clientes = recuperarClientesDeCuenta(cjtoRes.getInt("id"));
					cA.setClientes(clientes);
					nCuentas.add(cA);
				} else {
					cC = new CuentaCorriente();
					cC.setSaldo(cjtoRes.getDouble("saldo"));
					cC.setNumero(cjtoRes.getInt("numero"));
					cC.setId(cjtoRes.getInt("id"));
					cC.setClientes(recuperarClientesDeCuenta(cjtoRes
							.getInt("id")));
					nCuentas.add(cC);
				}
			}
			conexion.close();
		} catch (ClassNotFoundException e) {
			System.out.println("　Problema al cargar el Driver!!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("　Problema al realizar la consulta SQL!!");
			e.printStackTrace();
		}
		return nCuentas;
	}

	public static ArrayList<Cliente> recuperarClientesDeCuenta(int idcuenta) {
		String sqlSelectCliente = "SELECT * FROM clientes WHERE id IN (SELECT id_clientes FROM cuentasxclienta WHERE id_cuentas ="
				+ idcuenta + ")";
		Connection conexion = null;
		Statement instruccion = null;
		ResultSet cjtoRes = null;
		Cliente cliente;
		ArrayList<Cliente> nClientes = new ArrayList<Cliente>();
		try {
			Class.forName(CONTROLADOR);
			conexion = DriverManager.getConnection(URLDB, "toti", "132456");
			instruccion = conexion.createStatement();
			cjtoRes = instruccion.executeQuery(sqlSelectCliente);
			while (cjtoRes.next()) {
				cliente = new Cliente();
				cliente.setNombre(cjtoRes.getString("nombre"));
				cliente.setNumero(cjtoRes.getInt("id"));
				nClientes.add(cliente);
			}
			conexion.close();
		} catch (ClassNotFoundException e) {
			System.out.println("　Problema al cargar el Driver!!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("　Problema al realizar la consulta SQL!!");
			e.printStackTrace();
		}
		return nClientes;
	}

	public static ArrayList<Cliente> recuperarClientes() {
		Connection conexion = null;
		Statement instruccion = null;
		ResultSet cjtoRes = null;
		ArrayList<Cliente> nClientes = new ArrayList<Cliente>();
		Cliente clienteActual;
		String sqlRecuperarClientes = "SELECT * FROM clientes";
		try {
			Class.forName(CONTROLADOR);
			conexion = DriverManager.getConnection(URLDB, "toti", "132456");
			instruccion = conexion.createStatement();
			cjtoRes = instruccion.executeQuery(sqlRecuperarClientes);
			while (cjtoRes.next()) {
				clienteActual = new Cliente();
				clienteActual.setNombre(cjtoRes.getString("nombre"));
				clienteActual.setNumero(cjtoRes.getInt("id"));
				ArrayList<CuentaBancaria> cuentasCliente = recuperarCuentasDelCliente(cjtoRes
						.getInt("id"));
				clienteActual.setCuentasBancarias(cuentasCliente);
				nClientes.add(clienteActual);
			}
			conexion.close();
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: Problemas con el Driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("ERROR: JDBC!");
			e.printStackTrace();
		}
		return nClientes;
	}

	public static ArrayList<CuentaBancaria> recuperarCuentasDelCliente(int idcliente) {
		String sqlRecuperarCuentasDelCliente = "SELECT * FROM cuentas WHERE id IN (SELECT id_cuentas FROM cuentasxclienta WHERE id_clientes ="
				+ idcliente + ")";
		Connection conexion = null;
		Statement instruccion = null;
		ResultSet cjtoRes = null;
		ArrayList<CuentaBancaria> nCuentas = new ArrayList<CuentaBancaria>();
		try {
			Class.forName(CONTROLADOR);
			conexion = DriverManager.getConnection(URLDB, "toti", "132456");
			instruccion = conexion.createStatement();
			cjtoRes = instruccion.executeQuery(sqlRecuperarCuentasDelCliente);
			while (cjtoRes.next()) {
				if (cjtoRes.getInt("id_tiposCuentas") == 1) {
					CajaDeAhorro cA = new CajaDeAhorro();
					cA.setNumero(cjtoRes.getInt("numero"));
					cA.setSaldo(cjtoRes.getDouble("saldo"));
					nCuentas.add(cA);
				} else {
					CuentaCorriente cC = new CuentaCorriente();
					cC.setNumero(cjtoRes.getInt("numero"));
					cC.setSaldo(cjtoRes.getDouble("saldo"));
					nCuentas.add(cC);
				}
			}
			conexion.close();
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR: Problema con el driver!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("ERROR: Problema con el SQL!");
			e.printStackTrace();
		}
		return nCuentas;
	}

	public static void generarCsv(String sFileName, ArrayList<CuentaBancaria> cuentas) {
		try {
			FileWriter writer = new FileWriter(sFileName);
			writer.append("Tipo");
			writer.append(',');
			writer.append("NumeroDeCuenta");
			writer.append(',');
			writer.append("Saldo");	
			writer.append('\n');

			for (CuentaBancaria cActual : cuentas) {
				if(cActual instanceof CajaDeAhorro){
					writer.append("Caja de Ahorro");
				} else {
					writer.append("Cuenta Corriente");
				}
				writer.append(',');
				writer.append("" + cActual.getNumero());
				writer.append(',');
				writer.append("" + cActual.getSaldo());
				writer.append('\n');
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<CuentaBancaria> cargarCsv(String sFileName){
	ArrayList<CuentaBancaria> nCuentas = new ArrayList<CuentaBancaria>();
	try {
		CsvReader reader = new CsvReader(sFileName);
		reader.readHeaders(); //salteo las cabeceras
		while(reader.readRecord()){
			String tipoCuenta = reader.get(0);
			if(tipoCuenta == "Caja De Ahorro"){
				CajaDeAhorro cActual = new CajaDeAhorro();
				cActual.setNumero(Integer.parseInt(reader.get(1)));
				cActual.setSaldo(Double.parseDouble(reader.get(2)));
				nCuentas.add(cActual);
			} else {
				CuentaCorriente cActual = new CuentaCorriente();
				cActual.setNumero(Integer.parseInt(reader.get(1)));
				cActual.setSaldo(Double.parseDouble(reader.get(2)));
				nCuentas.add(cActual);
			}
		}
		reader.close();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return nCuentas;
	}

	public static void insertarCuenta(CuentaBancaria actual) {
		int tipoCuenta;
		if (actual instanceof CajaDeAhorro){
			tipoCuenta = 1;
		} else {
			tipoCuenta = 2;
		}
		String sqlInsert = "INSERT INTO cuentas(numero, saldo, id_tiposCuentas) VALUES ("+ actual.getNumero() +","+ actual.getSaldo() +","+tipoCuenta+")";
		try {
			Class.forName(CONTROLADOR);
			Connection conexion = DriverManager.getConnection(URLDB, "toti", "132456");
			Statement instruccion = conexion.createStatement();
			instruccion.execute(sqlInsert);
			conexion.close();
		} catch (ClassNotFoundException e) {
			System.out.println("Driver no encontrado");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error de SQL");
			e.printStackTrace();
		}
	}
	
	public static String devolverCuentaEnXml(CuentaBancaria cuenta){
		//<cuenta-bancaria><numero></numero><saldo></saldo></cuenta-bancaria>
		String stringXml = "<cuenta-bancaria>\n\t<numero>\n\t"+cuenta.getNumero()+"\n\t</numero>\n\t<saldo>\n\t"+cuenta.getSaldo()+"\n\t</saldo>\n</cuenta-bancaria>";
		
		return stringXml;
	}
	
}