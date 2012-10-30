package com.goskarina.examenes.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.goskarina.examenes.clases.Alumno;

public class ServicioAlumno {

	public long alta(Alumno alumno) throws ServiceException {
		String sqlInsert = "INSERT INTO `Alumno` (`nombre`,`apellido`,`domicilio`, `fechaDeNacimiento`) VALUES (?,?,?,?)";
		
		ConnectionManager connectionManager = ConnectionManager.getInstance();
		try {
			Connection connection = connectionManager.createNewConnection();
			PreparedStatement statement = connection.prepareStatement(sqlInsert);
			statement.setString(1, alumno.getNombre());
			statement.setString(2, alumno.getApellido());
			statement.setString(3, alumno.getDomicilio());
			
			Date fechaSqlNacimiento = Utiles.convertirFecha(alumno.getFechaDeNacimiento());
			
			statement.setDate(4, fechaSqlNacimiento);
			
			long id = statement.executeUpdate();	
			connection.commit();
			return id;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServiceException("ERROR: problema con el conector JDBC.");
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceException("ERROR: problema en las sentencias SQL.");			
		}
	}

	public void eliminar(Alumno alumno) throws ServiceException {
		String sqlDelete = "DELETE FROM alumno WHERE id = ?";
		
		ConnectionManager connectionManager = ConnectionManager.getInstance();
		try {
			Connection connection = connectionManager.createNewConnection();
			PreparedStatement statement = connection.prepareStatement(sqlDelete);
			statement.setLong(1, alumno.getId());
			statement.execute();
			connection.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServiceException("ERROR: problema con el conector JDBC.");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceException("ERROR: problema en las sentencias SQL.");
		}
	}

	public void modificar(Alumno alumno) throws ServiceException {
		String sqlUpdate = "UPDATE alumno SET nombre=?, apellido=?, domicilio=?, fechaDeNacimiento=? WHERE id=?";
		ConnectionManager connectionManager = ConnectionManager.getInstance();
		try {
			Connection connection = connectionManager.createNewConnection();
			PreparedStatement statement = connection.prepareStatement(sqlUpdate);
			statement.setString(1, alumno.getNombre());
			statement.setString(2, alumno.getApellido());
			statement.setString(3, alumno.getDomicilio());
			statement.setDate(4, (java.sql.Date) alumno.getFechaDeNacimiento());
			statement.setLong(5, alumno.getId());
			statement.execute();
			connection.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServiceException("ERROR: problema con el conector JDBC.");			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ServiceException("ERROR: problema en las sentencias SQL.");			
		}
	}

	public Alumno buscarPorId(long id) throws ServiceException {
		String sqlSelectWhere = "SELECT nombre, apellido, domicilio, fechaDeNacimiento FROM alumno WHERE id=?";
		ConnectionManager connectionManager = ConnectionManager.getInstance();
		Alumno alumno = null;
		try {
			Connection connection = connectionManager.createNewConnection();
			PreparedStatement statement = connection.prepareStatement(sqlSelectWhere);
			statement.setLong(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				String domicilio = resultSet.getString("domicilio");
				java.util.Date fechaDeNacimiento = resultSet.getDate("fechaDeNacimiento");
				alumno = new Alumno(nombre, apellido, domicilio);
				alumno.setFechaDeNacimiento(fechaDeNacimiento);
				alumno.setId(id);
				
			}

			if(alumno == null) {
				throw new Exception("Persona no encontrada con el id " +id );
			}
			return alumno;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Error al encontrar a la persona");
		}
	}
	
	public List<Alumno> listarTodos() throws ServiceException {
		List<Alumno> listado = new ArrayList<Alumno>();
		String sqlSelect = "SELECT id, nombre, apellido, domicilio, fechaDeNacimiento FROM alumno";
		
		ConnectionManager connectionManager = ConnectionManager.getInstance();
		Alumno alumno = null;
		try {
			Connection connection = connectionManager.createNewConnection();
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery(sqlSelect);
			while(resultSet.next()) {
				Long id = resultSet.getLong("id");
				String nombre = resultSet.getString("nombre");
				String apellido = resultSet.getString("apellido");
				String domicilio = resultSet.getString("domicilio");
				java.util.Date fechaDeNacimiento = resultSet.getDate("fechaDeNacimiento");
				alumno = new Alumno(nombre, apellido, domicilio);
				alumno.setFechaDeNacimiento(fechaDeNacimiento);
				alumno.setId(id);
				listado.add(alumno);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Error al listar los alumnos");
		}
		
		return listado;		
	}

}
