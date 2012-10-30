package com.goskarina.examenes.beans;

import java.util.ArrayList;
import java.util.Date;

public class Persona {
	private String nombre;
	private String apellido;
	private Date fechaNacimiento;
	private String domicilio;
	private ArrayList<ModeloDeExamen> nModelosDeExamenes = new ArrayList<ModeloDeExamen>();
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public ArrayList<ModeloDeExamen> getnModelosDeExamenes() {
		return nModelosDeExamenes;
	}
	public void setnModelosDeExamenes(ArrayList<ModeloDeExamen> nModelosDeExamenes) {
		this.nModelosDeExamenes = nModelosDeExamenes;
	}
	
	
	
	

}
