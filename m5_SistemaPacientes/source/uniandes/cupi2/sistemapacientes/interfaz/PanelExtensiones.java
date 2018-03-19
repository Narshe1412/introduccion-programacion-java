package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelExtensiones extends JPanel {
	// Botones de navegacion
	private JButton btnAvanzar;
	private JButton btnRetroceder;
	private JButton btnOpcion1;
	private JButton btnOpcion2;

	/**
	 * Constructor del panel datos de paciente
	 */
	public PanelExtensiones() {
		setLayout(new FlowLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Puntos de extensi�n");
		border.setTitleColor(Color.BLUE);
		setBorder(border);

		// Creacci�n de botones
		btnAvanzar = new JButton(">");
		btnRetroceder = new JButton("<");
		btnOpcion1 = new JButton("Opci�n 1");
		btnOpcion2 = new JButton("Opci�n 2");

		// Botones a�adidos al panel
		add(btnRetroceder);
		add(btnOpcion1);
		add(btnOpcion2);
		add(btnAvanzar);
	}
}
