package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import uniandes.cupi2.sistemapacientes.mundo.SistemaPacientes;

public class InterfazSistemaPacientes extends JFrame{

	/*
	 * Este metodo ejecuta la aplicacion creando una nueva interfaz e inicializandola
	 * @params args no utilizados para esta aplicación
	 * */
	public static void main(String[] args) {
		InterfazSistemaPacientes interfaz = new InterfazSistemaPacientes();
		interfaz.setVisible(true);

	}
	
	/*
	 * Clase principal del mundo
	 * */
	
	private SistemaPacientes sistemaPacientes;
	
	public InterfazSistemaPacientes() {
		setTitle("Sistema de Pacientes");
		setSize(700,450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//Crea la clase principal
		sistemaPacientes = new SistemaPacientes();
	}

}
