/*
 * Created on 19/05/2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package edu.palermo.as2.bo;

/**
 * @author Claudioz
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Persona {
	public long id;
	private String nombre = "";
	private String direccion = "";
	private double sueldo;
	private int edad;

	public Persona() {};
	
	public Persona(String nombre, String direccion, int edad, double sueldo) {
		this.direccion = direccion;
		this.nombre = nombre;
		this.edad = edad;
		this.sueldo = sueldo;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getSueldo() {
		return sueldo;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
