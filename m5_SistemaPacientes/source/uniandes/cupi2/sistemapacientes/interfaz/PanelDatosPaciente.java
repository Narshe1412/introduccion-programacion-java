package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelDatosPaciente extends JPanel implements ActionListener{
	/**
	 * Interfaz principal de la aplicación
	 */
	private InterfazSistemaPacientes principal;
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

	// Boton y texto para calcular la edad
	private JButton butEdad;
	private JTextField txtEdad;
	
	/**
	 * El comando para el boton de calcular la edad del paciente
	 */
	private final static String CALCULAR_EDAD = "CALCULAR EDAD";

	/**
	 * Constructor del panel datos de paciente
	 * @param v pantalla principal de la aplicación para usar como controlador 
	 */
	public PanelDatosPaciente(InterfazSistemaPacientes v) {
		principal = v;
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Datos del paciente");
		border.setTitleColor(Color.BLUE);
		setBorder(border);

		// Panel para mostrar la foto del paciente
		JPanel panelFoto;

		// Panel para mostrar la información del paciente
		JPanel panelInformacion;

		// Creacción y localización de los panels
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
		butEdad.setActionCommand(CALCULAR_EDAD);
		butEdad.addActionListener(this);
		txtEdad = new JTextField(10);
		txtEdad.setEditable(false);

		// Añadir elementos al panel
		panelInformacion.setLayout(new GridLayout(6, 2));
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
		labImagen = new JLabel();
		panelFoto.add(labImagen);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch(comando) {
		case CALCULAR_EDAD:
			principal.calcularEdad();
			break;
		}
	}
	
	/**
	 * Metodo que coloca el valor de la edad en la caja de texto correspondiente de la interfaz
	 * @param pEdad el valor de la edad en número
	 */
	public void mostrarEdad(int pEdad) {
		txtEdad.setText(pEdad + "");
	}
	
	/**
	 * Metodo que devuelve el valor de edad en el cuadro de edad 
	 * @return valor numérico del campo de texto de edad
	 */
	public int darEdad() {
		String rta = txtEdad.getText();
		return Integer.parseInt(rta);
	}
	
	/**
	 * Limpia los campos de texto del panel
	 */
	public void limpiarCampos() {
		txtEdad.setText("");
	}
	
	/**
	 * Actualiza los campos del panel con la informacion del paciente
	 * @param pNombre nombre del paciente
	 * @param pApellido apellido del paciente
	 * @param pSexo sexo del paciente
	 * @param pFechaN fecha de nacimiento del paciente
	 * @param pImagen ruta donde se encuentra la foto
	 */
	public void actualizarCampos(String pNombre, String pApellido, String pSexo, String pFechaN, String pImagen) {
		txtNombre.setText(pNombre);
		txtApellido.setText(pApellido);
		txtSexo.setText(pSexo);
		txtFNacimiento.setText(pFechaN);
		labImagen.setIcon(new ImageIcon(pImagen));
		txtEdad.setText("");
	}
}
