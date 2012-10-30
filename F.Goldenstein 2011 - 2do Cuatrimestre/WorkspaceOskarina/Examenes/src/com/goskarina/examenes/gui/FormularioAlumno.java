package com.goskarina.examenes.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.goskarina.examenes.clases.Alumno;

public class FormularioAlumno extends JDialog {
	
	private static final long serialVersionUID = 151913092527128855L;
	
	//El alumno que voy a cargar
	private Alumno alumno;
	
	//Variables de estado, para que sean accesibles desde los metodos...
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnio;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDomicilio;
	
	public FormularioAlumno() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Editor de Alumno");
		setSize(300, 300);
		
		// PANEL DATOS DEL ALUMNO
		JPanel panelDatosAlumno = new JPanel(new GridLayout(3, 2));
		JPanel panelBotones = new JPanel();
		JLabel labelFecha = new JLabel("Fecha de Nacimiento");
		txtDia = new JTextField("01", 10);
		txtMes = new JTextField("01", 10);
		txtAnio = new JTextField("1900", 10);
		JPanel panelFecha = new JPanel();
		
		panelFecha.add(labelFecha);
		panelFecha.add(txtDia);
		panelFecha.add(txtMes);
		panelFecha.add(txtAnio);

		JLabel labelNombre = new JLabel("Nombre");
		txtNombre = new JTextField("");

		JLabel labelApellido = new JLabel("Apellido");
		txtApellido = new JTextField("");

		JLabel labelDomicilio = new JLabel("Domicilio");
		txtDomicilio = new JTextField("");

		panelDatosAlumno.add(labelNombre);
		panelDatosAlumno.add(txtNombre);
		panelDatosAlumno.add(labelApellido);
		panelDatosAlumno.add(txtApellido);
		panelDatosAlumno.add(labelDomicilio);
		panelDatosAlumno.add(txtDomicilio);

		getContentPane().add(panelDatosAlumno, BorderLayout.NORTH);
		getContentPane().add(panelFecha, BorderLayout.CENTER);
		getContentPane().add(panelBotones, BorderLayout.SOUTH);

		// GRUPO DE BOTONES
		JButton botonAceptar = new JButton("Aceptar");
		JButton botonCancelar = new JButton("Cancelar");
		panelBotones.add(botonAceptar);
		panelBotones.add(botonCancelar);
		
		botonCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		});
		
		botonAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {				
				// Instancio el alumno
				crearAlumno();
				// Y devuelvo el control a la otra ventana.
				dispose();
			}
		});
	}

	protected void crearAlumno() {
		Date fechaNacimiento = parsearYValidarFecha();
		if (fechaNacimiento != null) {
			alumno = new Alumno(txtNombre.getText(), txtNombre.getText(), txtDomicilio.getText());
			alumno.setFechaDeNacimiento(fechaNacimiento);
		} else {
			JOptionPane.showMessageDialog(getParent(), "Fecha ingresada incorrectamente", "Error en fecha" ,JOptionPane.ERROR_MESSAGE);
		}
	}

	private Date parsearYValidarFecha() {
		String fechaConcatenada = txtAnio.getText() +"-"+ txtMes.getText() +"-"+txtDia.getText();
		System.out.println(fechaConcatenada);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date fechaNacimiento = sdf.parse(fechaConcatenada);
			return fechaNacimiento;
		} catch (ParseException e) {
			// Mostrar advertencia con la fechaConcatendad diciendo que es
			// incorrecta JOptionPane.showMessageDialog("Mensaje...") y no hacer
			// nada.
			e.printStackTrace();
			return null;
		}
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
}