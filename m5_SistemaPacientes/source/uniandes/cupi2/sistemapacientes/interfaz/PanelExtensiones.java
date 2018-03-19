package uniandes.cupi2.sistemapacientes.interfaz;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelExtensiones extends JPanel implements ActionListener{
	/**
	 * Interfaz principal de la aplicación
	 */
	private InterfazSistemaPacientes principal;
	
	/**
	 * El comando para avanzar
	 */
	private static final String AVANZAR = "AVANZAR";
	
	/**
	 * El comando retroceder
	 */
	private static final String RETROCEDER = "RETROCEDER";
	
	/**
	 * Comando para la opcion 1
	 */
	private final String OPCION_1 = "opcion 1";
	
	/**
	 * Comando para la opcion 2
	 */
	private final String OPCION_2 = "opcion 2";
	
	// Botones de navegacion
	private JButton btnAvanzar;
	private JButton btnRetroceder;
	private JButton btnOpcion1;
	private JButton btnOpcion2;

	/**
	 * Constructor del panel datos de paciente
	 */
	public PanelExtensiones(InterfazSistemaPacientes v) {
		principal = v;
		setLayout(new FlowLayout());
		TitledBorder border = BorderFactory.createTitledBorder("Puntos de extensión");
		border.setTitleColor(Color.BLUE);
		setBorder(border);

		// Creacción de botones
		btnAvanzar = new JButton(">");
		btnAvanzar.setActionCommand(AVANZAR);
		btnAvanzar.addActionListener(this);
		btnRetroceder = new JButton("<");
		btnRetroceder.setActionCommand(RETROCEDER);
		btnRetroceder.addActionListener(this);
		btnOpcion1 = new JButton("Opción 1");
		btnOpcion1.setActionCommand(OPCION_1);
		btnOpcion1.addActionListener(this);
		btnOpcion2 = new JButton("Opción 2");
		btnOpcion2.setActionCommand(OPCION_2);
		btnOpcion2.addActionListener(this);

		// Botones añadidos al panel
		add(btnRetroceder);
		add(btnOpcion1);
		add(btnOpcion2);
		add(btnAvanzar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		switch(comando) {
		case AVANZAR:
			principal.avanzar();
			break;
		case RETROCEDER:
			principal.retroceder();
			break;
		case OPCION_1:
			principal.reqFuncOpcion1();
			break;
		case OPCION_2:
			principal.reqFuncOpcion2();
			break;
		}
		
	}
}
