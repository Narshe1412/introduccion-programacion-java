package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelDatosPaciente extends JPanel{
	/**
	 * Constructor del panel datos de paciente
	 */
	public PanelDatosPaciente() {
		setLayout(new BorderLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Datos del paciente");
		border.setTitleColor(Color.BLUE);
		setBorder(border);
	}
}
