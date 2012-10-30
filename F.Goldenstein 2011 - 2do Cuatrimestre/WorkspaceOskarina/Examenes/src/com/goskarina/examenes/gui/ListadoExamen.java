package com.goskarina.examenes.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.goskarina.examenes.clases.Alumno;
import com.goskarina.examenes.persistencia.ServiceException;
import com.goskarina.examenes.persistencia.ServicioAlumno;

public class ListadoExamen {
	
	private ModeloTablaExamen modelo = new ModeloTablaExamen();
	private JTable tabla = new JTable (modelo);
	private JScrollPane scroll = new JScrollPane(tabla);
	private JLabel labelPrincipal = new JLabel("Listado de Examenes");
	private JButton botonAgregar = new JButton("Agregar");
	private JButton botonModificar = new JButton("Modificar");
	private JButton botonEliminar = new JButton("Eliminar");
	private JPanel panelBotoneraABM = new JPanel();
	
	public ListadoExamen() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(900, 600);
		setTitle("Listado de Examenes");
		
		cargarTablaExamen();
		scroll.setSize(40, 40);
		labelPrincipal.setFont(new Font("Verdana", Font.BOLD, 24));
		labelPrincipal.setForeground(Color.BLUE);
		botonAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarDialogoAltaExamen();		
			}
		});
		panelBotoneraABM.add(botonAgregar);
		panelBotoneraABM.add(botonModificar);
		panelBotoneraABM.add(botonEliminar);
		
		getContentPane().add(labelPrincipal, BorderLayout.NORTH);
		getContentPane().add(scroll, BorderLayout.CENTER);
		getContentPane().add(panelBotoneraABM, BorderLayout.SOUTH);	
	}
	
	protected void mostrarDialogoAltaExamen() {
		// Abrir el JDialog con el formulario de alta examen.
		FormularioExamen formularioAltaExamen = new FormularioExamen();
		formularioAltaExamen.setVisible(true);
		//Devolver un examen, persistirlo y actualizar la grilla
		Examen examenIngresado = formularioAltaExamen.getExamen();
		if(examenIngresado != null) {
			persistirExamen(examenIngresado);
			modelo.agregarExamen(examenIngresado);
		}
	}
	
	private void persistirExamen(Examen unExamen) {
		ServicioExamen servicioExamen = new ServicioExamen();
		try {
			servicioExamen.alta(unExamen);
		} catch (ServiceException e) {
			JOptionPane.showMessageDialog(this, "Problemas con la Base De Datos. No se pudo guardar el alumno.", "Error grave", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	private void cargarTablaExamen() {
		ServicioExamen servicioExamen = new ServicioExamen();
		try {
			List<Examen> listExamen = servicioExamen.listarTodos();
			for(Examen unExamen : listExamen) {
				modelo.agregarExamen(unExamen);	
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

}
