package vista;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class VistaOperario extends JPanel {

	/**
	 * Create the panel.
	 */
	public VistaOperario() {
		setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Operario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JButton btnGestionMesa = new JButton("Gestion Mesa");
		panel_1.add(btnGestionMesa);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		
		JButton btnGestionMozo = new JButton("Gestion Mozo");
		panel_4.add(btnGestionMozo);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JButton btnGestionProducto = new JButton("Gestion Producto");
		panel_2.add(btnGestionProducto);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JButton btnGestionPromociones = new JButton("Gestion Promociones");
		panel_3.add(btnGestionPromociones);
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		
		JButton btnModificarOperario = new JButton("Modificar Datos Personales");
		panel_5.add(btnModificarOperario);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		panel_6.add(btnCerrarSesion);

	}

}
