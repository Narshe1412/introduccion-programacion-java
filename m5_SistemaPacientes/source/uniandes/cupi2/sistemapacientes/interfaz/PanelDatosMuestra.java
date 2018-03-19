package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelDatosMuestra extends JPanel implements ActionListener {
	/**
	 * Interfaz principal de la aplicación
	 */
	private InterfazSistemaPacientes principal;
	// Etiqueta y zona de texto para fecha de la toma de muestra
	private JLabel labFTomaMuestra;
	private JTextField txtFTomaMuestra;
	// Volumen de la muestra
	private JLabel labVolumenMuestra;
	private JTextField txtVolumenMuestra;
	// Volumen de eritrocitos
	private JLabel labVolumenEritrocitos;
	private JTextField txtVolumenEritrocitos;
	// Conteo Leucocitos
	private JLabel labConteoLeucocitos;
	private JTextField txtConteoLeucocitos;
	// Conteo Plaquetas
	private JLabel labConteoPlaquetas;
	private JTextField txtConteoPlaquetas;

	// Check si la muestra se tomó en ayunas
	private JCheckBox cbAyunas;

	// Boton y texto para calcular hematocrito
	private JButton butHematocrito;
	private JTextField txtHematocrito;
	// Boton y texto para calcular leucocito
	private JButton butLeucocito;
	private JTextField txtLeucocito;

	/**
	 * El comando para la opción en ayunas
	 */
	private final static String AYUNAS = "En ayunas";

	/**
	 * El comando para el boton de calcular el hematocrito
	 */
	private final static String CALCULAR_HEMATOCRITO = "CALCULAR HEMATOCRITO";

	/**
	 * El comando para el boton de calcular los leucocitos
	 */
	private final static String CALCULAR_LEUCOCITOS = "CALCULAR LEUCOCITOS";

	/**
	 * Constructor del panel datos de paciente
	 * @param v pantalla principal de la aplicación para usar como controlador 
	 */
	public PanelDatosMuestra(InterfazSistemaPacientes v) {
		principal = v;
		setLayout(new GridLayout(6, 4));
		TitledBorder border = BorderFactory.createTitledBorder("Información muestra");
		border.setTitleColor(Color.BLUE);
		setBorder(border);

		// Creacción de elementos para la interfaz
		// Fecha Toma de Muestra
		labFTomaMuestra = new JLabel("Fecha Toma de Muestra: ");
		txtFTomaMuestra = new JTextField(10);
		txtFTomaMuestra.setEditable(false);
		txtFTomaMuestra.setBackground(Color.LIGHT_GRAY);
		txtFTomaMuestra.setForeground(Color.BLUE);

		// Check de muestra en ayunas
		cbAyunas = new JCheckBox("Ayunas");
		cbAyunas.setActionCommand(AYUNAS);
		cbAyunas.addActionListener(this);

		// Volumen de la muestra
		labVolumenMuestra = new JLabel("Volumen de Muestra: ");
		txtVolumenMuestra = new JTextField(10);
		txtVolumenMuestra.setEditable(true);
		txtVolumenMuestra.setBackground(Color.WHITE);
		txtVolumenMuestra.setForeground(Color.BLUE);

		// Volumen de Eritrocitos
		labVolumenEritrocitos = new JLabel("Volumen Eritrocitos: ");
		txtVolumenEritrocitos = new JTextField(10);
		txtVolumenEritrocitos.setEditable(true);
		txtVolumenEritrocitos.setBackground(Color.WHITE);
		txtVolumenEritrocitos.setForeground(Color.BLUE);

		// Boton Calcular Hematocrito
		butHematocrito = new JButton("Calcular Hematocrito");
		butHematocrito.setActionCommand(CALCULAR_HEMATOCRITO);
		butHematocrito.addActionListener(this);
		txtHematocrito = new JTextField(10);
		txtHematocrito.setEditable(false);

		// Conteo de Leucocitos
		labConteoLeucocitos = new JLabel("Conteo de Leucocitos: ");
		txtConteoLeucocitos = new JTextField(10);
		txtConteoLeucocitos.setEditable(true);
		txtConteoLeucocitos.setBackground(Color.WHITE);
		txtConteoLeucocitos.setForeground(Color.BLUE);

		// Boton Calcular Leucocitos
		butLeucocito = new JButton("Calcular Leucocito");
		butLeucocito.setActionCommand(CALCULAR_LEUCOCITOS);
		butLeucocito.addActionListener(this);
		txtLeucocito = new JTextField(10);
		txtLeucocito.setEditable(false);

		// Conteo de Plaquetas
		labConteoPlaquetas = new JLabel("Conteo de Plaquetas: ");
		txtConteoPlaquetas = new JTextField(10);
		txtConteoPlaquetas.setEditable(true);
		txtConteoPlaquetas.setBackground(Color.WHITE);
		txtConteoPlaquetas.setForeground(Color.BLUE);

		add(labFTomaMuestra);
		add(txtFTomaMuestra);
		add(new JLabel());
		add(cbAyunas);
		add(labVolumenMuestra);
		add(txtVolumenMuestra);
		add(new JLabel());
		add(new JLabel());
		add(labVolumenEritrocitos);
		add(txtVolumenEritrocitos);
		add(butHematocrito);
		add(txtHematocrito);
		add(labConteoLeucocitos);
		add(txtConteoLeucocitos);
		add(butLeucocito);
		add(txtLeucocito);
		add(labConteoPlaquetas);
		add(txtConteoPlaquetas);
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
		add(new JLabel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch (comando) {
		case CALCULAR_HEMATOCRITO:
			principal.calcularHematocrito();
			break;
		case CALCULAR_LEUCOCITOS:
			principal.calcularLeucocito();
			break;
		case AYUNAS:
			principal.cambiarEnAyunas();
			break;
		}
	}

	/**
	 * Metodo que muestra el valor de hematocrito recibido por parametro en el campo
	 * de texto
	 * 
	 * @param pHematocrito
	 *            cantidad de hematocrito
	 */
	public void mostrarHematocrito(String pHematocrito) {
		txtHematocrito.setText(pHematocrito + "");
	}

	/**
	 * Metodo que muestra el valor de leucocito recibido por parametro en el campo
	 * de texto
	 * 
	 * @param pLeucocito
	 *            cantidad de leucocito
	 */
	public void mostrarLeucocito(String pLeucocito) {
		txtLeucocito.setText(pLeucocito + "");
	}

	/**
	 * Metodo que muestra el valor de en ayudas recibidp por parametro
	 * 
	 * @param pEnAyunas
	 *            indica true or false dependiendo si la muestra se tomo en ayunas o
	 *            no
	 */
	public void mostrarAyunas(boolean pEnAyunas) {
		cbAyunas.setSelected(pEnAyunas);
	}

	/**
	 * Metodo que devuelve el vloumen de la muestra que haya ingresado el usuario en
	 * el campo correspondiente
	 * 
	 * @return el volumen de la muestra
	 */
	public String darVolumenMuestra() {
		String rta = txtVolumenMuestra.getText();
		return rta;
	}

	/**
	 * Metodo que devuelve el vloumen de eritrocitos que haya ingresado el usuario
	 * en el campo correspondiente
	 * 
	 * @return el volumen de eritrocitos
	 */
	public String darVolumenEritrocitos() {
		String rta = txtVolumenEritrocitos.getText();
		return rta;
	}

	/**
	 * Metodo que devuelve el vloumen de eritrocitos que haya ingresado el usuario
	 * en el campo correspondiente
	 * 
	 * @return el conteo de leucocitos
	 */
	public String darConteoLeucocitos() {
		String rta = txtConteoLeucocitos.getText();
		return rta;
	}

	/**
	 * Metodo que devuelve el vloumen de plaquetas que haya ingresado el usuario en
	 * el campo correspondiente
	 * 
	 * @return el conteo de plaquetas
	 */
	public String darConteoPlaquetas() {
		String rta = txtConteoPlaquetas.getText();
		return rta;
	}

	/**
	 * MEtodo que devuelve el valor true o false de la caja en ayunas dependiendo de
	 * si está marcado o no la caja de chequeo
	 * 
	 * @return true o false
	 */
	public boolean estaEnAyunas() {
		return cbAyunas.isSelected();
	}
	
	/**
	 * Limpia los campos de texto del panel
	 */
	public void limpiarCampos() {
		txtHematocrito.setText("");
		txtLeucocito.setText("");
	}
	
	/**
	 * Actualiza los campos del panel con los datos que se pasan por parámetro
	 * @param pFechaMuestra fecha de toma de la muestra
	 * @param pEnAyunas indica si la muestra fue en ayunas o no
	 * @param pVolumenMuestra indica el volumen de la muestra
	 * @param pVolumenEritrocitos indica el volumen encontrado de eritrocitos
	 * @param pConteoLeuocitos indica el conteo de leucocitos
	 * @param pConteoPlaquetas indica el conteo de plaquetas
	 */
	public void actualizarCampos(String pFechaMuestra, boolean pEnAyunas, double pVolumenMuestra, double pVolumenEritrocitos, int pConteoLeuocitos, int pConteoPlaquetas) {
		txtFTomaMuestra.setText(pFechaMuestra);
		txtVolumenMuestra.setText(pVolumenMuestra + "");
		txtVolumenEritrocitos.setText(pVolumenEritrocitos + "");
		txtConteoLeucocitos.setText(pConteoLeuocitos + "");
		txtConteoPlaquetas.setText(pConteoPlaquetas + "");
		cbAyunas.setSelected(pEnAyunas);
	}
}
