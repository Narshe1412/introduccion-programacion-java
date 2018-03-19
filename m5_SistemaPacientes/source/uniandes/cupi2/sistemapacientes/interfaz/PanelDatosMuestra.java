package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelDatosMuestra extends JPanel {
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
	 * Constructor del panel datos de paciente
	 */
	public PanelDatosMuestra() {
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
}
