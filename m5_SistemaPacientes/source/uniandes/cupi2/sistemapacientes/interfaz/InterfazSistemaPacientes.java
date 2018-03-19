package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import uniandes.cupi2.sistemapacientes.mundo.SistemaPacientes;

public class InterfazSistemaPacientes extends JFrame{

	/**
	 * Este metodo ejecuta la aplicacion creando una nueva interfaz e inicializandola
	 * @params args no utilizados para esta aplicación
	 * */
	public static void main(String[] args) {
		InterfazSistemaPacientes interfaz = new InterfazSistemaPacientes();
		interfaz.setVisible(true);

	}
	
	/**
	 * Clase principal del mundo
	 * */
	
	private SistemaPacientes sistemaPacientes;
	
	/**
	 * Panel contenedor de datos del paciente
	 * */
	private PanelDatosPaciente panelDatosPaciente;
	
	/**
	 * Panel de elementos para realizar consultas sobre el paciente
	 */
	private PanelDatosMuestra panelDatosMuestra;
	
	/**
	 * Panel que contiene los elementos para ejecutar extensiones y navegación
	 */
	private PanelExtensiones panelExtensiones;
	
	/**
	 * Constructor de la interfaz inicializada con los datos del sistema de pacientes <br>
	 */
	public InterfazSistemaPacientes() {
		setTitle("Sistema de Pacientes");
		setSize(700,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//Crea la clase principal
		sistemaPacientes = new SistemaPacientes();
		
		//Paneles de la ventana principal
		panelDatosPaciente = new PanelDatosPaciente();
		panelDatosMuestra = new PanelDatosMuestra();
		panelExtensiones = new PanelExtensiones();
		
		add(panelDatosPaciente, BorderLayout.NORTH);
		add(panelDatosMuestra, BorderLayout.CENTER);
		add(panelExtensiones, BorderLayout.SOUTH);
	}

}
