package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelDatosMuestra extends JPanel{
	/**
	 * Constructor del panel datos de paciente
	 */
	public PanelDatosMuestra() {
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Información muestra");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
	}
}
