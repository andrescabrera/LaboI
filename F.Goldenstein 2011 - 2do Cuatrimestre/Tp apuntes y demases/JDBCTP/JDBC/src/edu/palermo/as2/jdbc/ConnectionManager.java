/*
 * Created on 19/05/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.palermo.as2.jdbc;


import java.sql.*;

/**
 * @author Claudioz
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public final class ConnectionManager {
	
	private Connection connection = null;
	private static ConnectionManager instance = null;
	
	/**
	 * Permite la existencia de una única instanciaç
	 * de connectionManager en toda la app java.
	 */
	public static ConnectionManager getInstance() {
		if(instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	/**
	 * !!! Importante !!!
	 * En la realidad esto tendría que estar manejado por un pool de conexiones
	 */
	public Connection createNewConnection() throws ClassNotFoundException, SQLException {
		/*
		 * http://hsqldb.org/
		 */
		if(connection == null) {
			Class.forName("org.hsqldb.jdbcDriver");
			connection = DriverManager.getConnection("jdbc:hsqldb:palermodb", "sa", "");
			connection.setAutoCommit(false);
		}
		return connection;
	}

    public void shutdown() throws SQLException {
    	if(connection != null) { 
	        Statement st = connection.createStatement();
	        st.execute("SHUTDOWN");
	        connection.close();
    	}
    }
	
}
