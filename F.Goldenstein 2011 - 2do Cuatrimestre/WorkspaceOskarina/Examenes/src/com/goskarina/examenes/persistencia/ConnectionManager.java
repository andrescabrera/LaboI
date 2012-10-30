package com.goskarina.examenes.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {
	//VER http://www.chuidiang.com/java/mysql/BasicDataSource-Pool-Conexiones.php
	private Connection connection = null;
	private static ConnectionManager instance = null;
	
	public static ConnectionManager getInstance() {
		if(instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}
	
	public Connection createNewConnection () throws ClassNotFoundException, SQLException {
		if(connection == null) {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/examenes", "root", "terabyte");
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
