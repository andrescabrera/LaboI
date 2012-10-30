package com.goskarina.examenes.persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.goskarina.examenes.clases.Alumno;
import com.goskarina.examenes.clases.Examen;

public class ServicioExamen {
	public long alta(Examen examen) throws ServiceException {
		String sqlInsert = "INSERT INTO `Examen` (`nota`, `id_Alumno`,`id_ModeloDeExamen`, `id_Examinador`) VALUES (?,?,?,?)";
		
		ConnectionManager connectionManager = ConnectionManager.getInstance();
		try {
			Connection connection = connectionManager.createNewConnection();
			PreparedStatement statement = connection.prepareStatement(sqlInsert);
			statement.setString(1, examen.getNota());
			statement.setString(2, examen.getId_Alumno());
			statement.setString(3, examen.getId_ModeloDeExamen());
			statement.setString(4, examen.getId_Examinador());
			
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

	public void eliminar(Examen examen) throws ServiceException {
		String sqlDelete = "DELETE FROM examen WHERE id = ?";
		
		ConnectionManager connectionManager = ConnectionManager.getInstance();
		try {
			Connection connection = connectionManager.createNewConnection();
			PreparedStatement statement = connection.prepareStatement(sqlDelete);
			statement.setLong(1, examen.getId());
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

	public void modificar(Examen examen) throws ServiceException {
		String sqlUpdate = "UPDATE alumno SET nota=?, id_Alumno=?, id_ModeloDeExamen=?, id_Examinador=? WHERE id=?";
		ConnectionManager connectionManager = ConnectionManager.getInstance();
		try {
			Connection connection = connectionManager.createNewConnection();
			PreparedStatement statement = connection.prepareStatement(sqlUpdate);
			statement.setString(1, examen.getNota());
			statement.setString(2, examen.getId_Alumno());
			statement.setString(3, examen.getId_ModeloDeExamen());
			statement.setString(4, examen.getId_Examinador());
			statement.setLong(5, examen.getId());
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

	public Examen buscarPorId(long id) throws ServiceException {
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

}
