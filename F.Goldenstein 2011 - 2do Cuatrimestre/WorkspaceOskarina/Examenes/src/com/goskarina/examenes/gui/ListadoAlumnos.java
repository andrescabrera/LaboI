package com.goskarina.examenes.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import com.goskarina.examenes.clases.Alumno;
import com.goskarina.examenes.persistencia.ServiceException;
import com.goskarina.examenes.persistencia.ServicioAlumno;

public class ListadoAlumnos extends JFrame {
	
	private static final long serialVersionUID = -1898396637107068864L;
	private ModeloTablaAlumno modelo = new ModeloTablaAlumno();
	private JTable tabla = new JTable (modelo);
	private JScrollPane scroll = new JScrollPane(tabla);
	private JLabel labelPrincipal = new JLabel("Listado de Alumnos");
	private JButton botonAgregar = new JButton("Agregar");
	private JButton botonModificar = new JButton("Modificar");
	private JButton botonEliminar = new JButton("Eliminar");
	private JPanel panelBotoneraABM = new JPanel();
	
	public ListadoAlumnos() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 600);
		setTitle("Listado de Alumnos");
		
		cargarTablaAlumnos();
		scroll.setSize(40, 40);
		labelPrincipal.setFont(new Font("Verdana", Font.BOLD, 24));
		labelPrincipal.setForeground(Color.BLUE);
		botonAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarDialogoAltaAlumno();		
			}
		});
		panelBotoneraABM.add(botonAgregar);
		panelBotoneraABM.add(botonModificar);
		panelBotoneraABM.add(botonEliminar);
		
		getContentPane().add(labelPrincipal, BorderLayout.NORTH);
		getContentPane().add(scroll, BorderLayout.CENTER);
		getContentPane().add(panelBotoneraABM, BorderLayout.SOUTH);	
	}
	
	protected void mostrarDialogoAltaAlumno() {
		// Abrir el JDialog con el formulario de alta alumno.
		FormularioAlumno formularioAltaAlumno = new FormularioAlumno();
		formularioAltaAlumno.setVisible(true);
		//Devolver un alumno, persistirlo y actualizar la grilla
		Alumno alumnoIngresado = formularioAltaAlumno.getAlumno();
		if(alumnoIngresado != null) {
			persistirAlumno(alumnoIngresado);
			modelo.agregarAlumno(alumnoIngresado);
		}
	}
	
	private void persistirAlumno(Alumno unAlumno) {
		ServicioAlumno servicioAlumno = new ServicioAlumno();
		try {
			servicioAlumno.alta(unAlumno);
		} catch (ServiceException e) {
			JOptionPane.showMessageDialog(this, "Problemas con la Base De Datos. No se pudo guardar el alumno.", "Error grave", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private void cargarTablaAlumnos() {
		ServicioAlumno servicioAlumno = new ServicioAlumno();
		try {
			List<Alumno> listAlumnos = servicioAlumno.listarTodos();
			for(Alumno unAlumno : listAlumnos) {
				modelo.agregarAlumno(unAlumno);	
			}
		} catch (ServiceException e) {
			JOptionPane.showMessageDialog(this, "Problemas de conectividad con la Base De Datos.", "Error grave", JOptionPane.ERROR_MESSAGE);
			System.exit(ABORT);
			e.printStackTrace();
		}
	}

//	
//	//Implement table header tool tips.
//    protected JTableHeader createDefaultTableHeader() {
//        return new JTableHeader(columnModel) {
//			private static final long serialVersionUID = 1L;
//
//			public String getToolTipText(MouseEvent e) {
//                String tip = null;
//                java.awt.Point p = e.getPoint();
//                int index = columnModel.getColumnIndexAtX(p.x);
//                int realIndex = 
//                        columnModel.getColumn(index).getModelIndex();
//                return columnToolTips[realIndex];
//            }
//        };
//    }
}
