package com.goskarina.examenes.clases;

import java.util.Date;
import java.util.List;

public class Alumno {

	private String nombre;
	private String apellido;
	private String domicilio;
	private Date fechaDeNacimiento = new Date();
	private List<Examen> examenesRendidos;
	private long id;

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido
				+ ", domicilio=" + domicilio + ", fechaDeNacimiento="
				+ fechaDeNacimiento + ", id=" + id + "]";
	}

	public void setId(long id) {
		this.id = id;
	}

	public Alumno(String nombre, String apellido, String domicilio) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.domicilio = domicilio;
	}

	public Alumno() {
		// TODO Auto-generated constructor stub
	}

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

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public List<Examen> getExamenesRendidos() {
		return examenesRendidos;
	}

	public void setExamenesRendidos(List<Examen> examenesRendidos) {
		this.examenesRendidos = examenesRendidos;
	}

}
