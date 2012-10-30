package com.goskarina.examenes.beans;
import java.util.ArrayList;


public class Tema {
	private int codigoTema;
	private String descripcion;
	private ArrayList<Pregunta> nPreguntas = new ArrayList<Pregunta>();
	
	public int getCodigoTema() {
		return codigoTema;
	}
	public void setCodigoTema(int codigoTema) {
		this.codigoTema = codigoTema;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public ArrayList<Pregunta> getnPreguntas() {
		return nPreguntas;
	}
	public void setnPreguntas(ArrayList<Pregunta> nPreguntas) {
		this.nPreguntas = nPreguntas;
	}
	
	
	
	

}
