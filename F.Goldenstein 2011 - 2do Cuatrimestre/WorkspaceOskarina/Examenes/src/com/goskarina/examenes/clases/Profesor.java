package com.goskarina.examenes.clases;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Profesor implements Examinador {
	
	private String nombre;
	private String apellido;
	private String domicilio;
	private Date fechaDeNacimiento;
	private long id;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public void corregirExamen(Examen examen) {
		// TODO Auto-generated method stub

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

	@Override
	public ModeloDeExamen generarExamen(
			Map<Tema, Integer> cantidadDePreguntasPorTema) {
		ModeloDeExamen modelo = new ModeloDeExamen();
		Iterator itr = cantidadDePreguntasPorTema.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry e = (Map.Entry) itr.next();
			Tema tema = (Tema) e.getKey();
			Integer cantidadPreguntas = (Integer) e.getValue();
			// TODO exception: ver si se le pasa mayor cantidad de preguntas que
			// se disponga en el tema
			for (int i = 0; i < cantidadPreguntas; i++) {
				modelo.getPreguntasDelExamen().add(tema.getPreguntasDelTema().get(i));
			}
		}
		return modelo;
	}
}
