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
import javax.swing.JPanel;
import javax.swing.JTextField;


public class FormularioAlumno extends JDialog {
	private static final long serialVersionUID = 151913092527128855L;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDomicilio;
	private JPanel panelDatosAlumno;
	private JPanel panelBotones;
	private GridLayout organizarDatos;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnio;
	
	public FormularioAlumno() {
        setModalityType(ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Editor de Alumno");
		setSize(300,300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//PANEL DATOS DEL ALUMNO
		panelDatosAlumno = new JPanel(new GridLayout(3,2) );
		panelBotones = new JPanel();
		JLabel labelFecha = new JLabel("Fecha de Nacimiento");
		txtDia = new JTextField("01");
		txtMes = new JTextField("01");
		txtAnio = new JTextField("1900");
		JPanel panelFecha = new JPanel();
		
		panelFecha.add(labelFecha);
		panelFecha.add(txtDia);
		panelFecha.add(txtMes);
		panelFecha.add(txtAnio);		
		
		JLabel labelNombre = new JLabel("Nombre");
		JTextField txtNombre = new JTextField("");
		
		JLabel labelApellido = new JLabel("Apellido");
		JTextField txtApellido = new JTextField("");
		
		JLabel labelDomicilio = new JLabel("Domicilio");
		JTextField txtDomicilio = new JTextField("");
		
		
		panelDatosAlumno.add(labelNombre);
		panelDatosAlumno.add(txtNombre);
		panelDatosAlumno.add(labelApellido);
		panelDatosAlumno.add(txtApellido);
		panelDatosAlumno.add(labelDomicilio);
		panelDatosAlumno.add(txtDomicilio);
		
		getContentPane().add(panelDatosAlumno, BorderLayout.NORTH);
		getContentPane().add(panelFecha, BorderLayout.CENTER);
		getContentPane().add(panelBotones, BorderLayout.SOUTH);
	    
		
		//GRUPO DE BOTONES
		JButton botonAceptar = new JButton("Aceptar");		
		JButton botonCancelar = new JButton("Cancelar");
		panelBotones.add(botonAceptar);
		panelBotones.add(botonCancelar);	
		
		botonAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date fechaNacimiento = validarFecha();
				if(fechaNacimiento != null){
					//TODO devolver el control a la otra ventana.
					dispose();
				}
				
			}
		});
	}
	
	private Date validarFecha() {
		String fechaConcatenada = txtAnio.getText() + "-" + txtMes.getText() + "-" + txtDia.getText();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		try {
			Date fechaNacimiento = sdf.parse(fechaConcatenada);
			return fechaNacimiento;
		} catch (ParseException e) {
			//Mostrar advertencia con la fechaConcatendad diciendo que es incorrecta JOptionPane.showMessageDialog("Mensaje...") y no hacer nada.
			e.printStackTrace();
			return null;
		}
	}
}