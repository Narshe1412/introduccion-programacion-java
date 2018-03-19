package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelExtensiones extends JPanel{
	/**
	 * Constructor del panel datos de paciente
	 */
	public PanelExtensiones() {
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Puntos de extensión");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
	}
}
