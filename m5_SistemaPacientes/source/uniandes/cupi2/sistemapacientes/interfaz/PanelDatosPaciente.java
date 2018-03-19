package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelDatosPaciente extends JPanel{
	// Etiqueta y zona de texto para nombre
	private JLabel labNombre;
	private JTextField txtNombre;
	// Apellido
	private JLabel labApellido;
	private JTextField txtApellido;
	// Fecha de nacimiento
	private JLabel labFNacimiento;
	private JTextField txtFNacimiento;
	// Sexo
	private JLabel labSexo;
	private JTextField txtSexo;
	
	// Imagen
	private JLabel labImagen;
	
	//Boton y texto para calcular la edad
	private JButton butEdad;
	private JTextField txtEdad;
	
	
	/**
	 * Constructor del panel datos de paciente
	 */
	public PanelDatosPaciente() {
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Datos del paciente");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
		
		//Panel para mostrar la foto del paciente
		JPanel panelFoto;
		
		//Panel para mostrar la información del paciente
		JPanel panelInformacion;
		
		//Creacción y localización de los panels
		panelFoto = new JPanel();
		panelInformacion = new JPanel();
		
		add(panelFoto, BorderLayout.EAST);
		add(panelInformacion, BorderLayout.CENTER);
		
		// Creacción de elementos para la interfaz
		// Nombre
		labNombre = new JLabel("Nombre: ");
		txtNombre = new JTextField(15);
		txtNombre.setEditable(false);
		txtNombre.setBackground(Color.LIGHT_GRAY);
		txtNombre.setForeground(Color.BLUE);
		
		// Apellido
		labApellido = new JLabel("Apellido: ");
		txtApellido = new JTextField(15);
		txtApellido.setEditable(false);
		txtApellido.setBackground(Color.LIGHT_GRAY);
		txtApellido.setForeground(Color.BLUE);
		
		// Sexo
		labSexo = new JLabel("Sexo: ");
		txtSexo = new JTextField(2);
		txtSexo.setEditable(false);
		txtSexo.setBackground(Color.LIGHT_GRAY);
		txtSexo.setForeground(Color.BLUE);
		
		// Fecha de nacimiento
		labFNacimiento = new JLabel("Fecha de nacimiento: ");
		txtFNacimiento = new JTextField(10);
		txtFNacimiento.setEditable(false);
		txtFNacimiento.setBackground(Color.LIGHT_GRAY);
		txtFNacimiento.setForeground(Color.BLUE);
		
		// Edad
		butEdad = new JButton("Calcular Edad");
		txtEdad = new JTextField(10);
		txtEdad.setEditable(false);
		
		// Añadir elementos al panel
		panelInformacion.setLayout(new GridLayout(6,2));
		panelInformacion.add(labNombre);
		panelInformacion.add(txtNombre);
		panelInformacion.add(labApellido);
		panelInformacion.add(txtApellido);
		panelInformacion.add(labSexo);
		panelInformacion.add(txtSexo);
		panelInformacion.add(labFNacimiento);
		panelInformacion.add(txtFNacimiento);
		panelInformacion.add(butEdad);
		panelInformacion.add(txtEdad);

		// Foto
		labImagen = new JLabel("FOTO");
		panelFoto.add(labImagen);
	}
}
