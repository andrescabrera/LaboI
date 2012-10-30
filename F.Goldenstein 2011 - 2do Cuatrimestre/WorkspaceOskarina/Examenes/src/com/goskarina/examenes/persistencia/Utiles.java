package com.goskarina.examenes.persistencia;

import java.text.SimpleDateFormat;

public class Utiles {
	public static java.sql.Date convertirFecha (java.util.Date fechaJavaUtil){
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		String fechaEnString = fmt.format(fechaJavaUtil);
		java.sql.Date fechaSql = java.sql.Date.valueOf(fechaEnString);
		return fechaSql;
	}
}
