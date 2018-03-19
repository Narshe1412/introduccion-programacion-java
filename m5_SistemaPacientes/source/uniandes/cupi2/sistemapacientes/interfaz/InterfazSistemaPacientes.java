package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.cupi2.sistemapacientes.mundo.Paciente;
import uniandes.cupi2.sistemapacientes.mundo.SistemaPacientes;

@SuppressWarnings("serial")
public class InterfazSistemaPacientes extends JFrame {

	/**
	 * Este metodo ejecuta la aplicacion creando una nueva interfaz e
	 * inicializandola
	 * 
	 * @params args no utilizados para esta aplicación
	 */
	public static void main(String[] args) {
		InterfazSistemaPacientes interfaz = new InterfazSistemaPacientes();
		interfaz.setVisible(true);
	}

	/**
	 * Clase principal del mundo
	 */

	private SistemaPacientes sistemaPacientes;

	/**
	 * Panel contenedor de datos del paciente
	 */
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
	 * Constructor de la interfaz inicializada con los datos del sistema de
	 * pacientes <br>
	 */
	public InterfazSistemaPacientes() {
		setTitle("Sistema de Pacientes");
		setSize(700, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Crea la clase principal
		sistemaPacientes = new SistemaPacientes();

		// Paneles de la ventana principal
		panelDatosPaciente = new PanelDatosPaciente(this);
		panelDatosMuestra = new PanelDatosMuestra(this);
		panelExtensiones = new PanelExtensiones(this);

		add(panelDatosPaciente, BorderLayout.NORTH);
		add(panelDatosMuestra, BorderLayout.CENTER);
		add(panelExtensiones, BorderLayout.SOUTH);
	}

	/**
	 * Avance al siguiente paciente y actualiza la información de la interfaz
	 */
	public void avanzar() {
		Paciente actual = sistemaPacientes.darPacienteSiguiente();
		actualizarInfoPaciente(actual);
	}

	/**
	 * Retrocede al paciente anterior y actualiza la información de la interfaz
	 */
	public void retroceder() {
		Paciente actual = sistemaPacientes.darPacienteAnterior();
		actualizarInfoPaciente(actual);
	}

	/**
	 * Calcula la edad del paciente basandose en una fecha formato dd-M-yyyy y el día actual
	 */
	public void calcularEdad() {
		String pFechaN = sistemaPacientes.darPacienteActual().darFechaNacimiento();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-M-yyyy");
		LocalDate fechaNac = LocalDate.parse(pFechaN, formatter); 
		LocalDate now = LocalDate.now();
		
		int anios = Period.between(fechaNac, now).getYears();
		panelDatosPaciente.mostrarEdad(anios);
	}

	/**
	 * Calcula el valor de la muestra del paciente
	 */
	public void calcularHematocrito() {
		String pVolumenMuestra = panelDatosMuestra.darVolumenMuestra();
		String pVolumenEritrocitos = panelDatosMuestra.darVolumenEritrocitos();

		if (pVolumenMuestra.trim().equals("") || pVolumenEritrocitos.trim().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe ingresar los datos.", "Calcular Hematocrito",
					JOptionPane.ERROR_MESSAGE);
		} else if (pVolumenMuestra.trim().matches("[0123456789.]*")
				&& pVolumenEritrocitos.trim().matches("[0123456789.]*")) {
			double volumenMuestra = Double.parseDouble(pVolumenMuestra.trim());
			double volumenEritrocitos = Double.parseDouble(pVolumenEritrocitos.trim());

			sistemaPacientes.darPacienteActual().cambiarVolumenMuestra(volumenMuestra);
			sistemaPacientes.darPacienteActual().cambiarVolumenEritrocitos(volumenEritrocitos);

			double hematocrito = sistemaPacientes.darPacienteActual().calcularHematocrito();
			hematocrito = Math.round(hematocrito * 100.0) / 100.0;
			panelDatosMuestra.mostrarHematocrito(" " + hematocrito);
		} else {
			JOptionPane.showMessageDialog(this, "Los datos ingresados no son correctos.", "Calcular hematocrito",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Metodo para calcular el conteo de leucocitos
	 */
	public void calcularLeucocito() {
		String pConteoLeucocitos = panelDatosMuestra.darConteoLeucocitos();
		String pVolumenEritrocitos = panelDatosMuestra.darVolumenEritrocitos();
		String pVolumenMuestra = panelDatosMuestra.darVolumenMuestra();

		if (pVolumenMuestra.trim().equals("") 
				|| pVolumenEritrocitos.trim().equals("")
				|| pConteoLeucocitos.trim().equals("")) 
		{
			JOptionPane.showMessageDialog(this, "Debe ingresar los datos.", "Calcular Leucocitos",
					JOptionPane.ERROR_MESSAGE);
		} else if (pVolumenMuestra.trim().matches("[0123456789.]*")
				&& pVolumenEritrocitos.trim().matches("[0123456789.]*")
				&& pConteoLeucocitos.trim().matches("[0123456789.]*")) 
		{
			double volumenMuestra = Double.parseDouble(pVolumenMuestra.trim());
			double volumenEritrocitos = Double.parseDouble(pVolumenEritrocitos.trim());
			int conteoLeucocitos = Integer.parseInt(pConteoLeucocitos.trim());

			sistemaPacientes.darPacienteActual().cambiarVolumenMuestra(volumenMuestra);
			sistemaPacientes.darPacienteActual().cambiarVolumenEritrocitos(volumenEritrocitos);
			sistemaPacientes.darPacienteActual().cambiarConteoLeucocitos(conteoLeucocitos);

			double leucocitos = sistemaPacientes.darPacienteActual().calcularLeucocitos();
			leucocitos = Math.round(leucocitos * 100.0) / 100.0;
			panelDatosMuestra.mostrarLeucocito(" " + leucocitos);
		} else {
			JOptionPane.showMessageDialog(this, "Los datos ingresados no son correctos.", "Calcular leucocitos",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Muestra un mensaje indicando si la persona está en ayunas o no
	 */
	public void cambiarEnAyunas() {
		if (panelDatosMuestra.estaEnAyunas()) {
			JOptionPane.showMessageDialog(this, "En ayunas", "Estado", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "No en ayunas", "Estado", JOptionPane.INFORMATION_MESSAGE);
		}

	}

	/**
	 * MEtodo para la extensión 1
	 */
	public void reqFuncOpcion1() {
		String resultado = sistemaPacientes.metodo1();
		JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * MEtodo para la extensión 2
	 */
	public void reqFuncOpcion2() {
		String resultado = sistemaPacientes.metodo2();
		JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Actualiza la información del paciente dado por parámetro
	 * 
	 * @param pPaciente
	 *            Paciente del cual se mostraron los datos
	 */
	public void actualizarInfoPaciente(Paciente pPaciente) {
		String nombre = pPaciente.darNombre();
		String apellido = pPaciente.darApellido();

		int iSexo = pPaciente.darSexo();
		String sexo = (iSexo == 2) ? "M" : "F";

		String fechaTomaMuestra = pPaciente.darFechaTomaMuestra();
		String fechaN = pPaciente.darFechaNacimiento();
		String imagen = pPaciente.darImagen();
		double volumenMuestra = pPaciente.darVolumenMuestra();
		double volumenEritrocitos = pPaciente.darVolumenEritrocitos();
		int conteoLeucocitos = pPaciente.darConteoLeucocitos();
		int conteoPlaquetas = pPaciente.darConteoPlaquetas();
		boolean enAyunas = pPaciente.darEnAyunas();

		panelDatosPaciente.actualizarCampos(nombre, apellido, sexo, fechaN, imagen);
		panelDatosMuestra.actualizarCampos(fechaTomaMuestra, enAyunas, volumenMuestra, volumenEritrocitos,
				conteoLeucocitos, conteoPlaquetas);
		panelDatosMuestra.limpiarCampos();
	}

}
