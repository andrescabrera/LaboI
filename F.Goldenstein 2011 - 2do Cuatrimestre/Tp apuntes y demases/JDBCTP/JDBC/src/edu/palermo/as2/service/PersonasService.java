/*
 * Created on 19/05/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.palermo.as2.service;

import edu.palermo.as2.bo.Persona;
import edu.palermo.as2.jdbc.ConnectionManager;
import java.sql.*;
import java.util.Collection;

/**
 * @author Claudioz
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PersonasService {
	
	//statement.execute("CREATE TABLE Personas (id INTEGER IDENTITY, nombre VARCHAR(100), direccion VARCHAR(100),edad INTEGER, salario DOUBLE)");
	
	public Persona crearUnaNuevaPersona(String nombre, String direccion, int edad, double sueldo) throws ServiceException {
		ConnectionManager connectionManager = ConnectionManager.getInstance();
		try {
			Connection connection = connectionManager.createNewConnection();
			Statement statement = connection.createStatement();
			
			String sql = "INSERT INTO Personas VALUES(null, '" + nombre + "','" + direccion + "'," + edad + "," + sueldo + ")";
			statement.execute(sql);
			
			ResultSet rs = statement.executeQuery("CALL IDENTITY()");
			rs.next();
			int id = rs.getInt(1);	

			 
			connection.commit();
			
			Persona persona = new Persona(nombre, direccion, edad, sueldo);
			persona.setId(id);
			
			return persona;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Error al crear a la persona");
		}
	}
	
	
	public Persona buscarPersonaPorId(long id) throws ServiceException {
		ConnectionManager connectionManager = ConnectionManager.getInstance();
		try {
			Connection connection = connectionManager.createNewConnection();
			Statement statement = connection.createStatement();
			
			String sql = "SELECT nombre, direccion, edad, salario FROM Personas WHERE id = " + id;
			Persona persona = null;
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()) {
				String nombre = rs.getString("nombre");
				String direccion = rs.getString("direccion");
				int edad = rs.getInt("edad");
				double salario = rs.getDouble("salario");
				persona = new Persona(nombre, direccion, edad, salario);
				persona.setId(id);
			}

			if(persona == null) {
				throw new ServiceException("Persona no encontrada con el id " +id );
			}
			return persona;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Error al encontrar a la persona");
		}
	}
	
	public Collection listadoDePersonas() {
		return null;
	}
	
	public Collection listadoDePersonas(String nombre) {
		return null;
	}
}
